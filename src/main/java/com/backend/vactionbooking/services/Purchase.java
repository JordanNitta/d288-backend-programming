package com.backend.vactionbooking.services;

import com.backend.vactionbooking.entities.Cart;
import com.backend.vactionbooking.entities.CartItem;
import com.backend.vactionbooking.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
