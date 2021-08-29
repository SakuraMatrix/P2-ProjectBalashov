package com.github.SakuraMatrix.P2ProjectBalashov.htmlServer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HtmlController {

  @GetMapping("/greeting")
  public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Team Balashov") String name,
      Model model) {
    model.addAttribute("name", name);
    return "greeting";
  }

  @GetMapping("/cart")
  public String showCart(Model model) {

    Customer customer = new Customer();
    List<CartItem> cartItems = cartService.listCartItems(customer);

    model.addAttribute("cartItems", cartItems);
    model.addAttribute("pageTitle", "Shopping Cart");
    return "cart";
  }
  
  // @Configuration
  // public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {      
  //     @Override
  //     public void addResourceHandlers(ResourceHandlerRegistry registry) {
  //         registry.addResourceHandler("/images/**")
  //         .addResourceLocations("file:ext-resources/")
  //         .setCachePeriod(0);
  //     }
  // }
}

