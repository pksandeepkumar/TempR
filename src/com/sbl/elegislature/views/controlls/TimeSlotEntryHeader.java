/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views.controlls;

import javafx.scene.control.Label;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 *
 * @author sandeepkumar
 */
public class TimeSlotEntryHeader extends HBox{
    
    int width;
    int fointSize = 19;

    public TimeSlotEntryHeader(int width) {
        this.width = width;
        
        setPrefWidth(width);
//        setMinWidth(width);
        initView();
        
    }
    
    public void initView() {
        Label tvGroupTitle = new Label("Group");
        setWidth(tvGroupTitle, (int)(this.width * 0.39));
        getChildren().add(tvGroupTitle);
        tvGroupTitle.setFont(new Font(fointSize));
        
        Label tvStartTime = new Label("Start Time");
        setWidth(tvStartTime, (int)(this.width * 0.29));
        getChildren().add(tvStartTime);
        tvStartTime.setFont(new Font(fointSize));
        
        Label tvEndTime = new Label("End Time");
        setWidth(tvEndTime, (int)(this.width * 0.29));
        getChildren().add(tvEndTime);
        tvEndTime.setFont(new Font(fointSize));
    }
    
    public void setWidth( Label tv, int width) {
        tv.setPrefWidth(width);
//        tv.setMinWidth(width);
    } 
    
    
    
}
