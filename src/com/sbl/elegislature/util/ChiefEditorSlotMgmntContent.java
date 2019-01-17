/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbl.elegislature.data.SaveSlot;
import com.sbl.elegislature.data.Slot;
import com.sbl.elegislature.data.groups.Group;
import com.sbl.elegislature.data.groups.GroupType;
import com.sbl.elegislature.data.reporterusers.GroupMembers;
import com.sbl.elegislature.data.reporterusers.Reporters;
import static com.sbl.elegislature.service.GeneralService.generalServiceInstance;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ContextMenuBuilder;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class ChiefEditorSlotMgmntContent extends BorderPane {

    TableView<Slot> slotManageTable;
    ObjectMapper mapper;
    ObservableList<Slot> slotList;
    List<Slot> tempslotsList;

    public ChiefEditorSlotMgmntContent() {
        mapper = new ObjectMapper();
                /*------------------------------ slotManageTable methods------------------------------------------*/
                  slotManageTable=new TableView();
        slotManageTable.setEditable(true);
        slotManageTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        slotManageTable.getSelectionModel().cellSelectionEnabledProperty().set(true);
        TableColumn<Slot, Integer> slotId = new TableColumn<Slot, Integer>("Slot Id");
        slotId.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn<Slot, Date> start_Time = new TableColumn<Slot, Date>("start time");
        start_Time.setCellValueFactory(new PropertyValueFactory("startTime"));
        TableColumn<Slot, Date> end_Time = new TableColumn<Slot, Date>("end time");
        end_Time.setCellValueFactory(new PropertyValueFactory("endTime"));
        slotManageTable.getColumns().addAll(slotId, start_Time, end_Time);
        slotManageTable.getColumns().add(createColumn("group_no", Slot::groupIdProperty));
        slotList = FXCollections.observableArrayList(
                new Slot(new Time(1, 2, 3), new Time(1, 2, 3)),
                 new Slot(new Time(1, 2, 3), new Time(1, 2, 3)),
                  new Slot(new Time(1, 2, 3), new Time(1, 2, 3))
        //                new Slot(2, "2", new Date(), new Date()),
        //                new Slot(3, "3", new Date(), new Date()),
        //                new Slot(4, "4", new Date(), new Date()),
        //                new Slot(5, "5", new Date(), new Date()),
        //                new Slot(6, "6", new Date(), new Date()),
        //                new Slot(7, "7", new Date(), new Date())
        );

        slotManageTable.getItems().addAll(slotList);
        /*-------------Fetching  time slot  from db---------------------*/
        slotManageTable=showSlotList(mapper);

        slotManageTable.setOnKeyPressed(event -> {
            TablePosition<Slot, ?> pos = slotManageTable.getFocusModel().getFocusedCell();
            if (pos != null && event.getCode().isLetterKey()) {
                slotManageTable.edit(pos.getRow(), pos.getTableColumn());
            }
        });
        
        
        
        
        StackPane mainCointainer = new StackPane();
        mainCointainer.getChildren().addAll(slotManageTable);//userListViewPane,groupTreeViewPane);
        setCenter(mainCointainer);

        
    }
    
       private <T> TableColumn<T, String> createColumn(String title, Function<T, StringProperty> property) {
        TableColumn<T, String> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));

        col.setCellFactory(column -> EditCell.createStringEditCell());
        return col;
    }
       
       TableView showSlotList(ObjectMapper mapper) {
        List slotsList = new ArrayList();//generalServiceInstance().getSlotsList(2);
        slotsList.add( new Slot(new Time(1, 2, 3), new Time(1, 2, 3)));
        slotsList.add( new Slot(new Time(1, 2, 3), new Time(1, 2, 3)));
        slotsList.add( new Slot(new Time(1, 2, 3), new Time(1, 2, 3)));
        slotsList.add( new Slot(new Time(1, 2, 3), new Time(1, 2, 3)));
        System.out.println(slotsList);
        Iterator slotsListIterator = slotsList.iterator();
        tempslotsList = new ArrayList();
        tempslotsList.clear();
//        while (slotsListIterator.hasNext()) {
//
//            Map map = (Map) slotsListIterator.next();
//            Slot tempGroupType = mapper.convertValue(map, Slot.class);
//
//            tempGroupType.setGroupIDS();
//            tempslotsList.add(tempGroupType);
//        }
//        slotList.clear();
//        slotList.addAll(tempslotsList);
//        
        slotManageTable.getItems().clear();
        slotManageTable=new TableView();
        slotManageTable.getItems().setAll(slotList);
        return slotManageTable;
        
    }

       private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reporter Alert");
        alert.setHeaderText(null);
        alert.setContentText(text);

        alert.showAndWait();
    }

    private SaveSlot mapSaveSlots(Slot slot) {
        SaveSlot s = new SaveSlot();
        s.setCreatedBy(slot.getCreated_By());
        s.setCreatedOn(slot.getCreatedOn());
        s.setGroup_id(slot.getGroup_id());
        s.setEndTime(slot.getEndTime());
        s.setStartTime(slot.getStartTime());
        if (slot.getModifiedOn() != null) {
            s.setModifiedOn(slot.getModifiedOn());
        }
        if (slot.getId() != null) {
            s.setId(slot.getId());
        }
        return s;
    }
}
