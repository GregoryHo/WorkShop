package com.ns.greg.designpattern.pratice.shop;

import com.ns.greg.designpattern.pratice.shop.customer.Customer;
import com.ns.greg.designpattern.pratice.shop.product.Product;
import com.ns.greg.designpattern.pratice.shop.shop.SevenEleven;
import com.ns.greg.designpattern.pratice.shop.shop.Shop;
import com.ns.greg.designpattern.pratice.shop.shop.Warehouse;
import org.jetbrains.annotations.NotNull;

/**
 * @author gregho
 * @since 2019/10/27
 */
public class GoodStuffMarket {

  private static final String MILK_001 = "Milk-001";
  private static final String MILK_002 = "Milk-002";

  public static void main(String[] args) {
    Shop shop = createShop();
    openShop(shop);
  }

  @NotNull private static Shop createShop() {
    Warehouse warehouse = new Warehouse();
    Shop shop = new SevenEleven();
    shop.addObserver(warehouse);
    /* product list */
    defaultProducts(shop);
    /* restock */
    restockProducts(shop);
    warehouse.displayProductList();
    return shop;
  }

  private static void openShop(Shop shop) {
    Customer customer = new Customer("Greg");
    // shop, customer
    /* 可不可以下單 */
    shop.createOrder(customer, MILK_001, 2);
    shop.createOrder(customer, MILK_002, 10);
    System.out.println("購買結果:" + shop.executeOrder(customer));
    /*List<String> orders =  customer.order();*/
  }

  private static void defaultProducts(Shop shop) {
    shop.addNewProduct(new Product(MILK_001, "統一巧克力牛奶", 85));
    shop.addNewProduct(new Product(MILK_002, "林鳳營低脂牛奶", 115));
  }

  private static void restockProducts(Shop shop) {
    shop.restockProduct(MILK_001, 20);
    shop.restockProduct(MILK_002, 20);
  }
}
