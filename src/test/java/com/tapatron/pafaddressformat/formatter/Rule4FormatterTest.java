package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Rule4FormatterTest {
  @Test
  public void formatsTheDeliveryPointBasic() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withBuildingName("VICTORIA HOUSE")
        .withBuildingNumber("15")
        .withThroughfare("THE STREET")
        .withPostTown("CHRISTCHURCH")
        .withPostcode("BH23 6AA")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("VICTORIA HOUSE");
    assertThat(parts.get(1)).isEqualTo("15 THE STREET");
    assertThat(parts.get(2)).isEqualTo("CHRISTCHURCH");
    assertThat(parts.get(3)).isEqualTo("BH23 6AA");
  }
}