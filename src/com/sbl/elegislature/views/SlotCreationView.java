/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views;

import com.sbl.elegislature.views.baseviews.SBorderPane;
import com.sbl.elegislature.views.baseviews.SScrollpane;
import com.sbl.elegislature.views.baseviews.SVBox;
import com.sbl.elegislature.views.controlls.TimeSlotEntry;
import com.sbl.elegislature.views.controlls.TimeSlotEntryHeader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 *
 * @author sandeep
 */
public class SlotCreationView extends SBorderPane{
    
    int width;

    public SlotCreationView(int width) {
        this.width = width;
        initViews();
    }
    
    private void initViews() {
        setWidth(width);
        
        Button btnSave = new Button("Save");
        SBorderPane bpForButton = new SBorderPane();
        bpForButton.setWidth(width);
        bpForButton.setRight(btnSave);
        bpForButton.setPadding(5);
        setBottom(bpForButton);
                
        
        SScrollpane scrollPane = new SScrollpane();
        scrollPane.setStyle("-fx-background-color:transparent;");
        scrollPane.setWidth(width);
        
        SVBox vBoxBody = new SVBox();
        setWidth(width);
        setLeft(vBoxBody);
        
        SVBox vBoxSlotsContainer = new SVBox();
        vBoxSlotsContainer.setWidth(width);
        scrollPane.setContent(vBoxSlotsContainer);
        
        TimeSlotEntryHeader entryHeader = new TimeSlotEntryHeader(width);
        vBoxBody.getChildren().add(entryHeader);
        vBoxBody.getChildren().add(scrollPane);
        
        
        for (int i = 0; i < 100; i++) {
            TimeSlotEntry entry = new TimeSlotEntry(width, "Group" + i);
            vBoxSlotsContainer.getChildren().add(entry);
        }
        
    }
   
}
