package pl.fakturogen.comarch.connector.dto;

import lombok.Builder;
import pl.fakturogen.comarch.connector.model.ComarchItem;

import java.util.List;

@Builder
public class ComarchInvoiceDTO {

    private Integer paymentStatus;
    private Integer purchasingPartyId;
    private Integer receivingPartyId;
    private Integer paymentTypeId;
    private Integer bankAccountId;
    private String salesDate;
    private Integer invoiceType;
    private List<ComarchItem> items = null;
    private String description;
    private String issueDate;
    private String number;
    private Integer status;
    private Integer id;

    public ComarchInvoiceDTO(Integer paymentStatus, Integer purchasingPartyId, Integer receivingPartyId, Integer paymentTypeId, Integer bankAccountId, String salesDate, Integer invoiceType, List<ComarchItem> items, String description, String issueDate, String number, Integer status, Integer id) {
        this.paymentStatus = paymentStatus;
        this.purchasingPartyId = purchasingPartyId;
        this.receivingPartyId = receivingPartyId;
        this.paymentTypeId = paymentTypeId;
        this.bankAccountId = bankAccountId;
        this.salesDate = salesDate;
        this.invoiceType = invoiceType;
        this.items = items;
        this.description = description;
        this.issueDate = issueDate;
        this.number = number;
        this.status = status;
        this.id = id;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getPurchasingPartyId() {
        return purchasingPartyId;
    }

    public void setPurchasingPartyId(Integer purchasingPartyId) {
        this.purchasingPartyId = purchasingPartyId;
    }

    public Integer getReceivingPartyId() {
        return receivingPartyId;
    }

    public void setReceivingPartyId(Integer receivingPartyId) {
        this.receivingPartyId = receivingPartyId;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public List<ComarchItem> getItems() {
        return items;
    }

    public void setItems(List<ComarchItem> items) {
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ComarchInvoiceDTO{" +
                "paymentStatus=" + paymentStatus +
                ", purchasingPartyId=" + purchasingPartyId +
                ", receivingPartyId=" + receivingPartyId +
                ", paymentTypeId=" + paymentTypeId +
                ", bankAccountId=" + bankAccountId +
                ", salesDate='" + salesDate + '\'' +
                ", invoiceType=" + invoiceType +
                ", items=" + items +
                ", description='" + description + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", number='" + number + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
