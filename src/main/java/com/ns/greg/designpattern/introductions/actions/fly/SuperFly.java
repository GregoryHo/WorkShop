package com.ns.greg.designpattern.introductions.actions.fly;

/**
 * @author gregho
 * @since 2019/10/19
 */
public class SuperFly implements Flyable {

  @Override public void fly() {
    System.out.println("Fly as dick.");
  }
}
