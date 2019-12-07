package com.ns.greg.designpattern.observer.weather;

import java.util.Observable;

/**
 * @author gregho
 * @since 2019/10/19
 */
public class ScreenDisplay extends Displayer{

  public ScreenDisplay(String title) {
    super(title);
  }
}
