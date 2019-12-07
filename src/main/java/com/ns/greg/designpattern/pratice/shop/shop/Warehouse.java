package com.ns.greg.designpattern.pratice.shop.shop;

import com.ns.greg.designpattern.observer.pattern.CustomObserver;
import com.ns.greg.designpattern.pratice.shop.Request;
import com.ns.greg.designpattern.pratice.shop.product.Product;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gregho
 * @since 2019/10/27
 */
public class Warehouse implements CustomObserver {

  private final List<Product> products;
  private final Map<Product, Integer> stockMap;

  public Warehouse() {
    this.products = new ArrayList<>();
    this.stockMap = new HashMap<>();
  }

  @Override public void update(Object arg) {
    if (arg == null) {
      /* throw some exception */
      throw new NullPointerException();
    }

    if (arg instanceof Product) {
      /* 決定初始商品列表 */
      processProduct((Product) arg);
    } else if (arg instanceof Request) {
      processRequest((Request) arg);
    }
  }

  public void displayProductList() {
    for (Product product : products) {
      System.out.println("=================================");
      System.out.println(product);
      System.out.println("stock:" + stockMap.get(product));
    }
  }

  private void processProduct(Product arg) {
    if (!products.contains(arg)) {
      products.add(arg);
      stockMap.put(arg, 0);
    }
  }

  private void processRequest(Request arg) {
    String id = arg.getId();
    int stock = arg.getStock();
    /* find product by id */
    Product product = findProduct(id);
    if (product != null) {
      Shop.ExecutionCallback callback = arg.getCallback();
      int current = getCurrentStock(product);
      int result = current + stock;
      if (result >= 0) {
        stockMap.put(product, result);
        if (callback != null) {
          callback.onRetrieved(product, result);
        }
      } else {
        if (callback != null) {
          callback.onRetrievedFailed(product, current);
        }
      }
    } else {
      throw new IllegalArgumentException();
    }
  }

  private Product findProduct(String id) {
    for (Product product : products) {
      if (product.getId().equals(id)) {
        return product;
      }
    }

    return null;
  }

  private int getCurrentStock(Product product) {
    Integer stock = stockMap.get(product);
    return stock != null ? stock : 0;
  }

  public Collection<? extends Product> getProducts() {
    return new ArrayList<>(products);
  }
}
