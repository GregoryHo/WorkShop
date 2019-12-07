package com.ns.greg.designpattern.introductions.actions.attack;

/**
 * @author gregho
 * @since 2019/10/19
 */
public class MeleeAttack implements AttackMode {

  @Override public void attack() {
    System.out.println("short range attack.");
  }


}
