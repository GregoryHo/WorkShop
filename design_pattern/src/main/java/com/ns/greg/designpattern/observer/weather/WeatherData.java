package com.ns.greg.designpattern.observer.weather;

import com.ns.greg.designpattern.observer.pattern.CustomObservable;
import com.ns.greg.designpattern.observer.pattern.CustomObserver;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gregho
 * @since 2019/10/19
 */
public class WeatherData implements CustomObservable {

  private List<CustomObserver> customObserverList = new ArrayList<>();
  private float temperature;
  private float humidity;
  private float pressure;

//swallow copy
  public void measurementsChanged() {
    temperature = generateTemperature();
    humidity = generateHumidity();
    pressure = generatePressure();
    notifier();
  }

  private float generateTemperature() {
    return (float) (Math.random() * 15) + 15;
  }

  private float generateHumidity() {
    return (float) Math.random();
  }

  private float generatePressure() {
    return (float) (Math.random() * 100) + 800;
  }

  @Override public void notifier() {
    notifier(new WeatherBundle(Float.toString(temperature),
        (double) humidity,
        (int) pressure));
  }

  @Override public void notifier(Object arg) {
    customObserverList.forEach(observer -> observer.update(arg));

  }

  @Override public void addObserver(CustomObserver customObserver) {
    customObserverList.add(customObserver);
  }

  @Override public void deleteObserver(CustomObserver customObserver) {
    customObserverList.remove(customObserver);
  }
}
