package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Rule2FormatterTest {
  @Test
  public void formatsTheDeliveryPointVersion1() throws Exception {
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

  @Test
  public void formatsTheDeliveryPointBasicVersion2() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withBuildingNumber("16")
        .withThroughfare("VIXEN ROAD")
        .withPostTown("BRADDOCK")
        .withPostcode("KT6 5BT")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("16 VIXEN ROAD");
    assertThat(parts.get(1)).isEqualTo("BRADDOCK");
    assertThat(parts.get(2)).isEqualTo("KT6 5BT");
  }
}
