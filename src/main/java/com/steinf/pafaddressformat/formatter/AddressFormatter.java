package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;
import com.steinf.pafaddressformat.common.Lists;
import com.steinf.pafaddressformat.common.Strings;

import java.util.List;

public interface AddressFormatter {
  List<String> format(DeliveryPoint deliveryPoint);

  default void addBuildingNumberLine(List<String> parts, DeliveryPoint deliveryPoint, String buildingNumber) {
    if (Strings.isPresent(deliveryPoint.getDependentThroughfare())) {
      parts.add(buildingNumber + " " + deliveryPoint.getDependentThroughfare());
      Lists.addIfPresent(parts, deliveryPoint.getThroughfare());
    } else if (Strings.isPresent(deliveryPoint.getThroughfare())) {
      parts.add(buildingNumber + " " + deliveryPoint.getThroughfare());
    } else {
      if (Strings.isPresent(deliveryPoint.getDoubleDependentLocality())) {
        parts.add(buildingNumber + " " + deliveryPoint.getDoubleDependentLocality());
        Lists.addIfPresent(parts, deliveryPoint.getDependentLocality());
      } else if (Strings.isPresent(deliveryPoint.getThroughfare())) {
        parts.add(buildingNumber + " " + deliveryPoint.getDependentLocality());
      } else {
        parts.add(buildingNumber);
      }
    }
  }

  default void addPoBox(List<String> parts, String poBoxNumber) {
    if (Strings.isPresent(poBoxNumber)) {
      parts.add("PO BOX " + poBoxNumber);
    }
  }
}
