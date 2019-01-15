/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.data;

import java.sql.Time;
import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class Slot {

    private Integer group_id;

    private Integer id;

    private Time startTime;

    private Time endTime;

    private Date createdOn;

    private Date modifiedOn;

    private String group_name;

    private Date modified_on;

    private Date modified_by;

    private Integer createdBy;

    private Integer modified_By;

    private Integer created_By;

    public Integer getModified_By() {
        return modified_By;
    }

    public void setModified_By(Integer modified_By) {
        this.modified_By = modified_By;
    }

    public Integer getCreated_By() {
        return created_By;
    }

    public void setCreated_By(Integer created_By) {
        this.created_By = created_By;
        this.createdBy = created_By;
    }

    public Date getModified_on() {
        return modified_on;
    }

    public void setModified_on(Date modified_on) {
        this.modified_on = modified_on;
    }

    public Date getModified_by() {
        return modified_by;
    }

    public void setModified_by(Date modified_by) {
        this.modified_by = modified_by;
    }

    //id=1, startTime=00:00:00, endTime=00:29:59, createdOn=2018-07-01T00:00:00.000+0530, modifiedOn=null, group_name=Synopsis1, group_id=1
    private final StringProperty groupIds = new SimpleStringProperty();

    public Slot(Time startTime, Time endTime) {

        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Slot() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public void setGroupIds(String group_id) {
        this.groupIds.set(group_id);
    }

    public String getGroupIds() {
        return groupIds.get();
    }

    public final StringProperty groupIdProperty() {
        return this.groupIds;
    }

    public void setGroupIDS() {
        String value = Integer.toString(this.group_id);
        this.groupIds.set(value);
    }

}
//
//    private final IntegerProperty slotId = new SimpleIntegerProperty();
//    private final StringProperty groupId = new SimpleStringProperty();
//     Date startTime;// = new Date();//= new S;
//     Date endTime;// = new Date();
//
//    public Slot(int slotId, String groupId, Date startTime, Date endTime) {
//        setSlotId(slotId);
//        setGroupId(groupId);
//        this.startTime=startTime;//setStartTime(startTime.getTime());
//        this.endTime=endTime;//setEndTime(endTime.getTime());
//    }
//
//    public int getSlotId() {
//        return slotId.get();
//    }
//
//    public void setSlotId(int slotId) {
//        this.slotId.set(slotId);// slotId;
//    }
//
//    public String getGroupId() {
//        return groupId.get();
//    }
//
//    public void setGroupId(String groupId) {
//        this.groupId.set(groupId);// = groupId;
//    }
//
//    public Date getStartTime() {
//        return startTime;//return startTime.getTime();
//    }
//
//    public void setStartTime(Date startTime) {
//      this.startTime=startTime;//  this.startTime.setTime(startTime);// = startTime;
//    }
//
//    public Date getEndTime() {
//       return endTime;// return endTime.getTime();
//    }
//
//    public void setEndTime(Date endTime) {
//       this.endTime=endTime;// this.endTime.setTime(endTime);
//    }
//
//    public final StringProperty groupIdProperty() {
//        return this.groupId;
//    }
//
//}
