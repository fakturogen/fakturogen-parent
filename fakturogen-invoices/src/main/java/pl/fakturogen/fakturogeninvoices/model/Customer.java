package pl.fakturogen.fakturogeninvoices.model;

import javax.persistence.*;

@Entity
@Table(name = Customer.TABLE_NAME)
public class Customer {
    public static final String TABLE_NAME = "customers";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "customer_tax_number", nullable = false)
    private String customerTaxNumber;

    @Column(name = "customer_code", nullable = false)
    private String customerCode;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated
    private CustomerType customerType;

    @OneToOne
    private Address address;




}
