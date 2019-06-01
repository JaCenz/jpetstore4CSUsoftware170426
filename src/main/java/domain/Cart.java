package domain;

//import com.ibatis.common.util.PaginatedArrayList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cart implements Serializable {

  private static final long serialVersionUID = 8329559983943337176L;
  private final Map<String, CartItem> itemMap = Collections.synchronizedMap(new HashMap<String, CartItem>());
  private final List<CartItem> itemList = new CopyOnWriteArrayList<>();

  public Iterator<CartItem> getCartItems() {
    return itemList.iterator();
  }

  public List<CartItem> getCartItemList() {
    return itemList;
  }

  public int getNumberOfItems() {
    return itemList.size();
  }

  public Iterator<CartItem> getAllCartItems() {
    return itemList.iterator();
  }

  public boolean containsItemId(String itemId) {
    return itemMap.containsKey(itemId);
  }

  public void addItem(Item item, boolean isInStock) {
    CartItem cartItem = (CartItem) itemMap.get(item.getItemId());
    if (cartItem == null) {
      cartItem = new CartItem();
      cartItem.setItem(item);
      cartItem.setQuantity(0);
      cartItem.setInStock(isInStock);
      itemMap.put(item.getItemId(), cartItem);
      itemList.add(cartItem);
    }
    cartItem.incrementQuantity();
  }

  public Item removeItemById(String itemId) {
    CartItem cartItem = (CartItem) itemMap.remove(itemId);
    if (cartItem == null) {
      return null;
    } else {
      itemList.remove(cartItem);
      return cartItem.getItem();
    }
  }

  public void emptyCart(Cart cart){
    List<CartItem> cartItemList = cart.getCartItemList();
    for(int i=0;i<cartItemList.size();i++)
    {
      String itemId = cartItemList.get(i).getItem().getItemId();
      removeItemById(itemId);
    }
  }

  public void incrementQuantityByItemId(String itemId) {
    CartItem cartItem = (CartItem) itemMap.get(itemId);
    cartItem.incrementQuantity();
  }

  public void setQuantityByItemId(String itemId, int quantity) {
    CartItem cartItem = (CartItem) itemMap.get(itemId);
    cartItem.setQuantity(quantity);
  }

  public void setInstockByItemId(String itemId,boolean isInstock){         //新加函数
    CartItem cartItem = (CartItem) itemMap.get(itemId);
    cartItem.setInStock(isInstock);
  }

  public BigDecimal getSubTotal() {
    BigDecimal subTotal = new BigDecimal("0");
    Iterator<CartItem> items = getAllCartItems();
    while (items.hasNext()) {
      CartItem cartItem = (CartItem) items.next();
      Item item = cartItem.getItem();
      BigDecimal listPrice = item.getListPrice();
      BigDecimal quantity = new BigDecimal(String.valueOf(cartItem.getQuantity()));
      subTotal = subTotal.add(listPrice.multiply(quantity));
    }
    return subTotal;
  }

  public BigDecimal getCartItemlistPriceByItemId(String itemId){
    BigDecimal listPrice = new BigDecimal("0");
    Iterator<CartItem> items = getAllCartItems();
    while (items.hasNext()){
      Item item = items.next().getItem();
      if(item.getItemId().equals(itemId))
      {
        listPrice = item.getListPrice();
        break;
      }
    }
    return listPrice;
  }
}
