package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Rule1FormatterTest {
  @Test
  public void formatsTheDeliveryPointBasic() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withOrganisation("LEDA ENGINEERING LTD")
        .withDependentLocality("APPLEFORD")
        .withPostTown("ABINGDON")
        .withPostcode("OX14 4PG")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("LEDA ENGINEERING LTD");
    assertThat(parts.get(1)).isEqualTo("APPLEFORD");
    assertThat(parts.get(2)).isEqualTo("ABINGDON");
    assertThat(parts.get(3)).isEqualTo("OX14 4PG");
  }

  @Test
  public void formatsTheDeliveryPointAllFields() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withOrganisation("WALSGRAVE HOSPITAL")
        .withDepartment("A&E")
        .withPoBoxNumber("1873")
        .withDependentThroughfare("CHESHUNT COURT")
        .withThroughfare("CYPRESS STREET")
        .withDoubleDependentLocality("TYRE INDUSTRIAL ESTATE")
        .withDependentLocality("BLANTYRE")
        .withPostTown("COVENTRY")
        .withPostcode("CV2 2DH")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("WALSGRAVE HOSPITAL");
    assertThat(parts.get(1)).isEqualTo("A&E");
    assertThat(parts.get(2)).isEqualTo("PO BOX 1873");
    assertThat(parts.get(3)).isEqualTo("CHESHUNT COURT");
    assertThat(parts.get(4)).isEqualTo("CYPRESS STREET");
    assertThat(parts.get(5)).isEqualTo("TYRE INDUSTRIAL ESTATE");
    assertThat(parts.get(6)).isEqualTo("BLANTYRE");
    assertThat(parts.get(7)).isEqualTo("COVENTRY");
    assertThat(parts.get(8)).isEqualTo("CV2 2DH");
  }

  @Test
  public void extractsTheFormattedParts() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withOrganisation("LEDA ENGINEERING LTD")
        .withDependentLocality("APPLEFORD")
        .withPostTown("ABINGDON")
        .withPostcode("OX14 4PG")
        .build();

    String formatted = deliveryPoint.toString();

    assertThat(formatted).isEqualTo(
        "LEDA ENGINEERING LTD\n" +
        "APPLEFORD\n" +
        "ABINGDON\n" +
        "OX14 4PG"
    );
  }
}
