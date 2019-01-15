/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.util;
import javafx.collections.FXCollections;
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
import javafx.scene.control.SplitPane;
/**
 *
 * @author bipin
 */
public class EditorSectionDockbarContent  extends SplitPane  {
     final Insets padding;

    public EditorSectionDockbarContent(String[] businessTypeList, String[] memberList) {
        padding = new Insets(5, 10, 5, 10);
        setDividerPositions(0.5f, 0.5f);
        setWidth(300);
    }

}
