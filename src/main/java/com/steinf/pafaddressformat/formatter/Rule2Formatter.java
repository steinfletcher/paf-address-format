package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;

import java.util.ArrayList;
import java.util.List;

import static com.steinf.pafaddressformat.common.Lists.addIfPresent;

class Rule2Formatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    addIfPresent(parts, deliveryPoint.getOrganisation());
    addIfPresent(parts, deliveryPoint.getDepartment());

    addPoBox(parts, deliveryPoint.getPoBoxNumber());
    addBuildingNumberLine(parts, deliveryPoint, deliveryPoint.getBuildingNumber());

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }
}
