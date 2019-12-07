package com.ns.greg.designpattern.introductions.character;

import com.ns.greg.designpattern.introductions.actions.attack.MeleeAttack;
import com.ns.greg.designpattern.introductions.actions.fly.CantFly;

/**
 * @author gregho
 * @since 2019/10/18
 */
public class SwordMan extends Player {

  public SwordMan() {
    attackMode = new MeleeAttack();
    flyable = new CantFly();
  }

  @Override public void display() {
    System.out.println("has sword");
  }
}
