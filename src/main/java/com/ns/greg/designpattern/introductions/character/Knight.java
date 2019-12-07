package com.ns.greg.designpattern.introductions.character;


import com.ns.greg.designpattern.introductions.actions.attack.MeleeAttack;
import com.ns.greg.designpattern.introductions.actions.fly.CantFly;

/**
 * @author gregho
 * @since 2019/10/19
 */
public class Knight extends Player {

  public Knight() {
    attackMode = new MeleeAttack();
    flyable = new CantFly();
  }

  @Override public void display() {
    System.out.println("Ride on horse.");
  }
}
