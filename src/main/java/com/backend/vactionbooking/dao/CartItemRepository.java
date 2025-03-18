package com.backend.vactionbooking.dao;

import com.backend.vactionbooking.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

// Entity is CartItem
// Primary Key is long
@CrossOrigin
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
