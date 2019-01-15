/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbl.elegislature.data.SaveSlots;
import com.sbl.elegislature.data.Slot;
import com.sbl.elegislature.util.EditCell;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class SlotManagement extends Application {

    TableView<Slot> slotManageTable;
    ObjectMapper mapper;
    ObservableList<Slot> slotList;
    List<Slot> tempslotsList;

    @Override
    public void start(Stage primaryStage) throws Exception {

        mapper = new ObjectMapper();
        /*------------------------------ slotManageTable methods------------------------------------------*/
        slotManageTable = new TableView();
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
        slotManageTable = showSlotList(mapper);

        slotManageTable.setOnKeyPressed(event -> {
            TablePosition<Slot, ?> pos = slotManageTable.getFocusModel().getFocusedCell();
            if (pos != null && event.getCode().isLetterKey()) {
                slotManageTable.edit(pos.getRow(), pos.getTableColumn());
            }
        });

        StackPane mainCointainer = new StackPane();
        mainCointainer.getChildren().addAll(slotManageTable);//userListViewPane,groupTreeViewPane);
        Scene scene = new Scene(mainCointainer);
        primaryStage.setScene(scene);
        primaryStage.titleProperty().bind(
                scene.widthProperty().asString().
                        concat(" : ").
                        concat(scene.heightProperty().asString()));
        //primaryStage.setResizable(false);
        primaryStage.setMaximized(true);
        primaryStage.show();

    }

    private <T> TableColumn<T, String> createColumn(String title, Function<T, StringProperty> property) {
        TableColumn<T, String> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));

        col.setCellFactory(column -> EditCell.createStringEditCell());
        return col;
    }

    TableView showSlotList(ObjectMapper mapper) {
        List slotsList = new ArrayList();//generalServiceInstance().getSlotsList(2);
        slotsList.add(new Slot(new Time(1, 2, 3), new Time(1, 2, 3)));
        slotsList.add(new Slot(new Time(1, 2, 3), new Time(1, 2, 3)));
        slotsList.add(new Slot(new Time(1, 2, 3), new Time(1, 2, 3)));
        slotsList.add(new Slot(new Time(1, 2, 3), new Time(1, 2, 3)));
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
        slotManageTable = new TableView();
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

    private SaveSlots mapSaveSlots(Slot slot) {
        SaveSlots s = new SaveSlots();
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

    public static void main(String[] args) {
        launch(args);
    }
}
