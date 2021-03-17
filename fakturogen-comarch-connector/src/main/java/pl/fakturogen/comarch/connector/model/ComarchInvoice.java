package pl.fakturogen.comarch.connector.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "$id",
        "PaymentStatus",
        "PurchasingPartyId",
        "ReceivingPartyId",
        "PaymentTypeId",
        "BankAccountId",
        "SalesDate",
        "InvoiceType",
        "Items",
        "Description",
        "IssueDate",
        "Number",
        "Status",
        "Id"
})
public class ComarchInvoice {

    @JsonProperty("$id")
    private String consecutiveNumber;
    @JsonProperty("PaymentStatus")
    private Integer paymentStatus;
    @JsonProperty("PurchasingPartyId")
    private Integer purchasingPartyId;
    @JsonProperty("ReceivingPartyId")
    private Integer receivingPartyId;
    @JsonProperty("PaymentTypeId")
    private Integer paymentTypeId;
    @JsonProperty("BankAccountId")
    private Integer bankAccountId;
    @JsonProperty("SalesDate")
    private String salesDate;
    @JsonProperty("InvoiceType")
    private Integer invoiceType;
    @JsonProperty("Items")
    private List<ComarchItem> items = null;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("IssueDate")
    private String issueDate;
    @JsonProperty("Number")
    private String number;
    @JsonProperty("Status")
    private Integer status;
    @JsonProperty("Id")
    private Integer id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("$id")
    public String getConsecutiveNumber() {
        return consecutiveNumber;
    }

    @JsonProperty("$id")
    public void setConsecutiveNumber(String consecutiveNumber) {
        this.consecutiveNumber = consecutiveNumber;
    }

    @JsonProperty("PaymentStatus")
    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    @JsonProperty("PaymentStatus")
    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @JsonProperty("PurchasingPartyId")
    public Integer getPurchasingPartyId() {
        return purchasingPartyId;
    }

    @JsonProperty("PurchasingPartyId")
    public void setPurchasingPartyId(Integer purchasingPartyId) {
        this.purchasingPartyId = purchasingPartyId;
    }

    @JsonProperty("ReceivingPartyId")
    public Object getReceivingPartyId() {
        return receivingPartyId;
    }

    @JsonProperty("ReceivingPartyId")
    public void setReceivingPartyId(Integer receivingPartyId) {
        this.receivingPartyId = receivingPartyId;
    }

    @JsonProperty("PaymentTypeId")
    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    @JsonProperty("PaymentTypeId")
    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    @JsonProperty("BankAccountId")
    public Object getBankAccountId() {
        return bankAccountId;
    }

    @JsonProperty("BankAccountId")
    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    @JsonProperty("SalesDate")
    public String getSalesDate() {
        return salesDate;
    }

    @JsonProperty("SalesDate")
    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    @JsonProperty("InvoiceType")
    public Integer getInvoiceType() {
        return invoiceType;
    }

    @JsonProperty("InvoiceType")
    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    @JsonProperty("Items")
    public List<ComarchItem> getItems() {
        return items;
    }

    @JsonProperty("Items")
    public void setItems(List<ComarchItem> items) {
        this.items = items;
    }

    @JsonProperty("Description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("IssueDate")
    public String getIssueDate() {
        return issueDate;
    }

    @JsonProperty("IssueDate")
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @JsonProperty("Number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("Number")
    public void setNumber(String number) {
        this.number = number;
    }

    @JsonProperty("Status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Integer status) {
        this.status = status;
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
        return "ComarchInvoice{" +
                "consecutiveNumber='" + consecutiveNumber + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", purchasingPartyId=" + purchasingPartyId +
                ", receivingPartyId=" + receivingPartyId +
                ", paymentTypeId=" + paymentTypeId +
                ", bankAccountId=" + bankAccountId +
                ", salesDate='" + salesDate + '\'' +
                ", invoiceType=" + invoiceType +
                ", items=" + items +
                ", description=" + description +
                ", issueDate='" + issueDate + '\'' +
                ", number='" + number + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
