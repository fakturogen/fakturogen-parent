package pl.fakturogen.invoice.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "purchasing_party_id")
    private Integer purchasingPartyId;
    @Column (name = "receiving_party_id")
    private Integer receivingPartyId;
    @Column (name = "bank_account_id")
    private Integer bankAccountId;
    @Column (name = ":invoice_type")
    private Integer invoiceType;
    @OneToMany
    private List<Product> items;
    private String description;
    @Column (name = "issue_date")
    private LocalDateTime issueDate;
    private String number;
    private Integer status;
    @Column (name = "orinal_id")
    private Long originalId; // Document id from provider database

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
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

    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
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
                ", purchasingPartyId=" + purchasingPartyId +
                ", receivingPartyId=" + receivingPartyId +
                ", bankAccountId=" + bankAccountId +
                ", invoiceType=" + invoiceType +
                ", items=" + items +
                ", description='" + description + '\'' +
                ", issueDate=" + issueDate +
                ", number='" + number + '\'' +
                ", status=" + status +
                ", originalId=" + originalId +
                '}';
    }
}
