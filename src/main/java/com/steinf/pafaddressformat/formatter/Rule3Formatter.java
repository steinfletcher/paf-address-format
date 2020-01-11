package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;
import com.steinf.pafaddressformat.common.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.steinf.pafaddressformat.common.Lists.addIfPresent;
import static java.util.stream.Collectors.joining;

class Rule3Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    addIfPresent(parts, deliveryPoint.getOrganisation());
    addIfPresent(parts, deliveryPoint.getDepartment());
    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    if (RuleException.containsKeyword(deliveryPoint.getBuildingName())) {
      parts.add(deliveryPoint.getBuildingName());
      addIfPresent(parts, deliveryPoint.getDependentThroughfare());
      addIfPresent(parts, deliveryPoint.getThroughfare());
    } else if (RuleException.isRuleException(deliveryPoint.getBuildingName())) {
      if (Strings.isPresent(deliveryPoint.getDependentThroughfare())) {
        parts.add(deliveryPoint.getBuildingName() + " " + deliveryPoint.getDependentThroughfare());
        addIfPresent(parts, deliveryPoint.getThroughfare());
      } else {
        parts.add(deliveryPoint.getBuildingName() + " " + deliveryPoint.getThroughfare());
      }
    } else {
      if (RuleException.isBuildingNameSpecialException(deliveryPoint.getBuildingName())) {
        String[] tokens = deliveryPoint.getBuildingName().split("\\s+");
        String namePart = Arrays.stream(Arrays.copyOf(tokens, tokens.length - 1)).collect(joining(" "));
        String numberPart = tokens[tokens.length - 1];
        parts.add(namePart);
        addBuildingNumberLine(parts, deliveryPoint, numberPart);
      } else {
        parts.add(deliveryPoint.getBuildingName());
        addIfPresent(parts, deliveryPoint.getDependentThroughfare());
        addIfPresent(parts, deliveryPoint.getThroughfare());
      }
    }

    addIfPresent(parts, deliveryPoint.getDoubleDependentLocality());
    addIfPresent(parts, deliveryPoint.getDependentLocality());

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }

}
