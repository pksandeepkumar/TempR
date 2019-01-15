
package com.sbl.elegislature.models.pojo.user;

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
    "id",
    "firstName",
    "lastName",
    "isActive",
    "department",
    "departmentId",
    "designation",
    "designationId",
    "employeeId"
})
public class Data {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("department")
    private String department;
    @JsonProperty("departmentId")
    private Integer departmentId;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("designationId")
    private Integer designationId;
    @JsonProperty("employeeId")
    private Integer employeeId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }

    @JsonProperty("departmentId")
    public Integer getDepartmentId() {
        return departmentId;
    }

    @JsonProperty("departmentId")
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @JsonProperty("designation")
    public String getDesignation() {
        return designation;
    }

    @JsonProperty("designation")
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @JsonProperty("designationId")
    public Integer getDesignationId() {
        return designationId;
    }

    @JsonProperty("designationId")
    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    @JsonProperty("employeeId")
    public Integer getEmployeeId() {
        return employeeId;
    }

    @JsonProperty("employeeId")
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
