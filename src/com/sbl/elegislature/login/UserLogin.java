/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.login;

//import com.sbl.elegislature.Controller.GroupManagement;
//import com.sbl.elegislature.Controller.SlotManagement;
import com.sbl.elegislature.ReporterApp;
import com.sbl.elegislature.models.pojo.user.GetCurrentUserPOJO;
import com.sbl.elegislature.service.GeneralService;
import static com.sbl.elegislature.service.GeneralService.generalServiceInstance;
import com.sbl.elegislature.service.ServiceClientImpl;
import com.sbl.elegislature.util.AppContext;
import com.sbl.elegislature.util.AppResources;
import com.sbl.elegislature.util.AppUtils;
import com.sbl.elegislature.util.SuccessfullLoginEventListener;
import com.sbl.elegislature.views.UserLoginView;
import java.applet.AppletContext;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class UserLogin extends Application implements SuccessfullLoginEventListener {

    UserLoginView userLoginPane;
    BorderPane root;
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        
        loadProperties();

        root = new BorderPane();
        ImageView img = new ImageView(getClass().getClassLoader().getResource(AppResources.LOGO).toExternalForm());
        BorderPane bp = new BorderPane();
        bp.setLeft(img);
        bp.setCenter(getApplicationTitle());
        root.setTop(bp);

        setLoginView();

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getClassLoader().getResource(AppResources.MAIN_CSS).toExternalForm());
        primaryStage.setMaximized(true);
        root.getTop().getStyleClass().add("bannerStyle");

        primaryStage.setTitle(AppResources.APP_NAME);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void loadProperties() {
        AppContext context = AppContext.application(); 
        context.loadProperties();
        ServiceClientImpl.BASE_URL = AppContext.application().BASE_URL;
    }

    private void setLoginView() {
        userLoginPane = new UserLoginView(this);
        root.setCenter(userLoginPane);
    }

    private Text getApplicationTitle() {

        Text text = new Text(AppResources.APP_NAME);
        text.setId("fancytext");

        text.setX(20);
        text.setY(150);
        Blend blend = new Blend();
        blend.setMode(BlendMode.MULTIPLY);

        DropShadow ds = new DropShadow();
        ds.setColor(Color.rgb(254, 235, 66, 0.3));
        ds.setOffsetX(5);
        ds.setOffsetY(5);
        ds.setRadius(5);
        ds.setSpread(0.2);

        blend.setBottomInput(ds);
        DropShadow ds1 = new DropShadow();
        ds1.setColor(Color.web("#f13a00"));
        ds1.setRadius(20);
        ds1.setSpread(0.2);

        Blend blend2 = new Blend();
        blend2.setMode(BlendMode.MULTIPLY);

        InnerShadow is = new InnerShadow();
        is.setColor(Color.web("#feeb42"));
        is.setRadius(5);
        is.setChoke(0.8);
        blend2.setBottomInput(is);

        InnerShadow is1 = new InnerShadow();
        is1.setColor(Color.web("#f13a00"));
        is1.setRadius(3);
        is1.setChoke(0.3);
        blend2.setTopInput(is1);

        Blend blend1 = new Blend();
        blend1.setMode(BlendMode.MULTIPLY);
        blend1.setBottomInput(ds1);
        blend1.setTopInput(blend2);
        blend.setTopInput(blend1);
        GridPane.setHalignment(text, HPos.CENTER);
        text.setEffect(blend);
        return text;
    }

    @Override
    public void onSuccessfullLoginEvent() {
        GetCurrentUserPOJO getCurrentUserPOJO  = GeneralService.generalServiceInstance().getCurrentUserInfo();
        if(getCurrentUserPOJO != null) {
            if(getCurrentUserPOJO.getData() != null) {
                AppContext.application().userType = getCurrentUserPOJO.getData().getDesignation();
                AppContext.application().employeeId = getCurrentUserPOJO.getData().getEmployeeId();
                AppContext.application().userId = getCurrentUserPOJO.getData().getId();
                System.out.println("AppContext.application().userType:" + AppContext.application().userType);
            }
        }
        
        gotoDashboard();
    }

    public void gotoDashboard() {
        ReporterApp fx = new ReporterApp();
        Stage popUpStage = new Stage();
        try {
            popUpStage.initModality(Modality.WINDOW_MODAL);

            popUpStage.initOwner(primaryStage);
            fx.start(popUpStage);
        } catch (Exception ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
