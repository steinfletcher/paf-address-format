package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Rule5FormatterTest {
  @Test
  public void formatsTheDeliveryPointBasic() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("FLAT 1")
        .withBuildingNumber("12")
        .withThroughfare("LIME TREE AVENUE")
        .withPostTown("BRISTOL")
        .withPostcode("BS8 4AB")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("FLAT 1");
    assertThat(parts.get(1)).isEqualTo("12 LIME TREE AVENUE");
    assertThat(parts.get(2)).isEqualTo("BRISTOL");
    assertThat(parts.get(3)).isEqualTo("BS8 4AB");
  }

  @Test
  public void formatsTheDeliveryPointSameLine() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("A")
        .withBuildingNumber("12")
        .withThroughfare("HIGH STREET NORTH")
        .withDependentLocality("COOMBE BISSETT")
        .withPostTown("SALISBURY")
        .withPostcode("SP5 4NA")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("12A HIGH STREET NORTH");
    assertThat(parts.get(1)).isEqualTo("COOMBE BISSETT");
    assertThat(parts.get(2)).isEqualTo("SALISBURY");
    assertThat(parts.get(3)).isEqualTo("SP5 4NA");
  }
}