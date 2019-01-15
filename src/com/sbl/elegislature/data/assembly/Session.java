/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.data.assembly;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class Session {

    private int id;
    private String description;
    private String isActive;
    private String provisionalCalenderFile;
    private String rotationOfMinisterFile;
    private String endDate;
    private String localName;
    private String noSitting;
    private String noSittingLocal;
    private String sessionName;
    private String startDate;
    private String sessionTypeId;
    private String assemblyId;
    private String offset;
    private String limit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getProvisionalCalenderFile() {
        return provisionalCalenderFile;
    }

    public void setProvisionalCalenderFile(String provisionalCalenderFile) {
        this.provisionalCalenderFile = provisionalCalenderFile;
    }

    public String getRotationOfMinisterFile() {
        return rotationOfMinisterFile;
    }

    public void setRotationOfMinisterFile(String rotationOfMinisterFile) {
        this.rotationOfMinisterFile = rotationOfMinisterFile;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getNoSitting() {
        return noSitting;
    }

    public void setNoSitting(String noSitting) {
        this.noSitting = noSitting;
    }

    public String getNoSittingLocal() {
        return noSittingLocal;
    }

    public void setNoSittingLocal(String noSittingLocal) {
        this.noSittingLocal = noSittingLocal;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSessionTypeId() {
        return sessionTypeId;
    }

    public void setSessionTypeId(String sessionTypeId) {
        this.sessionTypeId = sessionTypeId;
    }

    public String getAssemblyId() {
        return assemblyId;
    }

    public void setAssemblyId(String assemblyId) {
        this.assemblyId = assemblyId;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return sessionName;
    }
    
    

}
