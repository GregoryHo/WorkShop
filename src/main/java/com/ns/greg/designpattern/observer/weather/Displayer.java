package com.ns.greg.designpattern.observer.weather;

import com.ns.greg.designpattern.observer.Bundle;
import com.ns.greg.designpattern.observer.pattern.CustomObservable;
import com.ns.greg.designpattern.observer.pattern.CustomObserver;

/**
 * @author gregho
 * @since 2019/10/19
 */
public class Displayer implements CustomObserver {

  String title;

  public Displayer(String title) {
    this.title = title;
  }

  @Override public int hashCode() {
    return title.hashCode();
  }

  @Override public boolean equals(Object obj) {
    if (obj instanceof String) {
      return obj.equals(title);
    }

    return super.equals(obj);
  }

  /*public void displayData(float t, float h, float p) {
    System.out.println(title + " t = " + t + ", h = " + h + ", p = " + p);
    }*/

  @Override public void update(Object arg) {
    WeatherBundle bundle = (WeatherBundle) arg;
    System.out.println(title
        + " t = "
        + bundle.getTemp()
        + ", h = "
        + bundle.getH()
        + ", p = "
        + bundle.getP());
  }
}
