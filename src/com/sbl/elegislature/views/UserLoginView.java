/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views;

import com.sbl.elegislature.ReporterApp;
import com.sbl.elegislature.service.GeneralService;
import com.sbl.elegislature.util.SuccessfullLoginEventListener;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import static com.sbl.elegislature.service.GeneralService.generalServiceInstance;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class UserLoginView extends HBox {

    String user = "1";
    String pw = "1";
    String checkUser, checkPw;
    
    TextField txtUserName;
    PasswordField txtPassword;
    Label lblMessage;
    
    private final SuccessfullLoginEventListener listener;
    
    /**
     *
     * @param listener
     */
    public UserLoginView(SuccessfullLoginEventListener listener) {
        
        setAlignment(Pos.CENTER);
        BorderPane.setAlignment(this, Pos.CENTER);
        setPadding(new Insets(20, 20, 20, 30));

        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(5);

        //Implementing Nodes for GridPane
        Label lblUserName = new Label("Username");
        txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        txtPassword = new PasswordField();
        Button btnLogin = new Button("Login");
        lblMessage = new Label();
        
        txtUserName.setText("chiefEditor1");
        txtPassword.setText("password");

        //Reflection for gridPane
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);

        //DropShadow effect 
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        
        Text text = new Text("Login");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        
        gridPane.add(text, 0, 0, 2, 1);
        GridPane.setHalignment(text, HPos.CENTER);
        
        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 1);
        gridPane.add(txtUserName, 1, 1);
        gridPane.add(lblPassword, 0, 2);
        gridPane.add(txtPassword, 1, 2);
        gridPane.add(btnLogin, 1, 3);
        gridPane.add(lblMessage, 0, 4, 2, 1);
        gridPane.getStyleClass().add("loginGrid");
        
        //Add ID's to Nodes
        setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        text.setId("logintext");

        btnLogin.setOnAction((ActionEvent event) -> {
            doLogin();
        });
        
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().add(gridPane);
        getChildren().add(vBox);
        this.listener=listener;
    }
    
    public void doLogin() {
        lblMessage.setText("");
        String username = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();
        
        if( username.length() == 0 || password.length() == 0) {
            lblMessage.setText("Please enter a valid user name and password!");
            lblMessage.setTextFill(Color.RED);
            return;
        }
        
        boolean checkLogin = GeneralService.generalServiceInstance().doLogin(username, password);
        
        if(checkLogin) {
            this.listener.onSuccessfullLoginEvent();
        } else {
           lblMessage.setText("Incorrect username or password");
           lblMessage.setTextFill(Color.RED);
        }
        
    }
    
    
}
