package com.tapatron.pafaddressformat.common;

public class Strings {
  public static boolean isPresent(String value) {
    return value != null && !value.isEmpty();
  }

  public static boolean isNullOrEmpty(String value) {
    return value == null || value.isEmpty();
  }

  private Strings() {
    throw new UnsupportedOperationException("Do not instantiate");
  }
}
