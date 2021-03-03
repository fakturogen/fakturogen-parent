package pl.fakturogen.comarch.connector.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "$id",
        "ProductId",
        "Quantity",
        "ProductCurrencyPrice",
        "ProductDescription",
        "Id"
})
public class ApiItem {

    @JsonProperty("$id")
    private String $id;
    @JsonProperty("ProductId")
    private Object productId;
    @JsonProperty("Quantity")
    private Double quantity;
    @JsonProperty("ProductCurrencyPrice")
    private Double productCurrencyPrice;
    @JsonProperty("ProductDescription")
    private String productDescription;
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

    @JsonProperty("ProductId")
    public Object getProductId() {
        return productId;
    }

    @JsonProperty("ProductId")
    public void setProductId(Object productId) {
        this.productId = productId;
    }

    @JsonProperty("Quantity")
    public Double getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("ProductCurrencyPrice")
    public Double getProductCurrencyPrice() {
        return productCurrencyPrice;
    }

    @JsonProperty("ProductCurrencyPrice")
    public void setProductCurrencyPrice(Double productCurrencyPrice) {
        this.productCurrencyPrice = productCurrencyPrice;
    }

    @JsonProperty("ProductDescription")
    public String getProductDescription() {
        return productDescription;
    }

    @JsonProperty("ProductDescription")
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
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
        return "ApiItem{" +
                "$id='" + $id + '\'' +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", productCurrencyPrice=" + productCurrencyPrice +
                ", productDescription='" + productDescription + '\'' +
                ", id=" + id +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
