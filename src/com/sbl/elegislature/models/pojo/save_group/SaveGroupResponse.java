
package com.sbl.elegislature.models.pojo.save_group;

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
    "savedGroupCount",
    "savedEmployeeCount",
    "status"
})
public class SaveGroupResponse {

    @JsonProperty("savedGroupCount")
    private Integer savedGroupCount;
    @JsonProperty("savedEmployeeCount")
    private Integer savedEmployeeCount;
    @JsonProperty("status")
    private Boolean status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("savedGroupCount")
    public Integer getSavedGroupCount() {
        return savedGroupCount;
    }

    @JsonProperty("savedGroupCount")
    public void setSavedGroupCount(Integer savedGroupCount) {
        this.savedGroupCount = savedGroupCount;
    }

    @JsonProperty("savedEmployeeCount")
    public Integer getSavedEmployeeCount() {
        return savedEmployeeCount;
    }

    @JsonProperty("savedEmployeeCount")
    public void setSavedEmployeeCount(Integer savedEmployeeCount) {
        this.savedEmployeeCount = savedEmployeeCount;
    }

    @JsonProperty("status")
    public Boolean getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Boolean status) {
        this.status = status;
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
