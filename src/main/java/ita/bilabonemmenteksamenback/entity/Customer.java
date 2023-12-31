package ita.bilabonemmenteksamenback.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    private String name;
    private String email;
    private String contactNumber;
    private String addressStreet;
    private String addressPost; //postcode
    private Boolean creditApproved;


    // constructors - JPA needs an empty one to initialize with
    public Customer(Long customerId, String name, String email, String contactNumber, String addressStreet, String addressCity, Boolean creditApproved) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.addressStreet = addressStreet;
        this.addressPost = addressCity;
        this.creditApproved = creditApproved;
    }

    // jpa requires an empty constructor
    public Customer() {}

    //getters and setters

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressPost() {
        return addressPost;
    }

    public void setAddressPost(String addressPost) {
        this.addressPost = addressPost;
    }

    public Boolean getCreditApproved() {
        return creditApproved;
    }

    public void setCreditApproved(Boolean creditApproved) {
        this.creditApproved = creditApproved;
    }
}
