
package com.sbl.elegislature.models.pojo.members;

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
    "firstName",
    "lastName",
    "memberId",
    "name",
    "startDate",
    "endDate",
    "constituencyId",
    "constituencyName",
    "partyId",
    "partyName",
    "photo",
    "fps",
    "username"
})
public class MemberData {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("memberId")
    private Integer memberId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("constituencyId")
    private Integer constituencyId;
    @JsonProperty("constituencyName")
    private String constituencyName;
    @JsonProperty("partyId")
    private Integer partyId;
    @JsonProperty("partyName")
    private String partyName;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("fps")
    private List<Fp> fps = null;
    @JsonProperty("username")
    private String username;
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

    @JsonProperty("memberId")
    public Integer getMemberId() {
        return memberId;
    }

    @JsonProperty("memberId")
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("constituencyId")
    public Integer getConstituencyId() {
        return constituencyId;
    }

    @JsonProperty("constituencyId")
    public void setConstituencyId(Integer constituencyId) {
        this.constituencyId = constituencyId;
    }

    @JsonProperty("constituencyName")
    public String getConstituencyName() {
        return constituencyName;
    }

    @JsonProperty("constituencyName")
    public void setConstituencyName(String constituencyName) {
        this.constituencyName = constituencyName;
    }

    @JsonProperty("partyId")
    public Integer getPartyId() {
        return partyId;
    }

    @JsonProperty("partyId")
    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    @JsonProperty("partyName")
    public String getPartyName() {
        return partyName;
    }

    @JsonProperty("partyName")
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    @JsonProperty("photo")
    public String getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @JsonProperty("fps")
    public List<Fp> getFps() {
        return fps;
    }

    @JsonProperty("fps")
    public void setFps(List<Fp> fps) {
        this.fps = fps;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
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
