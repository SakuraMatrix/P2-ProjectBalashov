package com.github.SakuraMatrix.P2ProjectBalashov.htmlServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.SakuraMatrix.P2ProjectBalashov.htmlServer.domain.CartItem;
import com.github.SakuraMatrix.P2ProjectBalashov.htmlServer.domain.Customer;
import com.github.SakuraMatrix.P2ProjectBalashov.htmlServer.domain.Item;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
  public List<CartItem> findByCustomer(Customer customer);

  public CartItem findByCustomerAndItem(Customer customer, Item item);

  @Query("UPDATE CartItem c SET c.quantity =?1 WHERE c.item.id = ?2" + "AND c.customer.id = ?3")
  @Modifying
  public void updateQuantity(Integer quantity, Integer itemId, Integer customerId);  


  @Query("DELETE FROM CartItem c WHERE c.customer.id = ?1 AND c.item.id = ?2")
  @Modifying
  public void deleteByCustomerAndItem(Integer customerId, Integer itemId);
};