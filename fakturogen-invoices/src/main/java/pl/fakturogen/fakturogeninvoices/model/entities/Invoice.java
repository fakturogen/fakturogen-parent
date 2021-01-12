package pl.fakturogen.fakturogeninvoices.model.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "payment_status", nullable = false)
    private Integer paymentStatus; // enum?
    @Column(name = "purchasing_party_id")
    private Integer purchasingPartyId;
    @Column(name = "reciving_party_id")
    private Integer receivingPartyId;
    @Column(name = "payment_type_id", nullable = false)
    private Integer paymentTypeId;
    @Column(name = "bank_acount_id")
    private Integer bankAccountId;
    @Column(name = "slaes_date")
    private LocalDateTime salesDate;
    @Column(name = "invoice_type")
    private Integer invoiceType;
    @OneToMany
    private List<Product> products;
    private String description;
    @Column(name = "issue_date")
    private LocalDateTime issueDate;
    private String number;
    private Integer status;
    @Column(name = "invoice_id")
    private Integer invoiceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setReceivingPartyId(Integer peceivingPartyId) {
        this.receivingPartyId = peceivingPartyId;
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

    public LocalDateTime getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(LocalDateTime salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
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

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id.equals(invoice.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", paymentStatus=" + paymentStatus +
                ", purchasingPartyId=" + purchasingPartyId +
                ", peceivingPartyId=" + receivingPartyId +
                ", paymentTypeId=" + paymentTypeId +
                ", bankAccountId=" + bankAccountId +
                ", salesDate=" + salesDate +
                ", invoiceType=" + invoiceType +
                ", description='" + description + '\'' +
                ", issueDate=" + issueDate +
                ", number='" + number + '\'' +
                ", status=" + status +
                ", invoiceId=" + invoiceId +
                '}';
    }
}
