package com.tapatron.pafaddressformat.common;

import java.util.List;

import static com.tapatron.pafaddressformat.common.Strings.isPresent;

public class Lists {
  public static void addIfPresent(List<String> list, String element) {
    if (isPresent(element)) {
      list.add(element);
    }
  }
}
