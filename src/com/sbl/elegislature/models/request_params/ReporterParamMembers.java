/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.models.request_params;

import com.sbl.elegislature.data.reporterusers.GroupMembers;
import com.sbl.elegislature.util.AppContext;
import java.util.Date;

/**
 *
 * @author sandeep
 */
public class ReporterParamMembers {

    Integer id;
    Integer groupId;
    Integer employeeId;
    Integer supervisorId;
    Integer level;
    Integer createdBy;
    Date createdOn;
    Integer modifiedBy;
    Date modifiedOn;

    public ReporterParamMembers(GroupMembers groupMember) {
        if( groupMember.getId() != 0)
            this.id = groupMember.getId();
        if(groupMember.getGroupId() != 0)
        this.groupId = groupMember.getGroupId();
        
        this.employeeId = groupMember.getEmployeeId();
        this.supervisorId = groupMember.getSessionDateId();
        this.level = groupMember.getLevel();
        this.createdBy = AppContext.application().employeeId;
        this.createdOn = groupMember.getCreatedOn();
        this.modifiedBy = AppContext.application().employeeId;
        this.modifiedOn = groupMember.getModifiedOn();
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
    
    

}
