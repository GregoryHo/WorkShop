package com.ns.greg.designpattern.introductions;

import com.ns.greg.designpattern.introductions.actions.fly.SuperFly;
import com.ns.greg.designpattern.introductions.character.Knight;
import com.ns.greg.designpattern.introductions.character.Mage;
import com.ns.greg.designpattern.introductions.character.Player;
import com.ns.greg.designpattern.introductions.character.SwordMan;

/**
 * @author gregho
 * @since 2019/10/19
 */
class Game {

  public static void main(String[] args) {
    Mage mage = new Mage();
    log(mage);
    SwordMan swordMan = new SwordMan();
    log(swordMan);
    Knight knight = new Knight();
    log(knight);
  }

  private static void log(Player player) {
    System.out.println("==============================");
    System.out.println(player.getClass().getSimpleName());
    player.attack();
    player.defense();
    player.display();
    player.fly();
  }
}
