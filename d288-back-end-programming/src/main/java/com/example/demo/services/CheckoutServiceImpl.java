package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Cart;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

import static com.example.demo.entities.StatusType.ordered;

@Service
public class CheckoutServiceImpl implements CheckoutService {


    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse checkout(Purchase purchase) {
        //retrieve the cart info from dto
        Cart cart = purchase.getCart();
        cart.setStatus(ordered);

        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrder_tracking_number(orderTrackingNumber);

        // Populate cart with CartItems
        Set<CartItem> cartItems = purchase.getCartItems();

        for(CartItem cartItem : cartItems){
            cart.addCartItems(cartItem);
        }





        //save to the Database
        cartRepository.save(cart);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);

    }

    private String generateOrderTrackingNumber() {
        //generate a random UUID number
        return UUID.randomUUID().toString();

    }


}