package com.ns.greg.designpattern.introductions.character;

import com.ns.greg.designpattern.introductions.actions.attack.AttackMode;
import com.ns.greg.designpattern.introductions.actions.attack.DistantAttack;
import com.ns.greg.designpattern.introductions.actions.fly.ICanFly;

/**
 * @author gregho
 * @since 2019/10/18
 */
public class Mage extends Player {

  public Mage() {
    flyable = new ICanFly();
    attackMode = new DistantAttack();
  }

  @Override public void display() {
    System.out.println("has wood");
  }
}

