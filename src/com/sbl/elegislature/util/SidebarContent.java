/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.util;

/**
 *
 * @author bipin
 */
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import com.sbl.elegislature.data.MemberDiscussion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class SidebarContent extends SplitPane {

    private final TableView table;
    private final ObservableList<MemberDiscussion> data;
    private Button newButton, saveNewButton, saveButton, resetButton, previousButton, nextButton, startButton, endButton;
    private MaskedTextField startTime, endTime;
    private ObservableList<String> businessTypeEntries = FXCollections.observableArrayList(), 
            memberTypeEntries = FXCollections.observableArrayList();
    private ListView listBusinessType = new ListView(), listMemberType = new ListView();

    public SidebarContent(String[] businessType, String[] memberList) {
        data = FXCollections.observableArrayList();
        table = new TableView();
        setOrientation(Orientation.VERTICAL);

        getItems().addAll(createSessionContent(), createTools(businessType, memberList), createMediaplayer());
        setDividerPositions(0.3f, 0.35f, 0.35f);
        setWidth(300);
    }

    private BorderPane createSessionContent() {
        BorderPane bp = new BorderPane();

        TableColumn memberNameCol = new TableColumn("Member");
        memberNameCol.setMinWidth(100);
        memberNameCol.setCellValueFactory(new PropertyValueFactory<>("memberName"));

        TableColumn startTimeCol = new TableColumn("Start");
        startTimeCol.setMinWidth(100);
        startTimeCol.setCellValueFactory(new PropertyValueFactory<>("startTime"));

        TableColumn endTimeCol = new TableColumn("End");
        endTimeCol.setMinWidth(100);
        endTimeCol.setCellValueFactory(new PropertyValueFactory<>("endTime"));

        table.setItems(data);
        table.setEditable(true);
        table.getColumns().addAll(memberNameCol, startTimeCol, endTimeCol);

        bp.setCenter(table);
        return bp;
    }

    private MediaControl createMediaplayer() {

        String mediaURL = "http://192.168.6.51:8082/files/downloadFile/72b3f31c-ca0d-4fb4-8dd7-36b17e1177d8.mp4"; //this.getClass().getClassLoader().getResource("resources/media/blank.mov").toExternalForm();
//        Media media = new Media(new File(mediaURL).toURI().toString());
        Media media = new Media(mediaURL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        return new MediaControl(mediaPlayer);
    }

    private GridPane createTools(String[] businessType, String[] memberList) {

        newButton = makeNavigationButton("new", "New");
        saveNewButton = makeNavigationButton("savenew", "Save & New");
        saveButton = makeNavigationButton("save", "Save");
        resetButton = makeNavigationButton("reset", "Reset");
        previousButton = makeNavigationButton("previous", "Previous Discussion");
        nextButton = makeNavigationButton("next", "Next Discussion");

        startButton = new Button("...");
        endButton = new Button("...");
        startTime = new MaskedTextField();
        startTime.setMask("##:##:## UM");
        startTime.setPlaceholder("_");
        startTime.setMaxWidth(80);
        startTime.setMinWidth(50);
        startTime.setPrefWidth(80);
        endTime = new MaskedTextField();
        endTime.setMask("##:##:## UM");
        endTime.setPlaceholder("_");
        endTime.setMaxWidth(80);
        endTime.setMinWidth(50);
        endTime.setPrefWidth(80);
        GridPane gridPane = new GridPane();
        //toolbar.getItems().addAll(newButton,saveNewButton,saveButton,resetButton);
        //GridPane gridPane=new GridPane();

        gridPane.setPadding(new Insets(5));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.alignmentProperty().isBound();
        gridPane.setHgap(2);
        gridPane.setVgap(2);

        gridPane.add(newButton, 0, 0);
        gridPane.add(saveNewButton, 1, 0);
        gridPane.add(saveButton, 2, 0);
        gridPane.add(resetButton, 3, 0);
        gridPane.add(previousButton, 4, 0);
        gridPane.add(nextButton, 5, 0);
        gridPane.add(startTime, 6, 0);
        gridPane.add(startButton, 7, 0);
        gridPane.add(new Text(" to "), 8, 0);
        gridPane.add(endTime, 9, 0);
        gridPane.add(endButton, 10, 0);
        gridPane.add(new Text(" Business Type "), 0, 1, 5, 1);
        gridPane.add(new Text(" Member "), 6, 1, 5, 1);

        TextField txtBusinessSearch = new TextField();
        txtBusinessSearch.setPromptText("Search");
        txtBusinessSearch.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldVal, Object newVal) {
                searchEntries((String) oldVal, (String) newVal, listBusinessType, businessTypeEntries);
            }
        });
        listBusinessType.setMinHeight(140);
        listBusinessType.setPrefHeight(140);
        listBusinessType.setMaxHeight(180);

        businessTypeEntries.addAll(businessType);
        listBusinessType.setItems(businessTypeEntries);
        gridPane.add(txtBusinessSearch, 0, 2, 6, 1);
        gridPane.add(listBusinessType, 0, 3, 6, 1);

        TextField txtMemberSearch = new TextField();
        txtMemberSearch.setPromptText("Search");
        txtMemberSearch.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldVal, Object newVal) {
                searchEntries((String) oldVal, (String) newVal, listMemberType, memberTypeEntries);
            }
        });
        listMemberType.setMaxHeight(180);
        listMemberType.setPrefHeight(140);
        listMemberType.setMaxHeight(180);

        memberTypeEntries.addAll(memberList);
        listMemberType.setItems(memberTypeEntries);
        gridPane.add(txtMemberSearch, 6, 2, 5, 1);
        gridPane.add(listMemberType, 6, 3, 5, 1);

        return gridPane;
    }

    public void searchEntries(String oldVal, String newVal, ListView list, ObservableList<String> entries) {
        if (oldVal != null && (newVal.length() < oldVal.length())) {
            list.setItems(entries);
        }
        String value = newVal.toUpperCase();
        ObservableList<String> subentries = FXCollections.observableArrayList();
        for (Object entry : list.getItems()) {
            boolean match = true;
            String entryText = (String) entry;
            if (!entryText.toUpperCase().contains(value)) {
                match = false;
                break;
            }
            if (match) {
                subentries.add(entryText);
            }
        }
        list.setItems(subentries);
    }

    private Button makeNavigationButton(String imageName, String toolTipText) {
        Button button = new Button(" ");
        button.getStyleClass().add("toolbarButton");
        button.getStyleClass().add(imageName + "toolbarButton");
        final Tooltip tooltip = new Tooltip(toolTipText);
        button.setTooltip(new Tooltip(toolTipText));
        return button;
    }
}
