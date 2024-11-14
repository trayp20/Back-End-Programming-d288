package com.example.demo.entities;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name ="divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division", nullable = false)
    private String division_name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;


    @Column(name ="country_id")
    private Long country_id;

    @ManyToOne
    @JoinColumn(name = "country_id",nullable = false, insertable = false,updatable = false)
    private Country country;

    @OneToMany(mappedBy = "division")
    private Set<Customer> customers;



    }


