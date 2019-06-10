package web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import domain.Product;
import service.CatalogService;

import java.util.List;
import java.util.Map;

public class SearchProductAction implements Action {
    private String keyword;
    CatalogService catalogService = new CatalogService();

    ActionContext actionContext = ActionContext.getContext();
    Map session = actionContext.getSession();

    public String getKeyword() { return keyword; }

    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String execute(){
        return SUCCESS;
    }

    //查找
    public String search(){
        List<Product> productList = catalogService.searchProductList(keyword);
        session.put("productList",productList);

        return SUCCESS;
    }
}
