package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;
import com.steinf.pafaddressformat.common.Strings;

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
    return new AllFieldsFormatter();
  }

  private static boolean isRule1(DeliveryPoint deliveryPoint) {
    return Strings.isNullOrEmpty(deliveryPoint.getSubBuildingName()) &&
        Strings.isNullOrEmpty(deliveryPoint.getBuildingName()) &&
        Strings.isNullOrEmpty(deliveryPoint.getBuildingNumber()) &&
        Strings.isPresent(deliveryPoint.getOrganisation());
  }

  private static boolean isRule2(DeliveryPoint deliveryPoint) {
    return Strings.isNullOrEmpty(deliveryPoint.getSubBuildingName()) &&
        Strings.isNullOrEmpty(deliveryPoint.getBuildingName()) &&
        Strings.isPresent(deliveryPoint.getBuildingNumber());
  }

  private static boolean isRule3(DeliveryPoint deliveryPoint) {
    return Strings.isNullOrEmpty(deliveryPoint.getSubBuildingName()) &&
        Strings.isPresent(deliveryPoint.getBuildingName()) &&
        Strings.isNullOrEmpty(deliveryPoint.getBuildingNumber());
  }

  private static boolean isRule4(DeliveryPoint deliveryPoint) {
    return Strings.isNullOrEmpty(deliveryPoint.getSubBuildingName()) &&
        Strings.isPresent(deliveryPoint.getBuildingName()) &&
        Strings.isPresent(deliveryPoint.getBuildingNumber());
  }

  private static boolean isRule5(DeliveryPoint deliveryPoint) {
    return Strings.isPresent(deliveryPoint.getSubBuildingName()) &&
        Strings.isNullOrEmpty(deliveryPoint.getBuildingName()) &&
        Strings.isPresent(deliveryPoint.getBuildingNumber());
  }

  private static boolean isRule6(DeliveryPoint deliveryPoint) {
    return Strings.isPresent(deliveryPoint.getSubBuildingName()) &&
        Strings.isPresent(deliveryPoint.getBuildingName()) &&
        Strings.isNullOrEmpty(deliveryPoint.getBuildingNumber());
  }

  private static boolean isRule7(DeliveryPoint deliveryPoint) {
    return Strings.isPresent(deliveryPoint.getSubBuildingName()) &&
        Strings.isPresent(deliveryPoint.getBuildingName()) &&
        Strings.isPresent(deliveryPoint.getBuildingNumber());
  }
}
