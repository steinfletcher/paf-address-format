package com.steinf.pafaddressformat.common;

import java.util.List;

import static com.steinf.pafaddressformat.common.Strings.isPresent;

public class Lists {
  public static void addIfPresent(List<String> list, String element) {
    if (isPresent(element)) {
      list.add(element);
    }
  }
}
