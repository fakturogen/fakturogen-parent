package pl.fakturogen.comarch.api.customer;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Street",
        "BuildingNumber",
        "FlatNumber",
        "PostalCode",
        "City"
})
public class Address {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Street")
    private String street;
    @JsonProperty("BuildingNumber")
    private String buildingNumber;
    @JsonProperty("FlatNumber")
    private String flatNumber;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("City")
    private String city;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("Street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("BuildingNumber")
    public String getBuildingNumber() {
        return buildingNumber;
    }

    @JsonProperty("BuildingNumber")
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @JsonProperty("FlatNumber")
    public String getFlatNumber() {
        return flatNumber;
    }

    @JsonProperty("FlatNumber")
    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    @JsonProperty("PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("PostalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
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