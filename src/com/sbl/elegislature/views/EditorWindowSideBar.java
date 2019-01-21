/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views;

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
import com.sbl.elegislature.models.pojo.businestype.BusinessTypeData;
import com.sbl.elegislature.models.pojo.businestype.GetAllBusinesTypePOJO;
import com.sbl.elegislature.models.pojo.members.GetAllMembersPOJO;
import com.sbl.elegislature.models.pojo.members.MemberData;
import com.sbl.elegislature.service.GeneralService;
import com.sbl.elegislature.util.MaskedTextField;
import com.sbl.elegislature.util.MediaControl;
import static com.sbl.elegislature.views.controlls.TimePicker.AM;
import static com.sbl.elegislature.views.controlls.TimePicker.PM;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class EditorWindowSideBar extends SplitPane {

    private final TableView tableMemberDiscussion;

    private final ObservableList<MemberDiscussion> memberDiscussiondata;

    private Button btnButton, btnSaveNew, btnSave /*, resetButton */, btnPrevious, btnNext, btnStart, btnEnd;

    private MaskedTextField startTime, endTime;

    private ObservableList<BusinessTypeData> businessTypeList = FXCollections.observableArrayList();
    private ObservableList<MemberData> memberList = FXCollections.observableArrayList();

    private ListView listViewBusinessType = new ListView();
    private ListView listViewMemberType = new ListView();

    public MemberData selectdMemer;
    public BusinessTypeData selectedBusinessType;
    
    MediaPlayer mediaPlayer;

    public EditorWindowSideBar(String[] businessType, String[] memberList1) {

        memberDiscussiondata = FXCollections.observableArrayList();

        tableMemberDiscussion = new TableView();

        setOrientation(Orientation.VERTICAL);

        getItems().addAll(createSessionContent(), createBusinessTypeMemberListView(businessType, memberList1), createMediaplayer());
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

        tableMemberDiscussion.setItems(memberDiscussiondata);
        tableMemberDiscussion.setEditable(true);
        tableMemberDiscussion.getColumns().addAll(memberNameCol, startTimeCol, endTimeCol);

        bp.setCenter(tableMemberDiscussion);
        return bp;
    }

    private MediaControl createMediaplayer() {

        String mediaURL = "http://192.168.6.51:8082/files/downloadFile/72b3f31c-ca0d-4fb4-8dd7-36b17e1177d8.mp4";
//this.getClass().getClassLoader().getResource("resources/media/blank.mov").toExternalForm();
//        Media media = new Media(new File(mediaURL).toURI().toString());
        Media media = new Media(mediaURL);
        
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        
        
        
        return new MediaControl(mediaPlayer);
    }

    public void refresh() {

    }
    
    private String getTime() {
        int minutes = (int) mediaPlayer.getCurrentTime().toMinutes() % 60;
        int seconds = (int) mediaPlayer.getCurrentTime().toSeconds() % 60;
        return setPadding(minutes) + ":" + setPadding(seconds);
    }
    
    public String setPadding( int value) {
        if(value < 10) return "0"+value;
        return ""+value;
    }

    private GridPane createBusinessTypeMemberListView(String[] businessType, String[] memberList1) {

        btnButton = makeNavigationButton("new", "New");
        btnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("btnButton");
            }
        });
        
        btnSaveNew = makeNavigationButton("savenew", "Save & New");
        btnSaveNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("btnSaveNew");
            }
        });
        
        btnSave = makeNavigationButton("save", "Save");
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("btnSave");
            }
        });
        
//        resetButton = makeNavigationButton("reset", "Reset");
        btnPrevious = makeNavigationButton("previous", "Previous Discussion");
        btnNext = makeNavigationButton("next", "Next Discussion");

        btnStart = new Button("...");
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTime.setText(getTime());
            }
        });
        
        btnEnd = new Button("...");
        btnEnd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                endTime.setText(getTime());
            }
        });
        
        startTime = new MaskedTextField();
//        startTime.setMask("##:##:## UM");
        startTime.setPlaceholder("_");
        startTime.setMaxWidth(55);
        startTime.setMinWidth(55);
        startTime.setPrefWidth(55);
        startTime.setEditable(false);
        
        endTime = new MaskedTextField();
//        endTime.setMask("##:##:## UM");
        endTime.setPlaceholder("_");
        endTime.setMaxWidth(55);
        endTime.setMinWidth(55);
        endTime.setPrefWidth(55);
        endTime.setEditable(false);
        
        
        GridPane gridPane = new GridPane();
        //toolbar.getItems().addAll(newButton,saveNewButton,saveButton,resetButton);
        //GridPane gridPane=new GridPane();

        gridPane.setPadding(new Insets(5));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.alignmentProperty().isBound();
        gridPane.setHgap(2);
        gridPane.setVgap(2);

        gridPane.add(btnButton, 0, 0);
        gridPane.add(btnSaveNew, 1, 0);
        gridPane.add(btnSave, 2, 0);
//        gridPane.add(resetButton, 3, 0);
        gridPane.add(btnPrevious, 4, 0);
        gridPane.add(btnNext, 5, 0);
        gridPane.add(startTime, 6, 0);
        gridPane.add(btnStart, 7, 0);
        gridPane.add(new Text(" to "), 8, 0);
        gridPane.add(endTime, 9, 0);
        gridPane.add(btnEnd, 10, 0);
        gridPane.add(new Text(" Business Type "), 0, 1, 5, 1);
        gridPane.add(new Text(" Member "), 6, 1, 5, 1);

        TextField txtBusinessSearch = new TextField();
        txtBusinessSearch.setPromptText("Search");
        txtBusinessSearch.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldVal, Object newVal) {
                searchBusinessTypeEntries((String) oldVal, (String) newVal, listViewBusinessType, businessTypeList);
            }
        });

        listViewBusinessType.setMinHeight(140);
        listViewBusinessType.setPrefHeight(140);
        listViewBusinessType.setMaxHeight(180);

        businessTypeList.addAll(fetchBusinssTypeList());
        listViewBusinessType.setItems(businessTypeList);
        listViewBusinessType.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<BusinessTypeData>() {
                    @Override
                    public void changed(ObservableValue<? extends BusinessTypeData> observable,
                            BusinessTypeData oldValue, BusinessTypeData newValue) {

                        selectedBusinessType = newValue;
                        System.out.println("Selected item: " + newValue + "  " + newValue.getId());
                    }
                });

        gridPane.add(txtBusinessSearch, 0, 2, 6, 1);
        gridPane.add(listViewBusinessType, 0, 3, 6, 1);

        TextField txtMemberSearch = new TextField();
        txtMemberSearch.setPromptText("Search");
        txtMemberSearch.textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldVal, Object newVal) {
                searchMemberEntries((String) oldVal, (String) newVal, listViewMemberType, memberList);
            }
        });

        listViewMemberType.setMaxHeight(180);
        listViewMemberType.setPrefHeight(140);
        listViewMemberType.setMaxHeight(180);

        this.memberList.addAll(fetchMembersList());
        listViewMemberType.setItems(this.memberList);

        listViewMemberType.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<MemberData>() {

                    @Override
                    public void changed(ObservableValue<? extends MemberData> observable, 
                            MemberData oldValue, MemberData newValue) {
                        
                        selectdMemer = newValue;
                        System.out.println("Selected item: " + newValue + "  " + newValue.getId());
                    }
                });

        gridPane.add(txtMemberSearch, 6, 2, 5, 1);
        gridPane.add(listViewMemberType, 6, 3, 5, 1);

        return gridPane;
    }

    private List<BusinessTypeData> fetchBusinssTypeList() {
        GetAllBusinesTypePOJO getAllBusinesTypePOJO = GeneralService.generalServiceInstance().getBusinessType();
        if (getAllBusinesTypePOJO != null) {
            return getAllBusinesTypePOJO.getData();
        }
        return null;
    }

    private List<MemberData> fetchMembersList() {
        GetAllMembersPOJO getAllMembersPOJO = GeneralService.generalServiceInstance().getAllMembers();
        if (getAllMembersPOJO != null) {
            return getAllMembersPOJO.getData();
        }
        return null;
    }

    public void searchMemberEntries(String oldVal, String newVal, ListView list,
            ObservableList<MemberData> entries) {
        String value = newVal.toUpperCase();

        ObservableList<MemberData> subentries = FXCollections.observableArrayList();
        for (MemberData entry : memberList) {
            boolean match = true;
            MemberData entryText = entry;
            if (!entryText.toString().toUpperCase().contains(value)) {
                match = false;
            }
            if (match) {
                subentries.add(entryText);
            }
        }
        list.setItems(subentries);
    }

    public void searchBusinessTypeEntries(String oldVal, String newVal, ListView list,
            ObservableList<BusinessTypeData> entries) {
        String value = newVal.toUpperCase();

        ObservableList<BusinessTypeData> subentries = FXCollections.observableArrayList();
        for (BusinessTypeData entry : businessTypeList) {
            boolean match = true;
            BusinessTypeData entryText = entry;
            if (!entryText.toString().toUpperCase().contains(value)) {
                match = false;
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
