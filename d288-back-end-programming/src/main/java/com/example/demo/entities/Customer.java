package com.example.demo.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "customer_first_name", nullable = false)
    private String firstName;
    @Column(name = "customer_last_name", nullable = false)
    private String lastName;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "postal_code", nullable = false)
    private String postal_code;
    @Column(name = "phone", nullable = false)
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToMany(mappedBy = "customer")
    private Set<Cart> carts;


    public Customer() {
    }

    public Customer(String firstName, String lastName, String address, String postal_code, String phone, Date create_date, Date last_update, Division division) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.create_date = create_date;
        this.last_update = last_update;
        this.division = division;
    }



}



