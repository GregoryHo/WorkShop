package com.ns.greg.designpattern.observer.pattern;

/**
 * @author gregho
 * @since 2019/10/27
 */
public interface CustomObservable {

  void notifier();

  void notifier(Object arg);

  void addObserver(CustomObserver customObserver);

  void deleteObserver(CustomObserver customObserver);
}
