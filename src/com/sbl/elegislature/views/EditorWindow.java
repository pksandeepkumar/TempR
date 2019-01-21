/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views;

import com.sbl.elegislature.util.CustomHTMLEditor;
import com.sbl.elegislature.views.baseviews.BaseWindow;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author sandeep
 */
public class EditorWindow extends BaseWindow {

    public EditorWindow() {

        initViews();
    }

    @Override
    public void refreshWindow() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initViews() {
        
        String[] businessTypeList = {"Type 1", "Type 2", "Type 3", "Type 4", "Type 5"};
        String[] memberList = {"Member 1", "Member 2", "Member 3", "Member 4", "Member 5"};
        
        BorderPane editorPane = new BorderPane();
        CustomHTMLEditor customHTMLEditor = new CustomHTMLEditor();

        editorPane.setCenter(customHTMLEditor);
        BorderPane mainPane = new BorderPane();
        mainPane.setCenter(editorPane);
        mainPane.setLeft(createSideBar(businessTypeList, memberList));
        setCenter(mainPane);
        //mainPkane.setVisible(false);
    }

    private EditorWindowSideBar createSideBar(String[] businessType, String[] memberList) {
        EditorWindowSideBar sb = new EditorWindowSideBar(businessType, memberList);
        sb.setMaxWidth(300);
        return sb;
    }

}
