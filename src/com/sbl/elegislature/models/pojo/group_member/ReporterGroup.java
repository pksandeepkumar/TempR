
package com.sbl.elegislature.models.pojo.group_member;

import java.util.HashMap;
import java.util.List;
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
    "name",
    "createdOn",
    "modifiedOn",
    "isActive",
    "groupTypeId",
    "createdBy",
    "modifiedBy",
    "groupLeaderId",
    "sessionDateId",
    "reprterMembers"
})
public class ReporterGroup {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("createdOn")
    private Long createdOn;
    @JsonProperty("modifiedOn")
    private Long modifiedOn;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("groupTypeId")
    private Integer groupTypeId;
    @JsonProperty("createdBy")
    private Integer createdBy;
    @JsonProperty("modifiedBy")
    private Integer modifiedBy;
    @JsonProperty("groupLeaderId")
    private Integer groupLeaderId;
    @JsonProperty("sessionDateId")
    private Integer sessionDateId;
    @JsonProperty("reprterMembers")
    private List<ReprterMember> reprterMembers = null;
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("createdOn")
    public Long getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("createdOn")
    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    @JsonProperty("modifiedOn")
    public Long getModifiedOn() {
        return modifiedOn;
    }

    @JsonProperty("modifiedOn")
    public void setModifiedOn(Long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("groupTypeId")
    public Integer getGroupTypeId() {
        return groupTypeId;
    }

    @JsonProperty("groupTypeId")
    public void setGroupTypeId(Integer groupTypeId) {
        this.groupTypeId = groupTypeId;
    }

    @JsonProperty("createdBy")
    public Integer getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("modifiedBy")
    public Integer getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modifiedBy")
    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonProperty("groupLeaderId")
    public Integer getGroupLeaderId() {
        return groupLeaderId;
    }

    @JsonProperty("groupLeaderId")
    public void setGroupLeaderId(Integer groupLeaderId) {
        this.groupLeaderId = groupLeaderId;
    }

    @JsonProperty("sessionDateId")
    public Integer getSessionDateId() {
        return sessionDateId;
    }

    @JsonProperty("sessionDateId")
    public void setSessionDateId(Integer sessionDateId) {
        this.sessionDateId = sessionDateId;
    }

    @JsonProperty("reprterMembers")
    public List<ReprterMember> getReprterMembers() {
        return reprterMembers;
    }

    @JsonProperty("reprterMembers")
    public void setReprterMembers(List<ReprterMember> reprterMembers) {
        this.reprterMembers = reprterMembers;
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
