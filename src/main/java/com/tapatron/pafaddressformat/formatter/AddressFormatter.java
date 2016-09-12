package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import java.util.List;

public interface AddressFormatter {
  List<String> format(DeliveryPoint deliveryPoint);
}
