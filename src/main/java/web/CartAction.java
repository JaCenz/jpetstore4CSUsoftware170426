package web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import domain.Account;
import domain.Cart;
import domain.CartItem;
import domain.Item;
import org.apache.struts2.ServletActionContext;
import service.CatalogService;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.Map;

public class CartAction implements Action {
    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();
    HttpServletRequest request = ServletActionContext.getRequest();

    private String workingItemId;
    private Account account;
    private Cart cart;

    private String itemId;
    private Integer quantity;

    private CatalogService catalogService = new CatalogService();

    public String getWorkingItemId() { return workingItemId; }

    public void setWorkingItemId(String workingItemId) { this.workingItemId = workingItemId; }

    public Account getAccount() { return account; }

    public void setAccount(Account account) { this.account = account; }

    public Cart getCart() { return cart; }

    public void setCart(Cart cart) { this.cart = cart; }

    //格式化数字显示
    public String formatDouble(double s){
        DecimalFormat fmt = new DecimalFormat("\u0024##0.00");
        return fmt.format(s);

    }

    public String execute(){
        return SUCCESS;
    }

    //查看购物车
    public String viewCart(){
        cart = (Cart)session.get("cart");
        if(cart == null){
            cart = new Cart();
            session.put("cart",cart);
        }

        return SUCCESS;
    }

    //添加商品
    public String addItemToCart(){
        if(workingItemId != null){
            Cart cart = (Cart)session.get("cart");

            //如果购物车为空
            if(cart == null || cart.getNumberOfItems() == 0){
                cart = new Cart();
            }

            if(cart.containsItemId(workingItemId)){
                cart.incrementQuantityByItemId(workingItemId);
            }else{
                boolean isInStock = catalogService.isItemInStock(workingItemId);
                Item item = catalogService.getItem(workingItemId);
                cart.addItem(item,isInStock);
            }
            session.put("cart",cart);
        }
        return SUCCESS;
    }

    //从购物车移出商品
    public String removeItemFromCart(){
        Cart cart = (Cart) session.get("cart");
        Item item = cart.removeItemById(workingItemId);

        if(item == null){
             session.put("message","Attempted to remove null CartItem from Cart.");
             return ERROR;
        }

        return SUCCESS;
    }

    //更新购物车
    public String updateCart(){
        Cart cart = (Cart)session.get("cart");

        for(CartItem cartItem:cart.getCartItemList())
        {
            itemId = cartItem.getItem().getItemId();
            quantity = Integer.parseInt(request.getParameter(itemId));
            if(quantity > 0&& quantity <= 10000){
                cart.setInstockByItemId(itemId,true);
                cart.setQuantityByItemId(itemId,quantity);
            }
            else if (quantity > 10000)
            {
                cart.setInstockByItemId(itemId,false);
                cart.setQuantityByItemId(itemId,quantity);
            }
            else{
                cart.removeItemById(itemId);
            }
        }

        session.put("cart",cart);
        return SUCCESS;
    }
}
