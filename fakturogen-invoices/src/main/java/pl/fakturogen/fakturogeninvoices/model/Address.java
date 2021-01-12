package pl.fakturogen.fakturogeninvoices.model;

import javax.persistence.*;

@Entity
@Table(name = Address.TABLE_NAME)
public class Address {
    public static final String TABLE_NAME = "addresses";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "building_number", nullable = false)
    private String buildingNumber;

    @Column(name = "flat_number", nullable = false)
    private String flatNumber;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "city", nullable = false)
    private String city;
}
