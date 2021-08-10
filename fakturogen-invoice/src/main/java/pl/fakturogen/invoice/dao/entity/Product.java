package pl.fakturogen.invoice.dao.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = Product.TABLE_NAME)
public class Product {

    final static String TABLE_NAME = "Products";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;

    @Column(name = "sale_net_price", nullable = false)
    private double saleNetPrice;

    @Column(name = "sale_gross_price", nullable = false)
    private double saleGrossPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "rate", nullable = false)
    private Rate rate;

    @Column(name = "id_external_api", nullable = false)
    private Long idExternalApi;

    public Long getIdExternalApi() {
        return idExternalApi;
    }

    public void setIdExternalApi(Long idExternalApi) {
        this.idExternalApi = idExternalApi;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public double getSaleNetPrice() {
        return saleNetPrice;
    }

    public void setSaleNetPrice(double saleNetPrice) {
        this.saleNetPrice = saleNetPrice;
    }

    public double getSaleGrossPrice() {
        return saleGrossPrice;
    }

    public void setSaleGrossPrice(double saleGrossPrice) {
        this.saleGrossPrice = saleGrossPrice;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(idExternalApi, product.idExternalApi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idExternalApi);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                ", saleNetPrice=" + saleNetPrice +
                ", saleGrossPrice=" + saleGrossPrice +
                ", rate=" + rate +
                ", idExternalApi=" + idExternalApi +
                '}';
    }
}
