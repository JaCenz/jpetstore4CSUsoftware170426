package service;

import java.util.List;

import domain.Category;
import domain.Item;
import domain.Product;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.*;


public class CatalogService {

  SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
  SqlSession session = sqlSessionFactory.openSession();

  CategoryDAO categoryDAO = session.getMapper(CategoryDAO.class);

  ItemDAO itemDAO = session.getMapper(ItemDAO.class);

  ProductDAO productDAO = session.getMapper(ProductDAO.class);

  public List<Category> getCategoryList() {
    return categoryDAO.getCategoryList();
  }

  public Category getCategory(String categoryId) {
    return categoryDAO.getCategory(categoryId);
  }

  public Product getProduct(String productId) {
    return productDAO.getProduct(productId);
  }

  public List<Product> getProductListByCategory(String categoryId) {
    return productDAO.getProductListByCategory(categoryId);
  }

  // TODO enable using more than one keyword
  public List<Product> searchProductList(String keyword) {
    return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
  }

  public List<Item> getItemListByProduct(String productId) {
    return itemDAO.getItemListByProduct(productId);
  }

  public Item getItem(String itemId) {
    return itemDAO.getItem(itemId);
  }

  public boolean isItemInStock(String itemId) {
    return itemDAO.getInventoryQuantity(itemId) > 0;
  }
}