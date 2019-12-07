package com.ns.greg.designpattern.pratice.shop.product;

/**
 * @author gregho
 * @since 2019/10/27
 */
public class Product {

  private final String id;
  private final String name;
  private int unitPrice;

  public Product(String id, String name, int unitPrice) {
    this.id = id;
    this.name = name;
    this.unitPrice = unitPrice;
  }

  @Override public String toString() {
    return "Product{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", unitPrice=" + unitPrice +
        '}';
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getUnitPrice() {
    return unitPrice;
  }
}
