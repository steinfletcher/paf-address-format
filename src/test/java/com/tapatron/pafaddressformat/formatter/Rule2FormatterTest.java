package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Rule2FormatterTest {
  @Test
  public void formatsTheDeliveryPointBasic() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withBuildingNumber("1")
        .withThroughfare("ACACIA AVENUE")
        .withPostTown("ABINGDON")
        .withPostcode("OX14 4PG")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("1 ACACIA AVENUE");
    assertThat(parts.get(1)).isEqualTo("ABINGDON");
    assertThat(parts.get(2)).isEqualTo("OX14 4PG");
  }
}
