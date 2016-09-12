package com.tapatron.pafaddressformat.common;

public class Strings {
  public static boolean isPresent(String value) {
    return value != null && !value.isEmpty();
  }

  public static boolean isNullOrEmpty(String value) {
    return value == null || value.isEmpty();
  }

  public static boolean isNumeric(String value) {
    for (char c : value.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

  public static boolean containsNumber(String value) {
    for (char c : value.toCharArray()) {
      if (Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }

  private Strings() {
    throw new UnsupportedOperationException("Do not instantiate");
  }
}
