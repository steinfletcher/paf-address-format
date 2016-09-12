package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Rule6FormatterTest {
  @Test
  public void formatsTheDeliveryPointBasic() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("10B")
        .withBuildingName("BARRY JACKSON TOWER")
        .withThroughfare("ESTONE WALK")
        .withPostTown("BIRMINGHAM")
        .withPostcode("B6 5BA")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("10B BARRY JACKSON TOWER");
    assertThat(parts.get(1)).isEqualTo("ESTONE WALK");
    assertThat(parts.get(2)).isEqualTo("BIRMINGHAM");
    assertThat(parts.get(3)).isEqualTo("B6 5BA");
  }

  @Test
  public void formatsTheDeliveryPointSameLine() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("CARETAKERS FLAT")
        .withBuildingName("110-114")
        .withThroughfare("HIGH STREET WEST")
        .withPostTown("BRISTOL")
        .withPostcode("BS1 2AW")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("CARETAKERS FLAT");
    assertThat(parts.get(1)).isEqualTo("110-114 HIGH STREET WEST");
    assertThat(parts.get(2)).isEqualTo("BRISTOL");
    assertThat(parts.get(3)).isEqualTo("BS1 2AW");
  }

  @Test
  public void formatsTheDeliveryPoint() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("STABLES FLAT")
        .withBuildingName("THE MANOR")
        .withThroughfare("UPPER HILL")
        .withPostTown("HORLEY")
        .withPostcode("RH6 0HP")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("STABLES FLAT");
    assertThat(parts.get(1)).isEqualTo("THE MANOR");
    assertThat(parts.get(2)).isEqualTo("UPPER HILL");
    assertThat(parts.get(3)).isEqualTo("HORLEY");
    assertThat(parts.get(4)).isEqualTo("RH6 0HP");
  }
}