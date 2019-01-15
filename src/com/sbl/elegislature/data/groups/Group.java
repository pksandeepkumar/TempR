/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.data.groups;

import java.util.Date;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class Group {

    private Integer id;
    private String name;
    private Date createdOn;
    private Date modifiedOn;
    private Boolean isActive;
    private Integer groupTypeIds;
    private Integer groupLeaderIds;
    
     

    public Group() {

    }

    public Group(int id, String name, Integer grouptypeid) {
        this.id = id;
        this.name = name;
        this.groupTypeIds = grouptypeid;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getGroupTypeIds() {
        return groupTypeIds;
    }

    public void setGroupTypeIds(Integer groupTypeId) {
        this.groupTypeIds = groupTypeId;
    }

    public Integer getGroupLeaderIds() {
        return groupLeaderIds;
    }

    public void setGroupLeaderIds(Integer groupLeaderId) {
        this.groupLeaderIds = groupLeaderId;
    }
      

    @Override
    public String toString() {
        return name;
    }

}
