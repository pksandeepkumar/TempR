/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views.baseviews;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author sandeep
 */
public abstract class BaseWindow extends BorderPane{
    
    public boolean isShowing;
    
    public void hideWindow() {
        setVisible(false);
        isShowing = false;
    }
    
    public void showWindow() {
        setVisible(true);
        isShowing = true;
    }
    
    public abstract void refreshWindow();
    
    
}
