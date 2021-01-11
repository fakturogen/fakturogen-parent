package pl.fakturogen.fakturogeninvoices.model.entities;

import pl.fakturogen.fakturogeninvoices.model.Rate;

import javax.persistence.*;

@Entity
@Table(name = Product.TABLE_NAME)
public class Product {

    final static String TABLE_NAME = "Products";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "item_code", nullable = true)
    private String itemCode;

    @Column(name = "unit_of_measurement", nullable = false)
    private String unitOfMeasurement;

    @Column(name = "sale_net_price", nullable = false)
    private double saleNetPrice;

    @Column(name = "sale_gross_price", nullable = false)
    private double saleGrossPrice;

    @Column(name = "rate", nullable = false)
    private Rate rate;


}
