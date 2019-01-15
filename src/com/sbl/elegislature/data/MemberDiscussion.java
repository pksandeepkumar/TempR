/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.data;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author bipin
 */
public class MemberDiscussion {

    private final SimpleStringProperty memberName;
    private final SimpleStringProperty startTime;
    private final SimpleStringProperty endTime;

    private MemberDiscussion(String memberName, String startTime, String endTime) {
        this.memberName = new SimpleStringProperty(memberName);
        this.startTime = new SimpleStringProperty(startTime);
        this.endTime = new SimpleStringProperty(endTime);
    }

    public String getmemberName() {
        return memberName.get();
    }

    public void setmemberName(String memberName) {
        this.memberName.set(memberName);
    }

    public String getstartTime() {
        return startTime.get();
    }

    public void setstartTime(String startTime) {
        this.startTime.set(startTime);
    }

    public String getendTime() {
        return endTime.get();
    }

    public void setendTime(String endTime) {
        this.endTime.set(endTime);
    }
}
