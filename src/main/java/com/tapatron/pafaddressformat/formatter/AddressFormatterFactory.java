package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import static com.tapatron.pafaddressformat.common.Strings.isNullOrEmpty;
import static com.tapatron.pafaddressformat.common.Strings.isPresent;

public class AddressFormatterFactory {

  public static AddressFormatter createFormatter(DeliveryPoint address) {
    if (isRule1(address)) {
      return new Rule1Formatter();
    } else if (isRule2(address)) {
      return new Rule2Formatter();
    } else if (isRule3(address)) {
      return new Rule3Formatter();
    } else if (isRule4(address)) {
      return new Rule4Formatter();
    } else if (isRule5(address)) {
      return new Rule5Formatter();
    } else if (isRule6(address)) {
      return new Rule6Formatter();
    } else if (isRule7(address)) {
      return new Rule7Formatter();
    }
    throw new IllegalArgumentException("Could not determine rule");
  }

  private static boolean isRule1(DeliveryPoint deliveryPoint) {
    return isNullOrEmpty(deliveryPoint.getSubBuildingName()) &&
        isNullOrEmpty(deliveryPoint.getBuildingName()) &&
        isNullOrEmpty(deliveryPoint.getBuildingNumber()) &&
        isPresent(deliveryPoint.getOrganisation());
  }

  private static boolean isRule2(DeliveryPoint deliveryPoint) {
    return isNullOrEmpty(deliveryPoint.getSubBuildingName()) &&
        isNullOrEmpty(deliveryPoint.getBuildingName()) &&
        isPresent(deliveryPoint.getBuildingNumber());
  }

  private static boolean isRule3(DeliveryPoint deliveryPoint) {
    return isNullOrEmpty(deliveryPoint.getSubBuildingName()) &&
        isPresent(deliveryPoint.getBuildingName()) &&
        isNullOrEmpty(deliveryPoint.getBuildingNumber());
  }

  private static boolean isRule4(DeliveryPoint deliveryPoint) {
    return isNullOrEmpty(deliveryPoint.getSubBuildingName()) &&
        isPresent(deliveryPoint.getBuildingName()) &&
        isPresent(deliveryPoint.getBuildingNumber());
  }

  private static boolean isRule5(DeliveryPoint deliveryPoint) {
    return isPresent(deliveryPoint.getSubBuildingName()) &&
        isNullOrEmpty(deliveryPoint.getBuildingName()) &&
        isPresent(deliveryPoint.getBuildingNumber());
  }

  private static boolean isRule6(DeliveryPoint deliveryPoint) {
    return isPresent(deliveryPoint.getSubBuildingName()) &&
        isPresent(deliveryPoint.getBuildingName()) &&
        isNullOrEmpty(deliveryPoint.getBuildingNumber());
  }

  private static boolean isRule7(DeliveryPoint deliveryPoint) {
    return isPresent(deliveryPoint.getSubBuildingName()) &&
        isPresent(deliveryPoint.getBuildingName()) &&
        isPresent(deliveryPoint.getBuildingNumber());
  }
}
