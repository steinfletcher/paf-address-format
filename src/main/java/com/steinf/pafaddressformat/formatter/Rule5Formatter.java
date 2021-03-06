package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;

import java.util.ArrayList;
import java.util.List;

import static com.steinf.pafaddressformat.common.Lists.addIfPresent;

class Rule5Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    addIfPresent(parts, deliveryPoint.getOrganisation());
    addIfPresent(parts, deliveryPoint.getDepartment());
    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    if (deliveryPoint.getSubBuildingName().length() == 1) {
      parts.add(deliveryPoint.getBuildingNumber() + deliveryPoint.getSubBuildingName() + " " +
          deliveryPoint.getThroughfare());
    } else {
      parts.add(deliveryPoint.getSubBuildingName());
      parts.add(deliveryPoint.getBuildingNumber() + " " + deliveryPoint.getThroughfare());
    }

    addIfPresent(parts, deliveryPoint.getDependentThroughfare());
    addIfPresent(parts, deliveryPoint.getDoubleDependentLocality());
    addIfPresent(parts, deliveryPoint.getDependentLocality());

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }
}
