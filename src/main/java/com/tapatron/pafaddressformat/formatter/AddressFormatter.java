package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import java.util.List;

import static com.tapatron.pafaddressformat.common.Lists.addIfPresent;
import static com.tapatron.pafaddressformat.common.Strings.isPresent;

public interface AddressFormatter {
  List<String> format(DeliveryPoint deliveryPoint);

  default void addBuildingNumberLine(List<String> parts, DeliveryPoint deliveryPoint, String buildingNumber) {
    if (isPresent(deliveryPoint.getDependentThroughfare())) {
      parts.add(buildingNumber + " " + deliveryPoint.getDependentThroughfare());
      addIfPresent(parts, deliveryPoint.getThroughfare());
    } else if (isPresent(deliveryPoint.getThroughfare())) {
      parts.add(buildingNumber + " " + deliveryPoint.getThroughfare());
    } else {
      if (isPresent(deliveryPoint.getDoubleDependentLocality())) {
        parts.add(buildingNumber + " " + deliveryPoint.getDoubleDependentLocality());
        addIfPresent(parts, deliveryPoint.getDependentLocality());
      } else if (isPresent(deliveryPoint.getThroughfare())) {
        parts.add(buildingNumber + " " + deliveryPoint.getDependentLocality());
      } else {
        parts.add(buildingNumber);
      }
    }
  }

  default void addPoBox(List<String> parts, String poBoxNumber) {
    if (isPresent(poBoxNumber)) {
      parts.add("PO BOX " + poBoxNumber);
    }
  }
}
