package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.tapatron.pafaddressformat.common.Lists.addIfPresent;
import static com.tapatron.pafaddressformat.common.Strings.isPresent;
import static com.tapatron.pafaddressformat.formatter.RuleException.isRule3SpecialException;
import static com.tapatron.pafaddressformat.formatter.RuleException.isRuleException;
import static java.util.stream.Collectors.joining;

class Rule3Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    addIfPresent(parts, deliveryPoint.getOrganisation());
    addIfPresent(parts, deliveryPoint.getDepartment());
    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    if (isRuleException(deliveryPoint.getBuildingName())) {
      if (isPresent(deliveryPoint.getDependentThroughfare())) {
        parts.add(deliveryPoint.getBuildingName() + " " + deliveryPoint.getDependentThroughfare());
        addIfPresent(parts, deliveryPoint.getThroughfare());
      } else {
        parts.add(deliveryPoint.getBuildingName() + " " + deliveryPoint.getThroughfare());
      }
    } else {
      if (isRule3SpecialException(deliveryPoint.getBuildingName())) {
        String[] tokens = deliveryPoint.getBuildingName().split("\\W+");
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
