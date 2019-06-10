package web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.Cart;
import domain.Order;
import service.OrderService;

import java.util.Date;
import java.util.Map;

public class AvoidAction extends ActionSupport {
    private static final long serialVersionUID = 2676453800249807631L;

    private Order order;

    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();
    OrderService orderService = new OrderService();
    /*private String username;
    private String birthday;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }*/

    @Override
    public String execute()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Order order = (Order) session.get("order");
        orderService.insertOrder(order);

        //重置购物车
        Cart cart = new Cart();
        session.put("cart",cart);

        System.out.println("已经插入数据库");

        return SUCCESS;
    }

    public String goTOInput(){
        return SUCCESS;
    }

}