package com.ns.greg.designpattern.pratice.shop.shop;

import com.ns.greg.designpattern.observer.pattern.CustomObservable;
import com.ns.greg.designpattern.observer.pattern.CustomObserver;
import com.ns.greg.designpattern.pratice.shop.Request;
import com.ns.greg.designpattern.pratice.shop.customer.Customer;
import com.ns.greg.designpattern.pratice.shop.product.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author gregho
 * @since 2019/10/27
 */
public abstract class Shop implements CustomObservable {

  public interface ExecutionCallback {

    void onRetrieved(Product product, int remained);

    void onRetrievedFailed(Product product, int current);
  }

  private final List<CustomObserver> warehouseList = new ArrayList<>();
  private final Map<Customer, List<Product>> orderList = new HashMap<>();

  /*--------------------------------
   * Custom observable functions
   *-------------------------------*/

  @Override public void notifier() {
    notifier(null);
  }

  @Override public void notifier(Object arg) {
    warehouseList.forEach(it -> it.update(arg));
  }

  @Override public void addObserver(CustomObserver customObserver) {
    warehouseList.add(customObserver);
  }

  @Override public void deleteObserver(CustomObserver customObserver) {
    warehouseList.remove(customObserver);
  }

  public void addNewProduct(Product product) {
    notifier(product);
  }

  public void restockProduct(String productId, int stock) {
    notifier(new Request(productId, stock));
  }

  public void preserveProduct(String productId, int stock) {
    notifier(new Request(productId, -stock, new ExecutionCallback() {
      @Override public void onRetrieved(Product product, int remained) {
        System.out.println("[SUCCESS] Product: " + productId + ", remained: " + remained);
        /* TODO: Vic Peng, create order */
      }

      @Override public void onRetrievedFailed(Product product, int remained) {
        System.out.println("[FAILED] Product: " + productId + ", current: " + remained);
      }
    }));
  }

  public boolean createOrder(Customer customer, String productId, int stock) {
    preserveProduct(productId, stock);
    return false;
  }

  public boolean executeOrder(Customer customer) {
    List<Product> order = orderList.get(customer);
    /* TODO:
     * output product name/quantity/money */
    return order != null && !order.isEmpty();
  }
}
