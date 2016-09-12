package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import java.util.ArrayList;
import java.util.List;

import static com.tapatron.pafaddressformat.common.Lists.addIfPresent;
import static com.tapatron.pafaddressformat.common.Strings.isPresent;

/**
 * We couldn't determine the rule so just serialise all present fields
 */
public class AllFieldsFormatter implements AddressFormatter {
  @Override
  public List<String> format(DeliveryPoint deliveryPoint) {
    List<String> parts = new ArrayList<>();

    addIfPresent(parts, deliveryPoint.getOrganisation());
    addIfPresent(parts, deliveryPoint.getDepartment());
    addIfPresent(parts, deliveryPoint.getBuildingName());
    addIfPresent(parts, deliveryPoint.getSubBuildingName());
    addPoBox(parts, deliveryPoint.getPoBoxNumber());

    if (isPresent(deliveryPoint.getBuildingNumber())) {
      addBuildingNumberLine(parts, deliveryPoint, deliveryPoint.getBuildingNumber());
    } else {
      addIfPresent(parts, deliveryPoint.getDependentThroughfare());
      addIfPresent(parts, deliveryPoint.getThroughfare());
      addIfPresent(parts, deliveryPoint.getDoubleDependentLocality());
      addIfPresent(parts, deliveryPoint.getDependentLocality());
    }

    parts.add(deliveryPoint.getPostTown());
    parts.add(deliveryPoint.getPostcode());

    return parts;
  }
}
