package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;
import com.steinf.pafaddressformat.common.Lists;

import java.util.ArrayList;
import java.util.List;

class Rule7Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    Lists.addIfPresent(parts, deliveryPoint.getOrganisation());
    Lists.addIfPresent(parts, deliveryPoint.getDepartment());
    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    if (RuleException.isRuleException(deliveryPoint.getSubBuildingName())) {
      parts.add(deliveryPoint.getSubBuildingName() + " " + deliveryPoint.getBuildingName());
    } else {
      parts.add(deliveryPoint.getSubBuildingName());
      parts.add(deliveryPoint.getBuildingName());
    }

    addBuildingNumberLine(parts, deliveryPoint, deliveryPoint.getBuildingNumber());

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }
}
