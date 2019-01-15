/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views.controlls;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author sandeepkumar
 */
public class TimePicker extends HBox {
    
    TextField tvTime;
    Button btnAmPm;
    ChangeListener changeListener;
    

    public static final String AM = "AM";
    public static final String PM = "PM";

    public TimePicker() {
        initView();
    }

    private void initView() {
        tvTime = new TextField();
        tvTime.setPrefWidth(55);

        getChildren().add(tvTime);

        btnAmPm = new Button(AM);
        getChildren().add(btnAmPm);
        
        changeListener = (observable, oldValue, newValue) -> {
            setTimeText(formatValue((String)newValue, (String) oldValue));
        }; 

        tvTime.textProperty().addListener(changeListener);
        
        btnAmPm.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(btnAmPm.getText().equals(AM)) {
                    btnAmPm.setText(PM);
                } else {
                    btnAmPm.setText(AM);
                }
            }
        });
            
    }
    
    private void setTimeText(String str) {
        tvTime.textProperty().removeListener(changeListener);
            tvTime.setText(str);
            tvTime.textProperty().addListener(changeListener);
    }
    
    public void setTime(int hour, int minute, String amPm) {
        setTimeText(setPadding(hour) + ":" + setPadding(minute));
        btnAmPm.setText(amPm);
    }
    
    public String setPadding( int value) {
        if(value < 10) return "0"+value;
        return ""+value;
    }
    
    public boolean isValidTime() {
        if(tvTime.getText().trim().length()!= 5) {
            return false;
        }
        return true;
    }
    
    public String getTime() {
        return tvTime.getText();
    }
    
    public String getAmPm() {
        return btnAmPm.getText().trim();
    }
    
    private String formatValue(String value, String oldValue) {
        value = value.trim();
        if(value.length() == 0) return value;
        if(value.length() == 3) {
            return value;
        }
        if(value.length() > 5) {
            return oldValue;
        } 
            
        if(!Character.isDigit(value.charAt(value.length() - 1))) {
            return oldValue;
        }
        
        if(value.length() == 2) {
            if(oldValue.length() > 2) {
                return value;
            }
            return value + ":";
        }
        
        return value;
        
    }

}
