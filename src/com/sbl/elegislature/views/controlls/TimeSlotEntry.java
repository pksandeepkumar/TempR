/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views.controlls;

import com.sbl.elegislature.data.SaveSlot;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

/**
 *
 * @author sandeepkumar
 */
public class TimeSlotEntry extends HBox{
    
    int width;
    int fointSize = 16;
    
    String groupName;
    
    public SaveSlot saveSlot;
    
    
    public TimePicker timePickerStart;
    public TimePicker timePickerEnd;

//    public TimeSlotEntry(int width, String groupName) {
//        this.width = width;
//        this.groupName = groupName;
//        initView();
//        
//    }
    
    public TimeSlotEntry(int width, SaveSlot saveSlot) {
        this.saveSlot = saveSlot;
        this.width = width;
        this.groupName = saveSlot.getGroupName();
        initView();
    }
    
    
    public void initView() {
        setPadding(new Insets(5));
        setPrefWidth(width);
        Label tvGroupTitle = new Label(groupName);
        setWidth(tvGroupTitle, (int)(this.width * 0.39));
        getChildren().add(tvGroupTitle);
        tvGroupTitle.setFont(new Font(fointSize));
        
        
        StackPane spStart = new StackPane();
        setWidth(spStart, (int)(this.width * 0.29));
        timePickerStart = new TimePicker();
        spStart.getChildren().add(timePickerStart);
        getChildren().add(spStart);
        
        StackPane spEnd = new StackPane();
        setWidth(spEnd, (int)(this.width * 0.29));
        timePickerEnd = new TimePicker();
        spEnd.getChildren().add(timePickerEnd);
        getChildren().add(spEnd);
        
        if(saveSlot.getStartTime() != null) {
            timePickerStart.setTime(saveSlot.getStartTime().getHours() + 1, 
                    saveSlot.getStartTime().getMinutes());
        }
        
        if(saveSlot.getEndTime()!= null) {
            timePickerEnd.setTime(saveSlot.getEndTime().getHours() + 1, 
                    saveSlot.getEndTime().getMinutes());
        }
    }
    
    public void setWidth( Label tv, int width) {
        tv.setPrefWidth(width);
//        tv.setMinWidth(width);
    } 
    
    public void setWidth( StackPane tv, int width) {
        tv.setPrefWidth(width);
//        tv.setMinWidth(width);
    } 
    
    public void loadSavedSlotData(){
        if(timePickerStart.isValidTime()) {
            saveSlot.setStartTime(timePickerStart.getDateObject());
        }
        
        if(timePickerEnd.isValidTime()) {
            saveSlot.setEndTime(timePickerEnd.getDateObject());
        }
    }
    
    
    
}
