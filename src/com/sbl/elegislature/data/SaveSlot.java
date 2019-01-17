/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.data;

import com.sbl.elegislature.models.pojo.timeslots.SlotData;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class SaveSlot {

    private Integer id;
    private Date startTime;
    private Date endTime;
    private Date createdOn;
    private Date modifiedOn;
    private Integer group_id;
    private Integer createdBy;
    private String groupName;
    private Integer groupTypeId;
    

    public SaveSlot() {
    }
    
    
    public SaveSlot(SlotData data) {
        id = data.getId();
        startTime = new Date();
        startTime.setTime(data.getStartTime());
        
        endTime = new Date();
        endTime.setTime(data.getEndTime());
        
        group_id = data.getGroupId();
        groupName = data.getGroupName();
        groupTypeId = data.getGroupTypeId();
                
        
    }
    

    public SaveSlot(int groupId, String groupName) {
        this.group_id = groupId;
        this.groupName = groupName;
    }

    public SaveSlot(int groupId, String groupName, int createdBy) {
        this.group_id = groupId;
        this.groupName = groupName;
        this.createdBy = createdBy;
    }

    public Integer getGroupTypeId() {
        return groupTypeId;
    }

    public void setGroupTypeId(Integer groupTypeId) {
        this.groupTypeId = groupTypeId;
    }
    
    

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
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

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

}
