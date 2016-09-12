package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Rule7FormatterTest {
  @Test
  public void formatsTheDeliveryPointVersion1() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("2B")
        .withBuildingName("THE TOWER")
        .withBuildingNumber("27")
        .withThroughfare("JOHN STREET")
        .withPostTown("WINCHESTER")
        .withPostcode("SO23 9AP")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("2B THE TOWER");
    assertThat(parts.get(1)).isEqualTo("27 JOHN STREET");
    assertThat(parts.get(2)).isEqualTo("WINCHESTER");
    assertThat(parts.get(3)).isEqualTo("SO23 9AP");
  }

  @Test
  public void formatsTheDeliveryPointVersion2() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("BASEMENT FLAT")
        .withBuildingName("VICTORIA HOUSE")
        .withBuildingNumber("15")
        .withThroughfare("THE STREET")
        .withPostTown("CORYTON")
        .withPostcode("BP23 6AA")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("BASEMENT FLAT");
    assertThat(parts.get(1)).isEqualTo("VICTORIA HOUSE");
    assertThat(parts.get(2)).isEqualTo("15 THE STREET");
    assertThat(parts.get(3)).isEqualTo("CORYTON");
    assertThat(parts.get(4)).isEqualTo("BP23 6AA");
  }

  @Test
  public void handlesZeroInBuildingNumberField() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("FLAT 1")
        .withBuildingNumber("0")
        .withBuildingName("HOLLY HOUSE")
        .withThroughfare("OAK AVENUE")
        .withDependentLocality("BIDDENDEN")
        .withPostTown("ASHFORD")
        .withPostcode("TN27 8BT")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("FLAT 1");
    assertThat(parts.get(1)).isEqualTo("HOLLY HOUSE");
    assertThat(parts.get(2)).isEqualTo("OAK AVENUE");
    assertThat(parts.get(3)).isEqualTo("BIDDENDEN");
    assertThat(parts.get(4)).isEqualTo("ASHFORD");
    assertThat(parts.get(5)).isEqualTo("TN27 8BT");
  }
}