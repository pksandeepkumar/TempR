
package com.sbl.elegislature.models.pojo.reporterusers;

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
    "data",
    "hasError",
    "hasDuplicate"
})
public class GetAllUsersPOJO {

    @JsonProperty("data")
    private List<ReporterUsersData> data = null;
    @JsonProperty("hasError")
    private Boolean hasError;
    @JsonProperty("hasDuplicate")
    private Boolean hasDuplicate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("data")
    public List<ReporterUsersData> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<ReporterUsersData> data) {
        this.data = data;
    }

    @JsonProperty("hasError")
    public Boolean getHasError() {
        return hasError;
    }

    @JsonProperty("hasError")
    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    @JsonProperty("hasDuplicate")
    public Boolean getHasDuplicate() {
        return hasDuplicate;
    }

    @JsonProperty("hasDuplicate")
    public void setHasDuplicate(Boolean hasDuplicate) {
        this.hasDuplicate = hasDuplicate;
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
