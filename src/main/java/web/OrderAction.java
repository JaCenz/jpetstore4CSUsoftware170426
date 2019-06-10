package web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import domain.Account;
import domain.Cart;
import domain.Order;
import service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderAction implements Action {
    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();

    private Order order;
    private Integer orderId;

    private String shippingAddressRequired;

    public String getShippingAddressRequired() { return shippingAddressRequired; }

    public void setShippingAddressRequired(String shippingAddressRequired) { this.shippingAddressRequired = shippingAddressRequired; }

    public Integer getOrderId() { return orderId; }

    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    OrderService orderService = new OrderService();

    public String execute(){
        return SUCCESS;
    }

    //查看订单
    public String viewOrder(){
        Account account = (Account) session.get("account");
        Cart cart = (Cart) session.get("cart");

        if(cart == null){
            cart = new Cart();
            session.put("cart",cart);
        }

        if(account == null){
            return "login";
        }else {
            Order order = new Order();
            order.initOrder(account,cart);
            Date date = new Date();

//            order.setExpiryDate(new java.sql.Date(date.getTime()).toString());
            order.setOrderDate(new java.sql.Date(date.getTime()));

            List<String> cardType = new ArrayList<String>();
            cardType.add("Visa");
            cardType.add("MasterCard");
            cardType.add("American Express");

            session.put("order",order);
        }
        return SUCCESS;
    }

    //跳往确认订单界面
    public String viewConfirmOrder(){
        Order order = (Order) session.get("order");
        session.put("order",order);
        if(shippingAddressRequired == null){
            return SUCCESS;
        }
        return "shipping";
    }

    //确认shippingForm,跳往确认订单
    public String confirmShip(){
        Order finalOrder = (Order)session.get("order");
        session.put("order",finalOrder);
        return SUCCESS;
    }

    //确认并生成订单
    public String confirmOrder(){
        Order order = (Order) session.get("order");
        orderService.insertOrder(order);

        //重置购物车
        Cart cart = new Cart();
        session.put("cart",cart);

        return SUCCESS;
    }


    //查看用户的历史订单
    public String checkOrder(){
         Account account = (Account)session.get("account");
         List<Order> orderList = orderService.getOrdersByUsername(account.getUsername());

         session.put("orderList",orderList);

         return SUCCESS;
    }

    //查看一个具体订单
    public String viewOrderById(){
        Order order =  orderService.getOrder(orderId);
        session.put("order",order);

        return SUCCESS;
    }

}
