package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;
import com.steinf.pafaddressformat.common.Lists;
import com.steinf.pafaddressformat.common.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * We couldn't determine the rule so just serialise all present fields
 */
public class AllFieldsFormatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    Lists.addIfPresent(parts, deliveryPoint.getOrganisation());
    Lists.addIfPresent(parts, deliveryPoint.getDepartment());
    Lists.addIfPresent(parts, deliveryPoint.getBuildingName());
    Lists.addIfPresent(parts, deliveryPoint.getSubBuildingName());
    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    if (Strings.isPresent(deliveryPoint.getBuildingNumber())) {
      addBuildingNumberLine(parts, deliveryPoint, deliveryPoint.getBuildingNumber());
    } else {
      Lists.addIfPresent(parts, deliveryPoint.getDependentThroughfare());
      Lists.addIfPresent(parts, deliveryPoint.getThroughfare());
      Lists.addIfPresent(parts, deliveryPoint.getDoubleDependentLocality());
      Lists.addIfPresent(parts, deliveryPoint.getDependentLocality());
    }

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }
}
