package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Item;
import domain.LineItem;
import domain.Order;
import domain.Sequence;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

  SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
  SqlSession sqlsession = sqlSessionFactory.openSession();

  @Autowired
  private ItemDAO itemDAO = sqlsession.getMapper(ItemDAO.class);
  @Autowired
  private OrderDAO orderDAO = sqlsession.getMapper(OrderDAO.class);
  @Autowired
  private SequenceDAO sequenceDAO = sqlsession.getMapper(SequenceDAO.class);
  @Autowired
  private LineItemDAO lineItemDAO = sqlsession.getMapper(LineItemDAO.class);

  public void insertOrder(Order order) {
    order.setOrderId(getNextId("ordernum"));
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      String itemId = lineItem.getItemId();
      Integer increment = new Integer(lineItem.getQuantity());
      Map<String, Object> param = new HashMap<String, Object>(2);
      param.put("itemId", itemId);
      param.put("increment", increment);
      itemDAO.updateInventoryQuantity(param);
    }

    orderDAO.insertOrder(order);
    orderDAO.insertOrderStatus(order);
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      lineItem.setOrderId(order.getOrderId());
      lineItemDAO.insertLineItem(lineItem);
    }
    sqlsession.commit();
    sqlsession.close();
  }

  public Order getOrder(int orderId) {
    Order order = orderDAO.getOrder(orderId);
    order.setLineItems(lineItemDAO.getLineItemsByOrderId(orderId));

    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      Item item = itemDAO.getItem(lineItem.getItemId());
      item.setQuantity(itemDAO.getInventoryQuantity(lineItem.getItemId()));
      lineItem.setItem(item);
    }

    return order;
  }

  public List<Order> getOrdersByUsername(String username) {
    return orderDAO.getOrdersByUsername(username);
  }

  public int getNextId(String name) {
    //Sequence sequence = new Sequence(name, -1);
    Sequence sequence = new Sequence();
    sequence.setName(name);
    sequence.setNextId(-1);
    sequence = (Sequence) sequenceDAO.getSequence(sequence);
    if (sequence == null) {
      throw new RuntimeException("Error: A null sequence was returned from the database (could not get next " + name
          + " sequence).");
    }
    //Sequence parameterObject = new Sequence(name, sequence.getNextId() + 1);
    Sequence parameterObject = new Sequence();
    parameterObject.setName(name);
    parameterObject.setNextId(sequence.getNextId() + 1);
    sequenceDAO.updateSequence(parameterObject);
    return sequence.getNextId();
  }

}
