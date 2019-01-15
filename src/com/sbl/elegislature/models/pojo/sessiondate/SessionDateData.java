
package com.sbl.elegislature.models.pojo.sessiondate;

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
    "sessionDate",
    "sessionDateWords",
    "sessionDateLocal",
    "startTime",
    "startTimeLocal",
    "endTime",
    "endTimeLocal",
    "isSitting",
    "isActive",
    "sessionId"
})
public class SessionDateData {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("sessionDate")
    private String sessionDate;
    @JsonProperty("sessionDateWords")
    private String sessionDateWords;
    @JsonProperty("sessionDateLocal")
    private String sessionDateLocal;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("startTimeLocal")
    private String startTimeLocal;
    @JsonProperty("endTime")
    private String endTime;
    @JsonProperty("endTimeLocal")
    private String endTimeLocal;
    @JsonProperty("isSitting")
    private Integer isSitting;
    @JsonProperty("isActive")
    private Integer isActive;
    @JsonProperty("sessionId")
    private Integer sessionId;
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

    @JsonProperty("sessionDate")
    public String getSessionDate() {
        return sessionDate;
    }

    @JsonProperty("sessionDate")
    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    @JsonProperty("sessionDateWords")
    public String getSessionDateWords() {
        return sessionDateWords;
    }

    @JsonProperty("sessionDateWords")
    public void setSessionDateWords(String sessionDateWords) {
        this.sessionDateWords = sessionDateWords;
    }

    @JsonProperty("sessionDateLocal")
    public String getSessionDateLocal() {
        return sessionDateLocal;
    }

    @JsonProperty("sessionDateLocal")
    public void setSessionDateLocal(String sessionDateLocal) {
        this.sessionDateLocal = sessionDateLocal;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("startTimeLocal")
    public String getStartTimeLocal() {
        return startTimeLocal;
    }

    @JsonProperty("startTimeLocal")
    public void setStartTimeLocal(String startTimeLocal) {
        this.startTimeLocal = startTimeLocal;
    }

    @JsonProperty("endTime")
    public String getEndTime() {
        return endTime;
    }

    @JsonProperty("endTime")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @JsonProperty("endTimeLocal")
    public String getEndTimeLocal() {
        return endTimeLocal;
    }

    @JsonProperty("endTimeLocal")
    public void setEndTimeLocal(String endTimeLocal) {
        this.endTimeLocal = endTimeLocal;
    }

    @JsonProperty("isSitting")
    public Integer getIsSitting() {
        return isSitting;
    }

    @JsonProperty("isSitting")
    public void setIsSitting(Integer isSitting) {
        this.isSitting = isSitting;
    }

    @JsonProperty("isActive")
    public Integer getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("sessionId")
    public Integer getSessionId() {
        return sessionId;
    }

    @JsonProperty("sessionId")
    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
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
        return sessionDate;
    }

}
