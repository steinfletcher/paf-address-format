package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import java.util.ArrayList;
import java.util.List;

import static com.tapatron.pafaddressformat.common.Lists.addIfPresent;
import static com.tapatron.pafaddressformat.formatter.RuleException.isRuleException;

class Rule7Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    addIfPresent(parts, deliveryPoint.getOrganisation());
    addIfPresent(parts, deliveryPoint.getDepartment());
    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    if (isRuleException(deliveryPoint.getSubBuildingName())) {
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
