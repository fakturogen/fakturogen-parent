
package pl.fakturogen.comarch.connector.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;
/**
 * @author ewa-git
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "$id",
    "Name",
    "CustomerTaxNumber",
    "CustomerCode",
    "Mail",
    "PhoneNumber",
    "CustomerType",
    "Address",
    "Id"
})
public class ComarchCustomer {

    @JsonProperty("$id")
    private String $id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("CustomerTaxNumber")
    private String customerTaxNumber;
    @JsonProperty("CustomerCode")
    private String customerCode;
    @JsonProperty("Mail")
    private String mail;
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
    @JsonProperty("CustomerType")
    private Integer customerType;
    @JsonProperty("Address")
    private ComarchAddress address;
    @JsonProperty("Id")
    private Integer id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("$id")
    public String get$id() {
        return $id;
    }

    @JsonProperty("$id")
    public void set$id(String $id) {
        this.$id = $id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("CustomerTaxNumber")
    public String getCustomerTaxNumber() {
        return customerTaxNumber;
    }

    @JsonProperty("CustomerTaxNumber")
    public void setCustomerTaxNumber(String customerTaxNumber) {
        this.customerTaxNumber = customerTaxNumber;
    }

    @JsonProperty("CustomerCode")
    public String getCustomerCode() {
        return customerCode;
    }

    @JsonProperty("CustomerCode")
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @JsonProperty("Mail")
    public String getMail() {
        return mail;
    }

    @JsonProperty("Mail")
    public void setMail(String mail) {
        this.mail = mail;
    }

    @JsonProperty("PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("PhoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("CustomerType")
    public Integer getCustomerType() {
        return customerType;
    }

    @JsonProperty("CustomerType")
    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    @JsonProperty("Address")
    public ComarchAddress getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(ComarchAddress address) {
        this.address = address;
    }

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
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
        return "ComarchCustomer{" +
                "$id='" + $id + '\'' +
                ", name='" + name + '\'' +
                ", customerTaxNumber='" + customerTaxNumber + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", mail='" + mail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerType=" + customerType +
                ", address=" + address +
                ", id=" + id +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
