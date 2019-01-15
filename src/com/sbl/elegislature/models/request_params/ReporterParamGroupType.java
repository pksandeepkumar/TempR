/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.models.request_params;

import com.sbl.elegislature.data.groups.GroupType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sandeep
 */
public class ReporterParamGroupType {
    
    Integer id;
    String name;
    List<ReporterParamGroup> reporterGroup;

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

    public List<ReporterParamGroup> getReporterGroup() {
        return reporterGroup;
    }

    public void setReporterGroup(List<ReporterParamGroup> reporterGroup) {
        this.reporterGroup = reporterGroup;
    }
    
    
    public ReporterParamGroupType(GroupType groupType) {
        this.id = groupType.getId();
        this.name = groupType.getName();
        this.reporterGroup = new ArrayList<>();
    }
    
    
}
