package pl.fakturogen.invoice.dao.entity;

import pl.fakturogen.invoice.web.dto.CustomerDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @Column (name = "issue_date")
    private LocalDate issueDate;
    @Column (name = "sale_date")
    private LocalDate saleDate;
    @Column (name = "due_date")
    private LocalDate dueDate;
    @Column (name = "payment_method")
    private Integer paymentMethod;
    private Double total;
    private Double tax;
    private Double net;
    private Double discount;
    private Integer status;

    @OneToOne
    private Customer customer;
    @OneToMany
    private List<Product> items;

    @Column (name = "bank_account_id")
    private Integer bankAccountId;
    @Column (name = "invoice_type")
    private Integer invoiceType;
    @Column(name = "additional_information")
    private String additionalInformation;

    @Column (name = "orinal_id")
    private Long originalId; // Document id from provider database
    @Column (name = "created_on", nullable = false)
    private LocalDateTime createdOn;
    @Column (name = "updated_on")
    private LocalDateTime updatedOn;

    @PrePersist
    public void setCreatedOn() {
        this.createdOn = LocalDateTime.now();
    }
    @PreUpdate
    public void setUpdatedOn() {
        this.updatedOn = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public InvoiceSaveDTO getCustomer() {
        return invoiceSaveDTO;
    }

    public void setCustomer(InvoiceSaveDTO invoiceSaveDTO) {
        this.invoiceSaveDTO = invoiceSaveDTO;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) &&
                Objects.equals(number, invoice.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", issueDate=" + issueDate +
                ", saleDate=" + saleDate +
                ", dueDate=" + dueDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", total=" + total +
                ", tax=" + tax +
                ", net=" + net +
                ", discount=" + discount +
                ", status=" + status +
                ", customer=" + invoiceSaveDTO +
                ", items=" + items +
                ", bankAccountId=" + bankAccountId +
                ", invoiceType=" + invoiceType +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", originalId=" + originalId +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
