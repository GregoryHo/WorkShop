package com.ns.greg.designpattern.observer;

import com.ns.greg.designpattern.observer.weather.BoardDisplay;
import com.ns.greg.designpattern.observer.weather.Displayer;
import com.ns.greg.designpattern.observer.weather.ScreenDisplay;
import com.ns.greg.designpattern.observer.weather.TvDisplay;
import com.ns.greg.designpattern.observer.weather.WeatherData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gregho
 * @since 2019/10/19
 */
class WeatherStation {

  public static void main(String[] args) {
    TvDisplay tvDisplay = new TvDisplay("TV: ");
    // Weather data
    // 會被外部的某個程式通知溫濕度改變
    // 顯示在某個display
    //List<Displayer> displayers = getDisplayerList();
    WeatherData weatherData = new WeatherData();
    weatherData.addObserver(tvDisplay);
    weatherData.measurementsChanged();
    weatherData.addObserver(tvDisplay);
    weatherData.measurementsChanged();
  }

  private static List<Displayer> getDisplayerList() {
    Displayer screenDisplay = new ScreenDisplay("sd: ");
    Displayer screenDisplay2 = new ScreenDisplay("sd 2: ");
    Displayer boardDisplay = new BoardDisplay("bd: ");
    List<Displayer> list = new ArrayList<>();
    list.add(screenDisplay);
    list.add(screenDisplay2);
    list.add(boardDisplay);
    return list;
  }
}
