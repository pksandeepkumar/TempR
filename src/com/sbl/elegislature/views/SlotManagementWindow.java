/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbl.elegislature.data.SaveSlot;
import com.sbl.elegislature.data.groups.Group;
import com.sbl.elegislature.data.groups.GroupType;
import com.sbl.elegislature.data.reporterusers.GroupMembers;
import com.sbl.elegislature.models.pojo.group_member.GroupMemberPOJO;
import com.sbl.elegislature.models.pojo.group_member.ReporterGroup;
import com.sbl.elegislature.models.pojo.group_member.ReporterGroupType;
import com.sbl.elegislature.models.pojo.group_member.ReprterMember;
import com.sbl.elegislature.models.pojo.grouptype.GroupTypeData;
import com.sbl.elegislature.models.pojo.grouptype.GroupTypePOJO;
import com.sbl.elegislature.models.pojo.timeslots.GetAllTimeSlotsPOJO;
import com.sbl.elegislature.models.pojo.timeslots.SlotData;
import static com.sbl.elegislature.service.GeneralService.generalServiceInstance;
import com.sbl.elegislature.util.AppContext;
import com.sbl.elegislature.util.ReporterUtility;
import static com.sbl.elegislature.views.GroupManagementWindow.BTN_TITLE_UPDATE;
import com.sbl.elegislature.views.baseviews.BaseWindow;
import com.sbl.elegislature.views.baseviews.SBorderPane;
import com.sbl.elegislature.views.baseviews.SButton;
import com.sbl.elegislature.views.baseviews.SScrollpane;
import com.sbl.elegislature.views.baseviews.SVBox;
import com.sbl.elegislature.views.controlls.TimePicker;
import com.sbl.elegislature.views.controlls.TimeSlotEntry;
import com.sbl.elegislature.views.controlls.TimeSlotEntryHeader;
import com.sun.deploy.association.utility.AppUtility;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 *
 * @author sandeep
 */
public class SlotManagementWindow extends SBorderPane {

    Button btnSave;
    
    boolean isUpdate = false;

    int width;

    SVBox vBoxSlotsContainer;

    List<TimeSlotEntry> timeSlotEntry;

    List<SaveSlot> saveSlotsList = null;

    TimePicker timePickerStartTime;

    Map<Integer, GroupTypeData> groupTypeMap = new HashMap<>();


    public SlotManagementWindow(int width) {
        this.width = width;
        initViews();
    }

    @Override
    public void refreshWindow() {
        
        if( !checkSessionDateSelected()) {
            return;
        }
        
        vBoxSlotsContainer.getChildren().clear();
        fetchgroupTypeList();
        
        GetAllTimeSlotsPOJO allTimeSlotsPOJO = generalServiceInstance()
                .getAllTimeSlots(AppContext.selectedSessionDateId);
        
        if(allTimeSlotsPOJO != null) {
            if(allTimeSlotsPOJO.getData() != null) {
                isUpdate = true;
                saveSlotsList = new ArrayList<>();
                for(SlotData data : allTimeSlotsPOJO.getData()) {
                    saveSlotsList.add(new SaveSlot(data));
                }
            }
        }
        
        if(!isUpdate) {
            loadGroupInfo();
        }
        
        if (saveSlotsList == null) {
            return;
        }
        timeSlotEntry = new ArrayList<>();
        for (SaveSlot data : saveSlotsList) {
            TimeSlotEntry entry = new TimeSlotEntry(width, data);
            vBoxSlotsContainer.getChildren().add(entry);
            timeSlotEntry.add(entry);
        }
    }

    private void initViews() {
        setWidth(width);

        setTop(getTopPane());
        
//        SScrollpane scrollPane = new SScrollpane();
//        scrollPane.setStyle("-fx-background-color:transparent;");
//        scrollPane.setWidth(width);
//        scrollPane.setPadding(10);

        SVBox vBoxBody = new SVBox();
        setWidth(width);
        setLeft(vBoxBody);

        vBoxSlotsContainer = new SVBox();
        vBoxSlotsContainer.setWidth(width);
//        vBoxSlotsContainer.setPadding(10);
//        scrollPane.setContent(vBoxSlotsContainer);

        TimeSlotEntryHeader entryHeader = new TimeSlotEntryHeader(width);
        vBoxBody.getChildren().add(entryHeader);
        vBoxBody.getChildren().add(vBoxSlotsContainer);

    }

    private SBorderPane getTopPane() {
        SBorderPane topPane = new SBorderPane();
        topPane.setWidth(width);
        topPane.setPadding(10);
        HBox vBoxStartTime = new HBox();
        vBoxStartTime.getChildren().add(new Label("Start Time:"));
        timePickerStartTime = new TimePicker();
        SButton btnLoad = new SButton("Load");
        HBox.setMargin(btnLoad, new Insets(0, 0, 0, 10));

        btnLoad.setOnAction(e -> {
            loadTime();
        });

        vBoxStartTime.getChildren().add(timePickerStartTime);
        vBoxStartTime.getChildren().add(btnLoad);
        topPane.setLeft(vBoxStartTime);

        btnSave = new Button("Save");
        btnSave.setOnAction(e -> {
            save();
        });
//        SBorderPane bpForButton = new SBorderPane();
//        bpForButton.setWidth(width);
//        bpForButton.setRight(btnSave);
//        bpForButton.setPadding(5);
        topPane.setRight(btnSave);

        return topPane;
    }
    
    private void save() {
         for (TimeSlotEntry slotEntryView : timeSlotEntry) {
             slotEntryView.loadSavedSlotData();
         }
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            // get Employee object as a json string
            String jsonStr = mapper.writeValueAsString(saveSlotsList);
            System.err.println("save time slot:" + jsonStr);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(SlotManagementWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTime() {
        if (!timePickerStartTime.isValidTime()) {
            return;
        }
        Date date = timePickerStartTime.getDateObject();

        System.err.println("timePickerStartTime:" + timePickerStartTime.getTime());
        System.err.println("getHours:" + date.getHours());
        System.err.println("getMinutes:" + date.getMinutes());

        if (timeSlotEntry == null) {
            return;
        }
        boolean first = true;
        Date lastTime = new Date(date.getTime());
        for (TimeSlotEntry slotEntryView : timeSlotEntry) {
            if (first) {
                slotEntryView.timePickerStart.setTime(timePickerStartTime.getHour(),
                        timePickerStartTime.getMinute());
                int duration = getDurationInMinute(slotEntryView.saveSlot.getGroupTypeId());
                if (duration != 0) {
                    lastTime = ReporterUtility.addMinute(lastTime, duration);
                    slotEntryView.timePickerEnd.setTime(lastTime.getHours() + 1, lastTime.getMinutes() + 1);
                } else {
                    break;
                }
                first = false;
                continue;
            }

            slotEntryView.timePickerStart.setTime(lastTime.getHours() + 1,
                    lastTime.getMinutes() + 1);
            int duration = getDurationInMinute(slotEntryView.saveSlot.getGroupTypeId());
            if (duration != 0) {
                lastTime = ReporterUtility.addMinute(lastTime, duration);
                slotEntryView.timePickerEnd.setTime(lastTime.getHours() + 1, lastTime.getMinutes() + 1);
            } else {
                break;
            }
            

        }

    }

    private int getDurationInMinute(int groupId) {
        int duratiion = 0;
        GroupTypeData groupTypeData = groupTypeMap.get(groupId);
        if (groupTypeData != null) {
            return groupTypeData.getDurationForSlot();
        }
        return duratiion;
    }

    private boolean checkSessionDateSelected() {
        if (AppContext.selectedSessionDateId != 0) {
//            setMessage("");
            return true;
        }
//        setMessage("Please choose a session date");
        return false;
    }

    private void loadGroupInfo() {

        if (!checkSessionDateSelected()) {
            return;
        }
        saveSlotsList = new ArrayList<>();

        GroupMemberPOJO groupMemberPOJO = generalServiceInstance()
                .getGroupMemberPOJO(AppContext.selectedSessionDateId);

        if (groupMemberPOJO != null) {
//            initTreeData();
            if (groupMemberPOJO.getData() != null) {
                if (groupMemberPOJO.getData().getReporterGroupTypes() != null) {
                    for (ReporterGroupType reporterGroupType : groupMemberPOJO.getData().getReporterGroupTypes()) {

                        if (reporterGroupType.getReporterGroup() != null) {
                            for (ReporterGroup reporterGroup : reporterGroupType.getReporterGroup()) {
                                SaveSlot saveSlot = new SaveSlot(reporterGroup.getId(), reporterGroup.getName(),
                                        AppContext.application().employeeId);
                                saveSlot.setGroupTypeId(reporterGroupType.getId());
                                saveSlotsList.add(saveSlot);
                            }
                        }
                    }
                }
            }
        }
    }

    private void fetchgroupTypeList() {
        if (groupTypeMap.size() > 0) {
            return;
        }
        GroupTypePOJO groupTypePOJO = generalServiceInstance().getGroupTypePojo();
        if (groupTypePOJO != null) {
            List<GroupTypeData> groupTypeDataList = groupTypePOJO.getData();
            if (groupTypeDataList != null) {
                groupTypeDataList.forEach((data) -> {
                    groupTypeMap.put(data.getId(), data);
                });
            }
        }
    }

}
