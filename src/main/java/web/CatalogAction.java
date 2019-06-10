package web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import domain.*;
import service.CatalogService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class CatalogAction implements Action {
    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();

    private String categoryId;
    private String productId;
    private String itemId;
    private Cart cart;

    private CatalogService catalogService = new CatalogService();

    public String getCategoryId() { return categoryId; }

    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }

    public String getProductId(){ return productId;}

    public void setProductId(String productId){ this.productId = productId; }

    public String getItemId() { return itemId; }

    public void setItemId(String itemId) { this.itemId = itemId; }

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

    //跳往商品大类
    public String viewCategory(){
        if(categoryId != null){
            Category category = catalogService.getCategory(categoryId);
            List<Product> productList =catalogService.getProductListByCategory(categoryId);

            session.put("category",category);
            session.put("productList",productList);
        }

        return SUCCESS;
    }

    //跳往商品小类
    public String viewProduct(){
        if(productId != null){
            Product product = catalogService.getProduct(productId);
            List<Item> itemList = catalogService.getItemListByProduct(productId);

            session.put("product",product);
            session.put("itemList",itemList);
        }

        return SUCCESS;
    }

    //跳往某一指定商品
    public String viewItem(){
        if(itemId != null){
            Item item = catalogService.getItem(itemId);
            session.put("item",item);
        }
        return SUCCESS;
    }
}
