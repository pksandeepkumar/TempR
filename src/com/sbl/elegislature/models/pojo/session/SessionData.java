
package com.sbl.elegislature.models.pojo.session;

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
    "description",
    "isActive",
    "provisionalCalenderFile",
    "rotationOfMinisterFile",
    "endDate",
    "localName",
    "noSitting",
    "noSittingLocal",
    "sessionName",
    "startDate",
    "sessionTypeId",
    "sessionTypeName",
    "assemblyId",
    "assemblyName",
    "sessionCode",
    "offset",
    "limit",
    "lastSubmissionDate"
})
public class SessionData {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("provisionalCalenderFile")
    private String provisionalCalenderFile;
    @JsonProperty("rotationOfMinisterFile")
    private String rotationOfMinisterFile;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("localName")
    private String localName;
    @JsonProperty("noSitting")
    private Integer noSitting;
    @JsonProperty("noSittingLocal")
    private String noSittingLocal;
    @JsonProperty("sessionName")
    private String sessionName;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("sessionTypeId")
    private Integer sessionTypeId;
    @JsonProperty("sessionTypeName")
    private String sessionTypeName;
    @JsonProperty("assemblyId")
    private Integer assemblyId;
    @JsonProperty("assemblyName")
    private String assemblyName;
    @JsonProperty("sessionCode")
    private String sessionCode;
    @JsonProperty("offset")
    private Object offset;
    @JsonProperty("limit")
    private Object limit;
    @JsonProperty("lastSubmissionDate")
    private String lastSubmissionDate;
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

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("provisionalCalenderFile")
    public String getProvisionalCalenderFile() {
        return provisionalCalenderFile;
    }

    @JsonProperty("provisionalCalenderFile")
    public void setProvisionalCalenderFile(String provisionalCalenderFile) {
        this.provisionalCalenderFile = provisionalCalenderFile;
    }

    @JsonProperty("rotationOfMinisterFile")
    public String getRotationOfMinisterFile() {
        return rotationOfMinisterFile;
    }

    @JsonProperty("rotationOfMinisterFile")
    public void setRotationOfMinisterFile(String rotationOfMinisterFile) {
        this.rotationOfMinisterFile = rotationOfMinisterFile;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("localName")
    public String getLocalName() {
        return localName;
    }

    @JsonProperty("localName")
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    @JsonProperty("noSitting")
    public Integer getNoSitting() {
        return noSitting;
    }

    @JsonProperty("noSitting")
    public void setNoSitting(Integer noSitting) {
        this.noSitting = noSitting;
    }

    @JsonProperty("noSittingLocal")
    public String getNoSittingLocal() {
        return noSittingLocal;
    }

    @JsonProperty("noSittingLocal")
    public void setNoSittingLocal(String noSittingLocal) {
        this.noSittingLocal = noSittingLocal;
    }

    @JsonProperty("sessionName")
    public String getSessionName() {
        return sessionName;
    }

    @JsonProperty("sessionName")
    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("sessionTypeId")
    public Integer getSessionTypeId() {
        return sessionTypeId;
    }

    @JsonProperty("sessionTypeId")
    public void setSessionTypeId(Integer sessionTypeId) {
        this.sessionTypeId = sessionTypeId;
    }

    @JsonProperty("sessionTypeName")
    public String getSessionTypeName() {
        return sessionTypeName;
    }

    @JsonProperty("sessionTypeName")
    public void setSessionTypeName(String sessionTypeName) {
        this.sessionTypeName = sessionTypeName;
    }

    @JsonProperty("assemblyId")
    public Integer getAssemblyId() {
        return assemblyId;
    }

    @JsonProperty("assemblyId")
    public void setAssemblyId(Integer assemblyId) {
        this.assemblyId = assemblyId;
    }

    @JsonProperty("assemblyName")
    public String getAssemblyName() {
        return assemblyName;
    }

    @JsonProperty("assemblyName")
    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName;
    }

    @JsonProperty("sessionCode")
    public String getSessionCode() {
        return sessionCode;
    }

    @JsonProperty("sessionCode")
    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
    }

    @JsonProperty("offset")
    public Object getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Object offset) {
        this.offset = offset;
    }

    @JsonProperty("limit")
    public Object getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Object limit) {
        this.limit = limit;
    }

    @JsonProperty("lastSubmissionDate")
    public String getLastSubmissionDate() {
        return lastSubmissionDate;
    }

    @JsonProperty("lastSubmissionDate")
    public void setLastSubmissionDate(String lastSubmissionDate) {
        this.lastSubmissionDate = lastSubmissionDate;
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
        return sessionName;
    }
}
