package pl.fakturogen.invoice.dao.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * @author damian
 */

@Entity
@Table(name = InvoiceTemplate.TABLE_NAME)
public class InvoiceTemplate {

    final static String TABLE_NAME = "invoice_templates";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "issue_date", nullable = false)
    private LocalDate issueDate;
    @Column (name = "sale_date", nullable = false)
    private LocalDate saleDate;
    @Column (name = "payment_method", nullable = false)
    private String paymentMethod;
    @Column (name = "price_total", nullable = false)
    private Double priceTotal;
    @Column(name = "price_tax")
    private Double priceTax;
    @Column(name = "price_net", nullable = false)
    private Double priceNet;
    @Column(name = "discount_amount")
    private Double discountAmount;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceTemplate that = (InvoiceTemplate) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(issueDate, that.issueDate) &&
                Objects.equals(priceTotal, that.priceTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issueDate, priceTotal);
    }

    @Override
    public String toString() {
        return "InvoiceTemplate{" +
                "id=" + id +
                ", issueDate=" + issueDate +
                ", saleDate=" + saleDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", priceTotal=" + priceTotal +
                ", priceTax=" + priceTax +
                ", priceNet=" + priceNet +
                ", discountAmount=" + discountAmount +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Double getPriceTax() {
        return priceTax;
    }

    public void setPriceTax(Double priceTax) {
        this.priceTax = priceTax;
    }

    public Double getPriceNet() {
        return priceNet;
    }

    public void setPriceNet(Double priceNet) {
        this.priceNet = priceNet;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}