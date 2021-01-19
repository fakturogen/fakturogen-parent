package pl.fakturogen.invoice.dao.entity;

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

@Entity
@Table(name = "invoice")
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
    private String paymentMethod;
    private double total;
    private double tax;
    private double net;
    private double discount;
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

}
