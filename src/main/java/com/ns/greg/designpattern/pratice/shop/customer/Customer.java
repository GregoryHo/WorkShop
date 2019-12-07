package com.ns.greg.designpattern.pratice.shop.customer;

import com.ns.greg.designpattern.pratice.shop.shop.Shop;

/**
 * @author gregho
 * @since 2019/10/27
 */
public class Customer implements Buyer {

  private final String id;

  public String getId() {
    return id;
  }

  public Customer(String id) {
    this.id = id;
  }
}
