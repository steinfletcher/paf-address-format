package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;

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

  @Test
  public void formatsTheDeliveryPointWithRange() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withOrganisation("THE TAMBOURINE WAREHOUSE")
        .withBuildingName("UNIT 1-3")
        .withDependentThroughfare("INDUSTRIAL ESTATE")
        .withThroughfare("TAME ROAD")
        .withPostTown("LONDON")
        .withPostcode("E6 7HS")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("THE TAMBOURINE WAREHOUSE");
    assertThat(parts.get(1)).isEqualTo("UNIT 1-3");
    assertThat(parts.get(2)).isEqualTo("INDUSTRIAL ESTATE");
    assertThat(parts.get(3)).isEqualTo("TAME ROAD");
    assertThat(parts.get(4)).isEqualTo("LONDON");
    assertThat(parts.get(5)).isEqualTo("E6 7HS");
  }

  @Test
  public void formatsTheDeliveryPointWithStall() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withOrganisation("QUIRKY CANDLES LTD")
        .withBuildingName("STALL 4-5")
        .withThroughfare("MARKET SQUARE")
        .withPostTown("LIVERPOOL")
        .withPostcode("L8 1LH")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("QUIRKY CANDLES LTD");
    assertThat(parts.get(1)).isEqualTo("STALL 4-5");
    assertThat(parts.get(2)).isEqualTo("MARKET SQUARE");
    assertThat(parts.get(3)).isEqualTo("LIVERPOOL");
    assertThat(parts.get(4)).isEqualTo("L8 1LH");
  }

  @Test
  public void formatsTheDeliveryPointWithNumberRange() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
            .withOrganisation("AQA EDUCATIONS")
            .withBuildingName("LYNTON HOUSE 7-12")
            .withThroughfare("TAVISTOCK SQUARE")
            .withPostTown("LONDON")
            .withPostcode("WC1H 9LT")
            .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("AQA EDUCATIONS");
    assertThat(parts.get(1)).isEqualTo("LYNTON HOUSE");
    assertThat(parts.get(2)).isEqualTo("7-12 TAVISTOCK SQUARE");
    assertThat(parts.get(3)).isEqualTo("LONDON");
    assertThat(parts.get(4)).isEqualTo("WC1H 9LT");
  }

  @Test
  public void formatsTheDeliveryPointWithRule3SpecialException() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
            .withBuildingName("KIOSK 4")
            .withThroughfare("BRUNSWICK CENTRE")
            .withPostTown("LONDON")
            .withPostcode("WC1N 1AE")
            .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("KIOSK 4");
    assertThat(parts.get(1)).isEqualTo("BRUNSWICK CENTRE");
    assertThat(parts.get(2)).isEqualTo("LONDON");
    assertThat(parts.get(3)).isEqualTo("WC1N 1AE");
  }

  @Test
  public void formatsTheDeliveryPointWithRearOf() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withOrganisation("FIONA'S FLOWERS")
        .withBuildingName("REAR OF 5A")
        .withThroughfare("HIGH STREET")
        .withPostTown("GATESHEAD")
        .withPostcode("NE8 1BH")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("FIONA'S FLOWERS");
    assertThat(parts.get(1)).isEqualTo("REAR OF 5A");
    assertThat(parts.get(2)).isEqualTo("HIGH STREET");
    assertThat(parts.get(3)).isEqualTo("GATESHEAD");
    assertThat(parts.get(4)).isEqualTo("NE8 1BH");
  }

  @Test
  public void formatsTheDeliveryPointWithOrganisationAlt() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withOrganisation("CATH'S CAKES")
        .withBuildingName("VICTORIA HOUSE")
        .withThroughfare("HIGH STREET")
        .withPostTown("PORTSMOUTH")
        .withPostcode("PO1 1AF")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("CATH'S CAKES");
    assertThat(parts.get(1)).isEqualTo("VICTORIA HOUSE");
    assertThat(parts.get(2)).isEqualTo("HIGH STREET");
    assertThat(parts.get(3)).isEqualTo("PORTSMOUTH");
    assertThat(parts.get(4)).isEqualTo("PO1 1AF");
  }

  @Test
  public void formatsTheDeliveryPointWithPoBox() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withBuildingName("ROBINSONS")
        .withPoBoxNumber("61")
        .withPostTown("FAREHAM")
        .withPostcode("PO14 1UX")
        .build();

    List<String> parts = deliveryPoint.formattedParts();

    assertThat(parts.get(0)).isEqualTo("PO BOX 61");
    assertThat(parts.get(1)).isEqualTo("ROBINSONS");
    assertThat(parts.get(2)).isEqualTo("FAREHAM");
    assertThat(parts.get(3)).isEqualTo("PO14 1UX");
  }
}