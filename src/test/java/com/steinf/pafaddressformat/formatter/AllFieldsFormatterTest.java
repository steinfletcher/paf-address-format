package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AllFieldsFormatterTest {
  @Test
  public void formatsAPoBoxOnlyAddress() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withPoBoxNumber("61")
        .withPostTown("FAREHAM")
        .withPostcode("PO14 1UX")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("PO BOX 61");
    assertThat(parts.get(1)).isEqualTo("FAREHAM");
    assertThat(parts.get(2)).isEqualTo("PO14 1UX");
  }
}
