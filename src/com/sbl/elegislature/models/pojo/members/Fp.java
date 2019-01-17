
package com.sbl.elegislature.models.pojo.members;

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
    "fpId",
    "fpData"
})
public class Fp {

    @JsonProperty("fpId")
    private String fpId;
    @JsonProperty("fpData")
    private String fpData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fpId")
    public String getFpId() {
        return fpId;
    }

    @JsonProperty("fpId")
    public void setFpId(String fpId) {
        this.fpId = fpId;
    }

    @JsonProperty("fpData")
    public String getFpData() {
        return fpData;
    }

    @JsonProperty("fpData")
    public void setFpData(String fpData) {
        this.fpData = fpData;
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
