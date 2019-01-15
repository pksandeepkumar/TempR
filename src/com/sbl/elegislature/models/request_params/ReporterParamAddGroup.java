/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.models.request_params;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sandeep
 */
public class ReporterParamAddGroup {
    
    List<ReporterParamGroupType> reporterGroupTypes;

    public ReporterParamAddGroup() {
        reporterGroupTypes = new ArrayList<>();
    }
    
    

    public List<ReporterParamGroupType> getReporterGroupTypes() {
        return reporterGroupTypes;
    }

    public void setReporterGroupTypes(List<ReporterParamGroupType> reporterGroupTypes) {
        this.reporterGroupTypes = reporterGroupTypes;
    }
    
    
    
}
