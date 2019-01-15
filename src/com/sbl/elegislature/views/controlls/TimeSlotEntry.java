/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views.controlls;

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

    public TimeSlotEntry(int width, String groupName) {
        this.width = width;
        this.groupName = groupName;
        setPadding(new Insets(5));
        setPrefWidth(width);
//        setMinWidth(width);
        initView();
        
    }
    
    public void initView() {
        Label tvGroupTitle = new Label(groupName);
        setWidth(tvGroupTitle, (int)(this.width * 0.39));
        getChildren().add(tvGroupTitle);
        tvGroupTitle.setFont(new Font(fointSize));
        
        
        StackPane spStart = new StackPane();
        setWidth(spStart, (int)(this.width * 0.29));
        TimePicker timePickerStart = new TimePicker();
        spStart.getChildren().add(timePickerStart);
        getChildren().add(spStart);
        
        StackPane spEnd = new StackPane();
        setWidth(spEnd, (int)(this.width * 0.29));
        TimePicker timePickerEnd = new TimePicker();
        spEnd.getChildren().add(timePickerEnd);
        getChildren().add(spEnd);
    }
    
    public void setWidth( Label tv, int width) {
        tv.setPrefWidth(width);
//        tv.setMinWidth(width);
    } 
    
    public void setWidth( StackPane tv, int width) {
        tv.setPrefWidth(width);
//        tv.setMinWidth(width);
    } 
    
    
    
}
