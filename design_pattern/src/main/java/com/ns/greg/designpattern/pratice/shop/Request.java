package com.ns.greg.designpattern.pratice.shop;

import com.ns.greg.designpattern.pratice.shop.shop.Shop;

/**
 * @author gregho
 * @since 2019/11/9
 */
public class Request {

  private final String id;
  private final int stock;
  private final Shop.ExecutionCallback callback;

  public Request(String id, int stock) {
    this(id, stock, null);
  }

  public Request(String id, int stock, Shop.ExecutionCallback callback) {
    this.id = id;
    this.stock = stock;
    this.callback = callback;
  }

  public String getId() {
    return id;
  }

  public int getStock() {
    return stock;
  }

  public Shop.ExecutionCallback getCallback() {
    return callback;
  }
}
