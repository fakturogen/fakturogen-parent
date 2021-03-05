package pl.fakturogen.comarch.connector.model;

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
        "$id",
        "Name",
        "Description",
        "ItemCode",
        "ProductCode",
        "UnitOfMeasurment",
        "Rate",
        "SaleNetPrice",
        "SaleGrossPrice",
        "Quantity",
        "Id"
})
public class ComarchProduct {

    @JsonProperty("$id")
    private String $id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("ItemCode")
    private String itemCode;
    @JsonProperty("ProductCode")
    private String productCode;
    @JsonProperty("UnitOfMeasurment")
    private String unitOfMeasurment;
    @JsonProperty("Rate")
    private Integer rate;
    @JsonProperty("SaleNetPrice")
    private Double saleNetPrice;
    @JsonProperty("SaleGrossPrice")
    private Double saleGrossPrice;
    @JsonProperty("Quantity")
    private Double quantity;
    @JsonProperty("Id")
    private Long id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

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

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("ItemCode")
    public String getItemCode() {
        return itemCode;
    }

    @JsonProperty("ItemCode")
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @JsonProperty("ProductCode")
    public String getProductCode() {
        return productCode;
    }

    @JsonProperty("ProductCode")
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @JsonProperty("UnitOfMeasurment")
    public String getUnitOfMeasurment() {
        return unitOfMeasurment;
    }

    @JsonProperty("UnitOfMeasurment")
    public void setUnitOfMeasurment(String unitOfMeasurment) {
        this.unitOfMeasurment = unitOfMeasurment;
    }

    @JsonProperty("Rate")
    public Integer getRate() {
        return rate;
    }

    @JsonProperty("Rate")
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @JsonProperty("SaleNetPrice")
    public Double getSaleNetPrice() {
        return saleNetPrice;
    }

    @JsonProperty("SaleNetPrice")
    public void setSaleNetPrice(Double saleNetPrice) {
        this.saleNetPrice = saleNetPrice;
    }

    @JsonProperty("SaleGrossPrice")
    public Double getSaleGrossPrice() {
        return saleGrossPrice;
    }

    @JsonProperty("SaleGrossPrice")
    public void setSaleGrossPrice(Double saleGrossPrice) {
        this.saleGrossPrice = saleGrossPrice;
    }

    @JsonProperty("Quantity")
    public Double getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("Id")
    public Long getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Long id) {
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
        return "ComarchProduct{" +
                "$id='" + $id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", unitOfMeasurment='" + unitOfMeasurment + '\'' +
                ", rate=" + rate +
                ", saleNetPrice=" + saleNetPrice +
                ", saleGrossPrice=" + saleGrossPrice +
                ", quantity=" + quantity +
                ", id=" + id +
                '}';
    }
}
