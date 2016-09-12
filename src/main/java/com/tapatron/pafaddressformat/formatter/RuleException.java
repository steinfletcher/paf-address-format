package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.common.Strings;

class RuleException {
  private static boolean isFirstLastNumeric(String value) {
    return Strings.isPresent(value) &&
           Character.isDigit(value.charAt(0)) &&
           Character.isDigit(value.charAt(value.length() - 1));
  }

  private static boolean isFirstAndPenultimateNumericLastAlpha(String value) {
    return Strings.isPresent(value) &&
        value.length() > 1 &&
        Character.isDigit(value.charAt(0)) &&
        Character.isDigit(value.charAt(value.length() - 2)) &&
        Character.isAlphabetic(value.charAt(value.length() - 1));
  }

  private static boolean hasOneCharacter(String value) {
    return Strings.isPresent(value) && value.length() == 1
        && Character.isAlphabetic(value.charAt(0));
  }

  static boolean isRuleException(String value) {
    return isFirstLastNumeric(value) || isFirstAndPenultimateNumericLastAlpha(value) || hasOneCharacter(value);
  }
}
