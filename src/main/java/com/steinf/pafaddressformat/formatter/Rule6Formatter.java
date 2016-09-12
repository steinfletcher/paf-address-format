package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;
import com.steinf.pafaddressformat.common.Lists;
import com.steinf.pafaddressformat.common.Strings;

import java.util.ArrayList;
import java.util.List;

class Rule6Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    if (Strings.isPresent(deliveryPoint.getOrganisation())) {
      parts.add(deliveryPoint.getOrganisation());
    }

    if (Strings.isPresent(deliveryPoint.getDepartment())) {
      parts.add(deliveryPoint.getDepartment());
    }

    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    if (RuleException.isRuleException(deliveryPoint.getSubBuildingName())) {
      parts.add(deliveryPoint.getSubBuildingName() + " " + deliveryPoint.getBuildingName());
      parts.add(deliveryPoint.getThroughfare());
    } else if (RuleException.isRuleException(deliveryPoint.getBuildingName())) {
      parts.add(deliveryPoint.getSubBuildingName());
      parts.add(deliveryPoint.getBuildingName() + " " + deliveryPoint.getThroughfare());
    } else {
      parts.add(deliveryPoint.getSubBuildingName());
      parts.add(deliveryPoint.getBuildingName());
      parts.add(deliveryPoint.getThroughfare());
    }

    Lists.addIfPresent(parts, deliveryPoint.getDependentThroughfare());
    Lists.addIfPresent(parts, deliveryPoint.getDoubleDependentLocality());
    Lists.addIfPresent(parts, deliveryPoint.getDependentLocality());

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }
}
