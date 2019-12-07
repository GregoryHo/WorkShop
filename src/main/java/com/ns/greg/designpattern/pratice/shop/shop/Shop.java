package com.ns.greg.designpattern.pratice.shop.shop;

import com.ns.greg.designpattern.observer.pattern.CustomObservable;
import com.ns.greg.designpattern.observer.pattern.CustomObserver;
import com.ns.greg.designpattern.pratice.shop.Request;
import com.ns.greg.designpattern.pratice.shop.customer.Customer;
import com.ns.greg.designpattern.pratice.shop.product.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  @Override
  public void notifier() {
    notifier(null);
  }

  @Override
  public void notifier(Object arg) {
    warehouseList.forEach(it -> it.update(arg));
  }

  @Override
  public void addObserver(CustomObserver customObserver) {
    warehouseList.add(customObserver);
  }

  @Override
  public void deleteObserver(CustomObserver customObserver) {
    warehouseList.remove(customObserver);
  }

  public void addNewProduct(Product product) {
    notifier(product);
  }

  public void restockProduct(String productId, int stock) {
    notifier(new Request(productId, stock));
  }

  public void preserveProduct(Customer customer, String productId, int stock) {
    notifier(new Request(productId, -stock, new ExecutionCallback() {
      @Override
      public void onRetrieved(Product product, int remained) {
        System.out.println("[SUCCESS] Product: " + productId + ", remained: " + remained);
        /* TODO: Vic Peng, create flawless order */
        List<Product> productList = getProductList(customer);
        for (int i = 0; i < stock; i++) {
          productList.add(product);
        }
        orderList.put(customer, productList);
      }

      @Override
      public void onRetrievedFailed(Product product, int remained) {
        System.out.println("[FAILED] Product: " + productId + ", current: " + remained);
      }
    }));
  }

  private List<Product> getProductList(Customer customer) {
    List<Product> productList = orderList.get(customer);
    return productList != null ? productList : new ArrayList<>();
  }

  public boolean createOrder(Customer customer, String productId, int stock) {
    preserveProduct(customer, productId, stock);
    return false;
  }

  public boolean executeOrder(Customer customer) {
    List<Product> order = orderList.get(customer);
    /* TODO:
     * output product name/quantity/money */
    final String customerName = customer.getId();
    Map<Product, Integer> productAmountMap = new HashMap<>();
    int totalPrice = 0;
    for (Product product : order) {
      Integer current = productAmountMap.get(product);
      int stock = current != null ? current : 0;
      productAmountMap.put(product, ++stock);
      totalPrice += product.getUnitPrice();
    }

    System.out.println("發票");
    System.out.println("customer: " + customerName);
    System.out.println("products:");
    productAmountMap.forEach(
        (product, integer) -> System.out.println(product + ", amount: " + integer));
    System.out.println("price: " + totalPrice);
    return !order.isEmpty();
  }
}
