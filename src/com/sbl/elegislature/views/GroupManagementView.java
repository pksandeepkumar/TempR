/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.views;

import com.sbl.elegislature.data.groups.Group;
import com.sbl.elegislature.data.groups.GroupType;
import com.sbl.elegislature.data.reporterusers.GroupMembers;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author sandeep
 */
public class GroupManagementView extends BorderPane {
    
     TableView t;
    TreeItem selectItem;
    TreeItem selectGroup;
    TreeItem selectGroupType;
    GroupMembers employeenew;//=new Employee();//
    Set s = new HashSet();
    boolean added;
    int groupIDInc;
    
    List<GroupMembers> employees;
    ObservableList<GroupType> groupTypes;
    ObservableList<Group> groups;
    TreeItem<Object> rootNode;

    public GroupManagementView() {
        setVisible(false);
    }
    
    
    
}
