
package com.sbl.elegislature.models.pojo.businestype;

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
    "name",
    "localName",
    "order",
    "ruleNumber",
    "isLob",
    "isProceeedings",
    "isMember",
    "isDepartment",
    "isCommittee",
    "isActive",
    "code"
})
public class BusinessTypeData {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("localName")
    private String localName;
    @JsonProperty("order")
    private Integer order;
    @JsonProperty("ruleNumber")
    private Integer ruleNumber;
    @JsonProperty("isLob")
    private Integer isLob;
    @JsonProperty("isProceeedings")
    private Integer isProceeedings;
    @JsonProperty("isMember")
    private Integer isMember;
    @JsonProperty("isDepartment")
    private Integer isDepartment;
    @JsonProperty("isCommittee")
    private Integer isCommittee;
    @JsonProperty("isActive")
    private Integer isActive;
    @JsonProperty("code")
    private String code;
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

    @JsonProperty("localName")
    public String getLocalName() {
        return localName;
    }

    @JsonProperty("localName")
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    @JsonProperty("order")
    public Integer getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(Integer order) {
        this.order = order;
    }

    @JsonProperty("ruleNumber")
    public Integer getRuleNumber() {
        return ruleNumber;
    }

    @JsonProperty("ruleNumber")
    public void setRuleNumber(Integer ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    @JsonProperty("isLob")
    public Integer getIsLob() {
        return isLob;
    }

    @JsonProperty("isLob")
    public void setIsLob(Integer isLob) {
        this.isLob = isLob;
    }

    @JsonProperty("isProceeedings")
    public Integer getIsProceeedings() {
        return isProceeedings;
    }

    @JsonProperty("isProceeedings")
    public void setIsProceeedings(Integer isProceeedings) {
        this.isProceeedings = isProceeedings;
    }

    @JsonProperty("isMember")
    public Integer getIsMember() {
        return isMember;
    }

    @JsonProperty("isMember")
    public void setIsMember(Integer isMember) {
        this.isMember = isMember;
    }

    @JsonProperty("isDepartment")
    public Integer getIsDepartment() {
        return isDepartment;
    }

    @JsonProperty("isDepartment")
    public void setIsDepartment(Integer isDepartment) {
        this.isDepartment = isDepartment;
    }

    @JsonProperty("isCommittee")
    public Integer getIsCommittee() {
        return isCommittee;
    }

    @JsonProperty("isCommittee")
    public void setIsCommittee(Integer isCommittee) {
        this.isCommittee = isCommittee;
    }

    @JsonProperty("isActive")
    public Integer getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
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
