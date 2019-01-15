
package com.sbl.elegislature.models.pojo.group_member;

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
    "groupId",
    "employeeId",
    "supervisorId",
    "level",
    "createdBy",
    "createdOn",
    "modifiedBy",
    "modifiedOn",
    "name"
})
public class ReprterMember {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("groupId")
    private Integer groupId;
    @JsonProperty("employeeId")
    private Integer employeeId;
    @JsonProperty("supervisorId")
    private Integer supervisorId;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("createdBy")
    private Integer createdBy;
    @JsonProperty("createdOn")
    private Long createdOn;
    @JsonProperty("modifiedBy")
    private Integer modifiedBy;
    @JsonProperty("modifiedOn")
    private Long modifiedOn;
    @JsonProperty("name")
    private String name;
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

    @JsonProperty("groupId")
    public Integer getGroupId() {
        return groupId;
    }

    @JsonProperty("groupId")
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("employeeId")
    public Integer getEmployeeId() {
        return employeeId;
    }

    @JsonProperty("employeeId")
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @JsonProperty("supervisorId")
    public Integer getSupervisorId() {
        return supervisorId;
    }

    @JsonProperty("supervisorId")
    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("createdBy")
    public Integer getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("createdOn")
    public Long getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("modifiedBy")
    public Integer getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modifiedBy")
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonProperty("modifiedOn")
    public Long getModifiedOn() {
        return modifiedOn;
    }

    @JsonProperty("modifiedOn")
    public void setModifiedOn(Long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
