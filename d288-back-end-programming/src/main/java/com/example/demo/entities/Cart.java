package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name="carts")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="cart_id")
    private Long id;

    @Column(name ="order_tracking_number")
    private String order_tracking_number;
    @Column(name ="package_price")
    private BigDecimal package_price;
    @Column(name ="party_size")
    private int party_size;


    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private Set<CartItem> cartItems =new HashSet<>();


    public void addCartItems(CartItem cartItem ){
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }





}