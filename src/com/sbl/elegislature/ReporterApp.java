/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbl.elegislature.data.Language;
import com.sbl.elegislature.data.assembly.Assembly;
import com.sbl.elegislature.data.assembly.SessionDate;
import com.sbl.elegislature.data.groups.Group;
import com.sbl.elegislature.login.UserLogin;
import static com.sbl.elegislature.service.GeneralService.generalServiceInstance;
import com.sbl.elegislature.util.AppContext;
import com.sbl.elegislature.util.AppResources;
import com.sbl.elegislature.util.AppUtils;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import com.sbl.elegislature.views.GroupManagementWindow;
import com.sbl.elegislature.util.ChiefEditorSlotMgmntContent;
import com.sbl.elegislature.util.CustomHTMLEditor;
import com.sbl.elegislature.util.Dockbar;
import com.sbl.elegislature.util.EditorSectionDockbarContent;
import com.sbl.elegislature.views.EditorWindow;
import com.sbl.elegislature.views.LeftSideDockbar;
import com.sbl.elegislature.views.EditorWindowSideBar;
import com.sbl.elegislature.views.SlotManagementWindow;
import com.sbl.elegislature.views.baseviews.BaseWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.stage.Modality;

/**
 *
 * @author bipin
 */
public class ReporterApp extends Application {
    
    EditorWindow editorWindow;
    GroupManagementWindow  groupManagementWindow;
    SlotManagementWindow slotManagementWindow;
    
    Dockbar slotSectionDockbar;

    ObjectMapper mapper;
    Stage stage;
    
    StackPane mainCointainer;

    @Override
    public void start(Stage stage) {

        this.stage = stage;

        editorWindow = new EditorWindow();
        groupManagementWindow = new GroupManagementWindow();
        slotManagementWindow = new SlotManagementWindow(800);

        mainCointainer = new StackPane();
        showEditorWindow();
        
        slotSectionDockbar = createSlotSectionDockPane();
        BorderPane middlePane = new BorderPane();
        middlePane.setLeft(slotSectionDockbar.getControlButton());
        middlePane.setCenter(mainCointainer);

        BorderPane outerPane = new BorderPane();
        outerPane.setTop(getMenu());
        outerPane.setLeft(slotSectionDockbar);
        outerPane.setCenter(middlePane);

        stage.setTitle("Reporter Editor");
        Scene scene = new Scene(outerPane);
        scene.getStylesheets().add(getClass().getClassLoader()
                .getResource(AppResources.SLIDEOUT_CSS).toExternalForm());
        stage.setScene(scene);
        

        stage.setOnCloseRequest(event -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog...");
            alert.setHeaderText("Application Exit");
            alert.setContentText("Are you sure you want to exit the Application?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Platform.exit();
            } else {
                event.consume();
            }

        });
        stage.show();
    }
    
    private void clearWindowPanels() {
        editorWindow.hideWindow();
        groupManagementWindow.hideWindow();
        slotManagementWindow.hideWindow();
        mainCointainer.getChildren().clear();
    }
    
    private void showEditorWindow() {
        clearWindowPanels();
        editorWindow.showWindow();
        mainCointainer.getChildren().add(editorWindow);
        editorWindow.refreshWindow();
    }
    
    private void showGroupManagementWindow() {
        clearWindowPanels();
        groupManagementWindow.showWindow();
        mainCointainer.getChildren().add(groupManagementWindow);
        groupManagementWindow.refreshWindow();
    }
    
    private void showSlotManagementWindow() {
        clearWindowPanels();
        slotManagementWindow.showWindow();
        mainCointainer.getChildren().add(slotManagementWindow);
        slotManagementWindow.refreshWindow();
    }
    

    private MenuBar getMenu() {

        boolean userChiefEditor = false;

        MenuBar menuBar = new MenuBar();
        Menu mmnuFile = new Menu("File");

        if (AppContext.application().userType != null
                && AppContext.application().userType.equals(AppContext.USER_CHIEF_EDITOR)) {
            userChiefEditor = true;
        }

        if (userChiefEditor) {
            Menu mmnuConfiguration = new Menu("Configuration");

            MenuItem mmnuItmGroupMgmnt = new MenuItem("Group Management");
            mmnuItmGroupMgmnt.setOnAction(e -> {
                showGroupManagementWindow();
            });

            MenuItem mmnuItmSlotMgmnt = new MenuItem("Slot Management");
            mmnuItmSlotMgmnt.setOnAction(e -> {
                showSlotManagementWindow();
            });

            mmnuConfiguration.getItems().add(mmnuItmGroupMgmnt);
            mmnuConfiguration.getItems().add(mmnuItmSlotMgmnt);
            mmnuFile.getItems().add(mmnuConfiguration);

        }

        MenuItem mmnuItmEditor = new MenuItem("Editor Window");
        mmnuItmEditor.setOnAction(e -> {
            System.out.println("Editor Window clicked!!");
            showEditorWindow();
        });

        MenuItem mmnuItmExit = new MenuItem("Exit");
        mmnuItmExit.setOnAction(e -> {
            stage.fireEvent(
                    new WindowEvent(
                            stage,
                            WindowEvent.WINDOW_CLOSE_REQUEST
                    )
            );
        });

        MenuItem mmnuItmLogOut = new MenuItem("Log Out");
        mmnuItmLogOut.setOnAction(e -> {
            UserLogin user = new UserLogin();
            Stage popUpStage = new Stage();
            try {
                AppUtils.writeStringAsFile(AppUtils.LOGIN_FILE, "");
                popUpStage.initModality(Modality.WINDOW_MODAL);

                popUpStage.initOwner(stage);
                user.start(popUpStage);
                stage.close();
                // fx.refreshFinger();
            } catch (Exception ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        );

        mmnuFile.getItems().add(mmnuItmEditor);
        mmnuFile.getItems().add(mmnuItmLogOut);
        mmnuFile.getItems().add(mmnuItmExit);

        menuBar.getMenus().add(mmnuFile);

        return menuBar;
    }

    private Dockbar createSlotSectionDockPane() {
        LeftSideDockbar sideBarContent = new LeftSideDockbar();
        sideBarContent.setOnSessionDateSelecListner(new LeftSideDockbar.OnSessionDateSelecListner() {
            @Override
            public void onSessionDateSelecListner() {
                if(groupManagementWindow.isShowing) {
                    groupManagementWindow.refreshWindow();
                }
                
                if(editorWindow.isShowing) {
//                    groupManagementWindow.reloadFromSever();
                }
                
                if(slotManagementWindow.isShowing) {
//                    groupManagementWindow.reloadFromSever();
                }
            }
        });
        Dockbar sidebar = new Dockbar(250, sideBarContent);
        VBox.setVgrow(sideBarContent, Priority.ALWAYS);
        return sidebar;
    }


}
