/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views.controlls;

import com.sbl.elegislature.models.pojo.group_member.Data;
import com.sbl.elegislature.util.ReporterUtility;
import java.sql.Time;
import java.util.Date;
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
    
    int hour;
    int minute;
    

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
            if(isValidTime()) {
                loadTimeValue();
            }
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
    
    private void loadTimeValue() {
        String[] arrSplit = getTime().split(":");
        if(arrSplit.length >= 2) {
            hour = ReporterUtility.parseInt(arrSplit[0]);
            minute = ReporterUtility.parseInt(arrSplit[1]);
        }
    }
    
    private void setTimeText(String str) {
        tvTime.textProperty().removeListener(changeListener);
            tvTime.setText(str);
            tvTime.textProperty().addListener(changeListener);
    }
    
    public void setTime(int hour, int minute, String amPm) {
        this.hour = hour;
        this.minute = minute;
        
        btnAmPm.setText(amPm);
        if(hour >= 12) {
            this.hour = hour - 12;
            btnAmPm.setText(PM);
        }
        setTimeText(setPadding(hour) + ":" + setPadding(minute));
    }
    
    public void setTime(int hour, int minute) {
        
        this.hour = hour;
        this.minute = minute;
        
        if(minute >= 60 ) {
            minute = minute - 60;
            hour++;
        }
        
        btnAmPm.setText(AM);
        if(hour >= 12) {
            this.hour = hour - 12;
            btnAmPm.setText(PM);
        }
        setTimeText(setPadding(hour) + ":" + setPadding(minute));
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
    
    public int getHour() {
        return hour;
    }
    
    public int getMinute() {
        return minute;
    }
    
    public Date getDateObject() {
        Date date = new Date();
        if(btnAmPm.getText().equals(PM)) {
            date.setHours(hour + 11);
        } else {
            date.setHours(hour - 1);
        }
        date.setMinutes(minute - 1);
        return date;
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
