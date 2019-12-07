package com.ns.greg.designpattern.introductions.character;

import com.ns.greg.designpattern.introductions.actions.attack.AttackMode;
import com.ns.greg.designpattern.introductions.actions.fly.Flyable;

/**
 * @author gregho
 * @since 2019/10/18
 */
public abstract class Player {

  Flyable flyable;
  AttackMode attackMode;

  public void changeFlyable(Flyable flyable) {
    this.flyable = flyable;
  }

  public void attack() {
    attackMode.attack();
  }

  public void defense() {
    System.out.println("defense");
  }

  public void fly() {
    flyable.fly();
  }

  public abstract void display();
}
