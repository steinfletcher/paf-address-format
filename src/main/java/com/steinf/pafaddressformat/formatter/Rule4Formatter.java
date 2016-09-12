package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;
import com.steinf.pafaddressformat.common.Lists;

import java.util.ArrayList;
import java.util.List;

class Rule4Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    Lists.addIfPresent(parts, deliveryPoint.getOrganisation());
    Lists.addIfPresent(parts, deliveryPoint.getDepartment());
    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    parts.add(deliveryPoint.getBuildingName());
    parts.add(deliveryPoint.getBuildingNumber() + " " + deliveryPoint.getThroughfare());

    Lists.addIfPresent(parts, deliveryPoint.getDependentThroughfare());
    Lists.addIfPresent(parts, deliveryPoint.getDoubleDependentLocality());
    Lists.addIfPresent(parts, deliveryPoint.getDependentLocality());

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }
}
