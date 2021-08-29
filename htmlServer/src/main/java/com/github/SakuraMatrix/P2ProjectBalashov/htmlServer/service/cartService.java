import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.SakuraMatrix.P2ProjectBalashov.htmlServer.domain.CartItem;
import com.github.SakuraMatrix.P2ProjectBalashov.htmlServer.domain.Customer;

@Service
@Transactional
public class cartService {
  @Autowired
  private CartItemRepository cartRepo;

  @Autowired
  private ItemRepository itemRepo;

  public List<CartItem> listCartItems(Customer customer) {
    return cartRepo.findByCustomer(customer);
  }

  public Integer addItem(Integer itemId, Integer quantity, Customer customer) {
    Integer addedQuantity = quantity;

    Item item = itemRepo.findById(itemId).get();

    CartItem cartItem = cartRepo.findByCustomerAndItem(customer, item);

    if(cartItem != null ) {
      addedQuantity = cartItem.getQuantity() + quantity;
      cartItem.setQuantity(addedQuantity);
    } else {
      cartItem = new CartItem();
      cartItem.setQuantity(quantity);
      cartItem.setCustomer(customer);
      cartITem.setItem(item);
    }

    cartRepo.save(cartItem);

    return addedQuantity;
    }

    public float updateQuantity (Integer itemId, Integer quantity, Customer customer) {
    cartRepo.updateQuantity(quantity, itemId, customer.getId());
    Item item = itemRepo.findById(itemId).get();
    float subtotal = item.getPrice() * quantity;
    return subtotal;
  }

  public void deleteItemFromCart(Integer itemId, Customer customer) {
    cartRepo.deleteByCustomerAndItem(customer.getId(), itemId);
  }
}
  