package com.ns.greg.designpattern.observer.weather;

import com.ns.greg.designpattern.observer.Bundle;

/**
 * @author gregho
 * @since 2019/10/27
 */
public class WeatherBundle extends Bundle<String, Double, Integer> {

  public WeatherBundle(String temp, Double arg2, Integer arg3) {
    super(temp, arg2, arg3);
  }

  public String getTemp() {
    return arg1;
  }

  public Double getH() {
    return arg2;
  }

  public float getP() {
    return arg3;
  }
}
