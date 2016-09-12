package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;
import com.steinf.pafaddressformat.common.Lists;
import com.steinf.pafaddressformat.common.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

class Rule3Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    Lists.addIfPresent(parts, deliveryPoint.getOrganisation());
    Lists.addIfPresent(parts, deliveryPoint.getDepartment());
    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    if (RuleException.isRuleException(deliveryPoint.getBuildingName())) {
      if (Strings.isPresent(deliveryPoint.getDependentThroughfare())) {
        parts.add(deliveryPoint.getBuildingName() + " " + deliveryPoint.getDependentThroughfare());
        Lists.addIfPresent(parts, deliveryPoint.getThroughfare());
      } else {
        parts.add(deliveryPoint.getBuildingName() + " " + deliveryPoint.getThroughfare());
      }
    } else {
      if (RuleException.isRule3SpecialException(deliveryPoint.getBuildingName())) {
        String[] tokens = deliveryPoint.getBuildingName().split("\\W+");
        String namePart = Arrays.stream(Arrays.copyOf(tokens, tokens.length - 1)).collect(joining(" "));
        String numberPart = tokens[tokens.length - 1];
        parts.add(namePart);
        addBuildingNumberLine(parts, deliveryPoint, numberPart);
      } else {
        parts.add(deliveryPoint.getBuildingName());
        Lists.addIfPresent(parts, deliveryPoint.getDependentThroughfare());
        Lists.addIfPresent(parts, deliveryPoint.getThroughfare());
      }
    }

    Lists.addIfPresent(parts, deliveryPoint.getDoubleDependentLocality());
    Lists.addIfPresent(parts, deliveryPoint.getDependentLocality());

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }

}
