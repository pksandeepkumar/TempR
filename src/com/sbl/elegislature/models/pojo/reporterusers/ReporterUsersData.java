
package com.sbl.elegislature.models.pojo.reporterusers;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userId",
    "employeeId",
    "name",
    "department",
    "designation",
    "depertmentId",
    "designationId"
})
public class ReporterUsersData {

    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("employeeId")
    private Integer employeeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("department")
    private String department;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("depertmentId")
    private Integer depertmentId;
    @JsonProperty("designationId")
    private Integer designationId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("employeeId")
    public Integer getEmployeeId() {
        return employeeId;
    }

    @JsonProperty("employeeId")
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    @JsonProperty("designation")
    public String getDesignation() {
        return designation;
    }

    @JsonProperty("designation")
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @JsonProperty("depertmentId")
    public Integer getDepertmentId() {
        return depertmentId;
    }

    @JsonProperty("depertmentId")
    public void setDepertmentId(Integer depertmentId) {
        this.depertmentId = depertmentId;
    }

    @JsonProperty("designationId")
    public Integer getDesignationId() {
        return designationId;
    }

    @JsonProperty("designationId")
    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
