/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views;


import com.sbl.elegislature.data.Language;
import com.sbl.elegislature.models.pojo.assembly.AssemblyData;
import com.sbl.elegislature.models.pojo.assembly.GetActiveAssemblyPOJO;
import com.sbl.elegislature.models.pojo.language.GetAllLanguagePOJO;
import com.sbl.elegislature.models.pojo.language.LanguageData;
import com.sbl.elegislature.models.pojo.session.GetAllSessionsPOJO;
import com.sbl.elegislature.models.pojo.session.SessionData;
import com.sbl.elegislature.models.pojo.sessiondate.GetAllSessionDatePOJO;
import com.sbl.elegislature.models.pojo.sessiondate.SessionDateData;
import com.sbl.elegislature.util.AppContext;
import com.sbl.elegislature.util.LOG;
import static com.sbl.elegislature.service.GeneralService.generalServiceInstance;
import java.util.List;
import java.util.NoSuchElementException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author bipin
 * @author Sandeep Kumar
 * 
 * This contain session drop down list
 * session date list
 * Slot list
 */
public class LeftSideDockbar extends BorderPane {

    private Insets padding;
    private ComboBox comboSessionList;
    private ComboBox comboSessionDates;
    private ComboBox comboLanguages;

    public LeftSideDockbar() {
        initViews();
    }

    public void initViews() {
        loadViews();
        loadDataIntoViews();
    }
    
    public interface OnSessionDateSelecListner {
        public void onSessionDateSelecListner();
    }
    
    OnSessionDateSelecListner onSessionDateSelecListner;
    
    public void setOnSessionDateSelecListner(OnSessionDateSelecListner onSessionDateSelecListner) {
        this.onSessionDateSelecListner = onSessionDateSelecListner;
    }

    public void loadViews() {
        padding = new Insets(5, 10, 5, 10);

        GridPane topPane = new GridPane();
        topPane.setPadding(padding);
        topPane.setVgap(4);

        comboSessionList = new ComboBox();
        comboSessionDates = new ComboBox();
        comboLanguages = new ComboBox();

        comboSessionList.setMinWidth(146);
        comboSessionDates.setMinWidth(146);
        comboLanguages.setMinWidth(146);

        topPane.add(new Text("Session : "), 0, 0);
        topPane.add(comboSessionList, 1, 0);

        topPane.add(new Text("Session Date : "), 0, 1);
        topPane.add(comboSessionDates, 1, 1);

        topPane.add(new Text("Language : "), 0, 2);
        topPane.add(comboLanguages, 1, 2);

//        TitledPane tpGleaning = new TitledPane("Gleaning", getSlotsContents(slotGleaning));
//        TitledPane tpSynopsis = new TitledPane("Synopsis", getSlotsContents(slotSynopsis));
//        TitledPane tpDiary = new TitledPane("Diary", getSlotsContents(slotDiary));
//        Accordion accordion = new Accordion();
//        accordion.getPanes().addAll(tpGleaning, tpSynopsis, tpDiary);
        setPadding(padding);
        setTop(topPane);
//        setCenter(accordion);
    }

    public void loadDataIntoViews() {
        AppContext.selectedAssemblyId = loadActiveAssembly();
        if (AppContext.selectedAssemblyId == 0) {
            //Show assembly not found dialog
            return;
        }

        //Load session and session date list
        ObservableList<SessionData> sessionList = loadSessions(AppContext.selectedAssemblyId);
        if (sessionList != null) {
            comboSessionList.setItems(sessionList);
            EventHandler<ActionEvent> eventHandlerSession
                    = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    
                    SessionData selectedSession = (SessionData) comboSessionList.getValue();
                    ObservableList<SessionDateData> sessionDateList = loadSessionDates(selectedSession.getId());
                    LOG.log("selectedSession:" + selectedSession.getSessionName()
                            + " ID:" + selectedSession.getId());
                    AppContext.selectedSessionId = selectedSession.getId();
                    
                    if( sessionDateList != null) {
                        comboSessionDates.setItems(sessionDateList);
                    }
                }
            };
            comboSessionList.setOnAction(eventHandlerSession); 
            
            
            EventHandler<ActionEvent> eventHandlerSessionDate
                    = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    
                    SessionDateData selectedSessionDate = (SessionDateData) comboSessionDates.getValue();
                    LOG.log("selectedSessionDate:" + selectedSessionDate.getSessionDate()
                            + " ID:" + selectedSessionDate.getId());
                    AppContext.selectedSessionDateId = selectedSessionDate.getId();
                    if(onSessionDateSelecListner != null) {
                        onSessionDateSelecListner.onSessionDateSelecListner();
                    }
                }
            };
            comboSessionDates.setOnAction(eventHandlerSessionDate);
        }
        
        //Load Languages
        ObservableList<LanguageData> languageData = loadLanguages();
        if (languageData != null) {
            comboLanguages.setItems(languageData);;
            EventHandler<ActionEvent> eventHandlerLanguage
                    = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    LanguageData selectedLanguage = (LanguageData) comboLanguages.getValue();
                    
                    AppContext.selectedLanguageId = selectedLanguage.getId();
                    
                    LOG.log("language selected:" + selectedLanguage.getName()
                            + " ID:" + selectedLanguage.getId());
                }
            };
            comboLanguages.setOnAction(eventHandlerLanguage);
        }
        

    }

    public int loadActiveAssembly() {
        GetActiveAssemblyPOJO getActiveAssemblyPOJO = generalServiceInstance().getAllSessionsPojo();
        if (getActiveAssemblyPOJO != null) {
            if (getActiveAssemblyPOJO.getData() != null) {
                try {
                    AssemblyData data = getActiveAssemblyPOJO.getData().stream().findFirst().get();
                    return data.getId();
                } catch (NoSuchElementException e) {
                }
            }
        }
        return 0;
    }

    public ObservableList<SessionData> loadSessions(int assemblyId) {
        GetAllSessionsPOJO getAllSessionsPOJO = generalServiceInstance()
                .getAllSessionPojo(assemblyId);
        if (getAllSessionsPOJO != null) {
            if (getAllSessionsPOJO.getData() != null) {
                ObservableList<SessionData> sessionData = FXCollections
                        .observableList(getAllSessionsPOJO.getData());
                return sessionData;
            }
        }
        return null;
    }
    
    

    public ObservableList<SessionDateData> loadSessionDates(int sessionId) {
        GetAllSessionDatePOJO getAllSessionDatePOJO = generalServiceInstance()
                .getAllSessionDate(sessionId);
        if (getAllSessionDatePOJO != null) {
            if (getAllSessionDatePOJO.getData() != null) {
                ObservableList<SessionDateData> sessionDateData = FXCollections
                        .observableList(getAllSessionDatePOJO.getData());
                return sessionDateData;
            }
        }
        return null;
    }
    
    public ObservableList<LanguageData> loadLanguages() {
        GetAllLanguagePOJO getAllLanguagePOJO = generalServiceInstance()
                .getAllLanguages();
        if (getAllLanguagePOJO != null) {
            if (getAllLanguagePOJO.getData() != null) {
                ObservableList<LanguageData> languageData = FXCollections
                        .observableList(getAllLanguagePOJO.getData());
                return languageData;
            }
        }
        return null;
    }

    public LeftSideDockbar(ObservableList assemblyList, ObservableList sessionList, ObservableList languageList,
            String[] slotGleaning, String[] slotSynopsis, String[] slotDiary) {

        padding = new Insets(5, 10, 5, 10);

        GridPane topPane = new GridPane();
        topPane.setPadding(padding);
        topPane.setVgap(4);

        if (assemblyList != null) {
            comboSessionList = new ComboBox(FXCollections.observableArrayList(assemblyList));

        } else {
            comboSessionList = new ComboBox();
        }

        if (sessionList != null) {
            comboSessionDates = new ComboBox(FXCollections.observableArrayList(sessionList));
        } else {
            comboSessionDates = new ComboBox();
        }

        if (languageList != null) {
            comboLanguages = new ComboBox(FXCollections.observableArrayList(languageList));
        } else {
            comboLanguages = new ComboBox();
        }

//        comboAssemblyList = new ComboBox(FXCollections.observableArrayList(assemblyList));
//        comboSessionDates = new ComboBox(FXCollections.observableArrayList(sessionList));
//        comboLanguages = new ComboBox(FXCollections.observableArrayList(languageList));
        comboSessionList.setMinWidth(146);
        comboSessionDates.setMinWidth(146);
        comboLanguages.setMinWidth(146);

        topPane.add(new Text("Assembly : "), 0, 0);
        topPane.add(comboSessionList, 1, 0);
        topPane.add(new Text("Session Date : "), 0, 1);
        topPane.add(comboSessionDates, 1, 1);
        topPane.add(new Text("Language : "), 0, 2);
        topPane.add(comboLanguages, 1, 2);

        TitledPane tpGleaning = new TitledPane("Gleaning", getSlotsContents(slotGleaning));
        TitledPane tpSynopsis = new TitledPane("Synopsis", getSlotsContents(slotSynopsis));
        TitledPane tpDiary = new TitledPane("Diary", getSlotsContents(slotDiary));

        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(tpGleaning, tpSynopsis, tpDiary);

        setPadding(padding);
        setTop(topPane);
        setCenter(accordion);
    }

    private ScrollPane getSlotsContents(String[] timeslots) {
        FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
        //flowPane.setPadding(new Insets(30, 30, 30, 30));

        flowPane.setHgap(4);
        flowPane.setVgap(4);
        for (String timeslot : timeslots) {
            Button b = new Button(timeslot);
            b.setPadding(padding);
            b.setAlignment(Pos.CENTER);
            flowPane.getChildren().add(b);
        }
        flowPane.setAlignment(Pos.CENTER);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(flowPane);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setContent(flowPane);
        return scrollPane;
    }

}
