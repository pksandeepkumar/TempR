/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sbl.elegislature.data.assembly;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class SessionDate {
    
     private Integer id;
    private Date sessionDate;
    private String sessionDateWords;
    private String sessionDateLocal;
    private Time startTime;
    private String startTimeLocal;
    private Time endTime;
    private String endTimeLocal;
    private Short isSitting;
    private Short active;
    private Integer sessionId;
    private String date;
    private Short isActive;
    
    
    
    public void setDate(String date)
    {
        this.date=date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
        date=sessionDate.toString();
    }

    public String getSessionDateWords() {
        return sessionDateWords;
    }

    public void setSessionDateWords(String sessionDateWords) {
        this.sessionDateWords = sessionDateWords;
    }

    public String getSessionDateLocal() {
        return sessionDateLocal;
    }

    public void setSessionDateLocal(String sessionDateLocal) {
        this.sessionDateLocal = sessionDateLocal;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public String getStartTimeLocal() {
        return startTimeLocal;
    }

    public void setStartTimeLocal(String startTimeLocal) {
        this.startTimeLocal = startTimeLocal;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getEndTimeLocal() {
        return endTimeLocal;
    }

    public void setEndTimeLocal(String endTimeLocal) {
        this.endTimeLocal = endTimeLocal;
    }

    public Short getIsSitting() {
        return isSitting;
    }

    public void setIsSitting(Short isSitting) {
        this.isSitting = isSitting;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short isActive) {
        this.active = isActive;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }
    
    
    
    @Override
    public String toString()
            {
                return getDate();
            }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the isActive
     */
    public Short getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }
}
