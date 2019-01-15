
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
    "reporterGroupTypes"
})
public class Data {

    @JsonProperty("reporterGroupTypes")
    private List<ReporterGroupType> reporterGroupTypes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("reporterGroupTypes")
    public List<ReporterGroupType> getReporterGroupTypes() {
        return reporterGroupTypes;
    }

    @JsonProperty("reporterGroupTypes")
    public void setReporterGroupTypes(List<ReporterGroupType> reporterGroupTypes) {
        this.reporterGroupTypes = reporterGroupTypes;
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
