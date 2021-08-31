package com.github.SakuraMatrix.P2ProjectBalashov.htmlServer.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.RestController;

@RestController
public class CartRestController {
  @Autowired
  private CartService cartService;

  @Autowired
  private CustomerService customerService;
  
  @PostMapping("/cart/add/{pid}")
  public String addToCart(@PathVariable("pid") Integer itemId){

    System.out.println("addded item to cart with item id of: " + itemId);

    Customer customer = customerService.getCustomer();
    
    Integer addedQuantity = cartService.addItem(itemId, customer);

    System.out.println("Item added.");

    return addedQuantity + " item(s) of this product were added to your shopping cart.";
  }

  @PostMapping("/cart/update/{pid}/{qty}")
  public String updateQuantity(@PathVariable("pid") Integer itemId,
  @PathVariable("qty") Integer quantity) {

    System.out.println("added item to cart with item id of: " + itemId);

    Customer customer = customerService.getCustomer();

    Integer addedQuantity = cartService.updateQuantity(itemId, quantity, customer);

    System.out.println("Item quantity updated.");

    return addedQuantity + " item(s) of this product were added to your shopping cart.";
  }

  @PostMapping("/cart/delete/{pid}")
  public String deleteItemFromCart(@PathVariable("pid") Integer itemId) {

    System.out.println("deleted item from cart with item id of: " + itemId);

    Customer customer = customerService.getCustomer();

    cartService.deleteItem(itemId, customer);

    return "The item(s) have been deleted from your shopping cart.";
  }
}
