package com.backend.vactionbooking.services;

import com.backend.vactionbooking.dao.CartRepository;
import com.backend.vactionbooking.dao.CustomerRepository;
import com.backend.vactionbooking.entities.Cart;
import com.backend.vactionbooking.entities.CartItem;
import com.backend.vactionbooking.entities.Customer;
import com.backend.vactionbooking.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CartRepository cartRepository;
    private CustomerRepository customerRepository;
    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository){
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();

        String orderTrackingNumber = generateOrderTrackingNumber();

        cart.setOrderTrackingNumber(orderTrackingNumber);
        Set<CartItem> cartItem = purchase.getCartItems();

        // Check cartItem is empty return purchase response as empty cart
        if(cartItem.isEmpty()){
            return new PurchaseResponse("Cart is empty");
        }
        cartItem.forEach(item ->
                cart.add(item)
        );


        cart.setStatus(StatusType.ordered);
//        customer.add(cart);

        cartRepository.save(cart);
//        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    // unique id thats hard to guess and somewhat random
    private String generateOrderTrackingNumber() {
        // generate a random UUID number
        return UUID.randomUUID().toString();
    }
}
