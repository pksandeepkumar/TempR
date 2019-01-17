/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.models.request_params;

import com.sbl.elegislature.data.groups.Group;
import com.sbl.elegislature.util.AppContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sandeep
 * 
 * This is use to send data as json to API
 */
public class ReporterParamGroup {
    
    private Integer id;
    private String name;
    private Date createdOn;
    private Date modifiedOn;
    private Boolean isActive;
    private Integer groupTypeId;
    private Integer createdBy;
    private Integer modifiedBy;
    private Integer groupLeaderId;
    private Integer sessionDateId;
    private List<ReporterParamMembers> reprterMembers;

    public ReporterParamGroup(Group group) {
        this.createdBy = AppContext.application().employeeId;
            this.createdOn = group.getCreatedOn();
            this.groupLeaderId = group.getGroupLeaderIds();
            this.groupTypeId = group.getGroupTypeIds();
            System.err.println("ReporterParamGroup group.getId():" + group.getId());
            if( group.getId() != 0)
                this.id = group.getId();
            this.isActive = true;
            this.modifiedBy = AppContext.application().employeeId;
            this.modifiedOn = group.getModifiedOn();
            this.name = group.getName();
            this.reprterMembers = new ArrayList<>();
            this.sessionDateId = AppContext.selectedSessionDateId;
    }
    
    
    

    public List<ReporterParamMembers> getReprterMembers() {
        return reprterMembers;
    }

    public void setReprterMembers(List<ReporterParamMembers> reprterMembers) {
        this.reprterMembers = reprterMembers;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getGroupTypeId() {
        return groupTypeId;
    }

    public void setGroupTypeId(Integer groupTypeId) {
        this.groupTypeId = groupTypeId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Integer getGroupLeaderId() {
        return groupLeaderId;
    }

    public void setGroupLeaderId(Integer groupLeaderId) {
        this.groupLeaderId = groupLeaderId;
    }

    public Integer getSessionDateId() {
        return sessionDateId;
    }

    public void setSessionDateId(Integer sessionDateId) {
        this.sessionDateId = sessionDateId;
    }
    
    
    
}
