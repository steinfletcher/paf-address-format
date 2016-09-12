package com.tapatron.pafaddressformat.formatter;

import com.tapatron.pafaddressformat.DeliveryPoint;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Rule3FormatterTest {
  @Test
  public void formatsTheDeliveryPointBasic() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withBuildingName("THE MANOR")
        .withThroughfare("UPPER HILL")
        .withPostTown("HORLEY")
        .withPostcode("RH6 0HP")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("THE MANOR");
    assertThat(parts.get(1)).isEqualTo("UPPER HILL");
    assertThat(parts.get(2)).isEqualTo("HORLEY");
    assertThat(parts.get(3)).isEqualTo("RH6 0HP");
  }

  @Test
  public void formatsTheDeliveryPointExtendedFields() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withOrganisation("JAMES VILLA HOLIDAYS")
        .withBuildingName("CENTRE 30")
        .withThroughfare("ST. LAURENCE AVENUE")
        .withPostTown("GRAFTON")
        .withPostcode("ME16 0LP")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("JAMES VILLA HOLIDAYS");
    assertThat(parts.get(1)).isEqualTo("CENTRE 30");
    assertThat(parts.get(2)).isEqualTo("ST. LAURENCE AVENUE");
    assertThat(parts.get(3)).isEqualTo("GRAFTON");
    assertThat(parts.get(4)).isEqualTo("ME16 0LP");
  }

  @Test
  public void formatsTheDeliveryPointWithRuleException() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withBuildingName("1A")
        .withDependentThroughfare("SEASTONE COURT")
        .withThroughfare("STATION ROAD")
        .withPostTown("HOLT")
        .withPostcode("NR25 7HG")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("1A SEASTONE COURT");
    assertThat(parts.get(1)).isEqualTo("STATION ROAD");
    assertThat(parts.get(2)).isEqualTo("HOLT");
    assertThat(parts.get(3)).isEqualTo("NR25 7HG");
  }

  @Test
  public void formatsTheDeliveryPointWithOrganisation() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withOrganisation("S D ALCOTT FLORISTS")
        .withBuildingName("FLOWER HOUSE 189A")
        .withThroughfare("PYE GREEN ROAD")
        .withPostTown("CANNOCK")
        .withPostcode("WS11 5SB")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("S D ALCOTT FLORISTS");
    assertThat(parts.get(1)).isEqualTo("FLOWER HOUSE");
    assertThat(parts.get(2)).isEqualTo("189A PYE GREEN ROAD");
    assertThat(parts.get(3)).isEqualTo("CANNOCK");
    assertThat(parts.get(4)).isEqualTo("WS11 5SB");
  }
}