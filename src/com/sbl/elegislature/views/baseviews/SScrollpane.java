/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views.baseviews;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;

/**
 *
 * @author sandeep
 */
public class SScrollpane extends ScrollPane {
    
    public void setWidth(int width) {
        setPrefWidth(width);
        setMaxWidth(width);
    }

    public void setPadding(int padding) {
        setPadding(new Insets(padding, padding, padding, padding));
    }

    public void setPaddingTop(int padding) {
        setPadding(new Insets(padding, 0, 0, 0));
    }

    public void setPaddingRight(int padding) {
        setPadding(new Insets(0, padding, 0, 0));
    }

    public void setPaddingLeft(int padding) {
        setPadding(new Insets(0, 0, 0, padding));
    }

    public void setPaddingBottom(int padding) {
        setPadding(new Insets(0, 0, padding, 0));
    }
    
}
