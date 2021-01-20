package pl.fakturogen.invoice.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = Customer.TABLE_NAME)
public class Customer {
    public static final String TABLE_NAME = "customers";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_external_api")
    private long idExternalApi;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "customer_tax_number")
    private String customerTaxNumber;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated
    @Column(name = "customer_type")
    private CustomerType customerType;

    @OneToOne
    private Address address;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerTaxNumber() {
        return customerTaxNumber;
    }

    public void setCustomerTaxNumber(String customerTaxNumber) {
        this.customerTaxNumber = customerTaxNumber;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getIdExternalApi() {
        return idExternalApi;
    }

    public void setIdExternalApi(long idExternalApi) {
        this.idExternalApi = idExternalApi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                idExternalApi == customer.idExternalApi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idExternalApi);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", idExternalApi=" + idExternalApi +
                ", name='" + name + '\'' +
                ", customerTaxNumber='" + customerTaxNumber + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", mail='" + mail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerType=" + customerType +
                ", address=" + address +
                '}';
    }
}
