package com.tapatron.pafaddressformat.common;

import java.util.List;

public class Lists {
  public static void addIfPresent(List<String> list, String element) {
    if (Strings.isPresent(element)) {
      list.add(element);
    }
  }
}
