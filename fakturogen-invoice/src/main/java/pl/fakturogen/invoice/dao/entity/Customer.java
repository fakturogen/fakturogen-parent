package pl.fakturogen.invoice.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;
/**
 * @author ewa-git
 */


@Entity
@Table(name = Customer.TABLE_NAME)
public class Customer {
    public static final String TABLE_NAME = "customers";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //sequence
    private Long id;

    @Column(name = "id_external_api")
    private Long idExternalApi;

    @Column(nullable = false)
    private String name;

    private String nip;

    private String pesel;

    private String representative;

    private String phone;

    private String mobile;

    private String fax;

    private String www;

    @Column(name = "customer_code")
    private String customerCode;

    private String mail;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String status;

    private BigDecimal discount;

//    @Column(name = "payment_form")
    @ManyToOne
    private PaymentForm paymentForm;

    @ManyToOne
    private CustomerType customerType;

    @OneToOne
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdExternalApi() {
        return idExternalApi;
    }

    public void setIdExternalApi(Long idExternalApi) {
        this.idExternalApi = idExternalApi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public PaymentForm getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(PaymentForm paymentForm) {
        this.paymentForm = paymentForm;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(idExternalApi, customer.idExternalApi);
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
                ", nip='" + nip + '\'' +
                ", pesel='" + pesel + '\'' +
                ", representative='" + representative + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", fax='" + fax + '\'' +
                ", www='" + www + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", mail='" + mail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", status='" + status + '\'' +
                ", discount=" + discount +
                ", paymentForm=" + paymentForm +
                ", customerType=" + customerType +
                ", address=" + address +
                '}';
    }
}
