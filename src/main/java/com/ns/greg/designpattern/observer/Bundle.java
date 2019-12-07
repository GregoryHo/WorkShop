package com.ns.greg.designpattern.observer;

/**
 * @author gregho
 * @since 2019/10/27
 */
public abstract class Bundle<T1, T2, T3> {

  protected T1 arg1;
  protected T2 arg2;
  protected T3 arg3;

  public Bundle(T1 arg1, T2 arg2, T3 arg3) {
    this.arg1 = arg1;
    this.arg2 = arg2;
    this.arg3 = arg3;
  }
}
