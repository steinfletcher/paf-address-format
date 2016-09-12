package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;

import java.util.ArrayList;
import java.util.List;

import static com.steinf.pafaddressformat.common.Lists.addIfPresent;

class Rule1Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    addIfPresent(parts, deliveryPoint.getOrganisation());
    addIfPresent(parts, deliveryPoint.getDepartment());

    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    addIfPresent(parts, deliveryPoint.getDependentThroughfare());
    addIfPresent(parts, deliveryPoint.getThroughfare());
    addIfPresent(parts, deliveryPoint.getDoubleDependentLocality());
    addIfPresent(parts, deliveryPoint.getDependentLocality());

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }
}
