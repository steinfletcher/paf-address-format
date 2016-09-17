package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.common.Strings;

import java.util.List;

import static java.util.Arrays.asList;

class RuleException {
  private static final List<String> BUILDING_NAME_KEYWORDS = asList(
      "Back of",
      "Block",
      "Blocks",
      "Building",
      "Maisonette",
      "Maisonettes",
      "Rear Of",
      "Shop",
      "Shops",
      "Stall",
      "Stalls",
      "Suite",
      "Suites",
      "Unit",
      "Units"
  );

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

  static boolean containsKeyword(String buildingName) {
    if (buildingName != null) {
      for (String keyword : BUILDING_NAME_KEYWORDS) {
        if (buildingName.toUpperCase().contains(keyword.toUpperCase())) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Exception when a building has a name AND a number range, e.g. FLOWER HOUSE 189A.
   * This rule has an exception to the exception :(, where the building name is NOT split if
   * the numeric part is a number between 1-9999 (not '1-77' and not '7a')
   */
  static boolean isRule3SpecialException(String buildingName) {
    String[] parts = buildingName.split("\\s+");
    if (parts.length > 0) {
      String lastWord = parts[parts.length - 1];
      if (Strings.containsNumber(lastWord)) {
        if (Strings.isNumeric(lastWord)) {
          int number = Integer.parseInt(lastWord);
          return !(number > 0 && number < 10_000);
        }
        return true;
      }
    }
    return false;
  }

  static boolean isRuleException(String value) {
    return isFirstLastNumeric(value) ||
        isFirstAndPenultimateNumericLastAlpha(value) ||
        hasOneCharacter(value);
  }
}
