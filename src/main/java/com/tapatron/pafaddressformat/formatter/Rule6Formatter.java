package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import java.util.ArrayList;
import java.util.List;

import static com.tapatron.pafaddressformat.common.Lists.addIfPresent;
import static com.tapatron.pafaddressformat.common.Strings.isPresent;
import static com.tapatron.pafaddressformat.formatter.RuleException.isRuleException;

class Rule6Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    if (isPresent(deliveryPoint.getOrganisation())) {
      parts.add(deliveryPoint.getOrganisation());
    }

    if (isPresent(deliveryPoint.getDepartment())) {
      parts.add(deliveryPoint.getDepartment());
    }

    if (isPresent(deliveryPoint.getPoBoxNumber())) {
      parts.add("PO Box " + deliveryPoint.getPoBoxNumber());
    }

    if (isRuleException(deliveryPoint.getSubBuildingName())) {
      parts.add(deliveryPoint.getSubBuildingName() + " " + deliveryPoint.getBuildingName());
      parts.add(deliveryPoint.getThroughfare());
    } else if (isRuleException(deliveryPoint.getBuildingName())) {
      parts.add(deliveryPoint.getSubBuildingName());
      parts.add(deliveryPoint.getBuildingName() + " " + deliveryPoint.getThroughfare());
    } else {
      parts.add(deliveryPoint.getSubBuildingName());
      parts.add(deliveryPoint.getBuildingName());
      parts.add(deliveryPoint.getThroughfare());
    }

    addIfPresent(parts, deliveryPoint.getDependentThroughfare());
    addIfPresent(parts, deliveryPoint.getDoubleDependentLocality());
    addIfPresent(parts, deliveryPoint.getDependentLocality());

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }
}
