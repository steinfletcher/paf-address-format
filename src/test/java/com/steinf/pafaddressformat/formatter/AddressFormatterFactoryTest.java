package com.steinf.pafaddressformat.formatter;

import com.steinf.pafaddressformat.DeliveryPoint;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AddressFormatterFactoryTest {
  @Test
  public void determineRule1() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withOrganisation("LEDA ENGINEERING LTD")
        .withDependentLocality("APPLEFORD")
        .withPostTown("ABINGDON")
        .withPostcode("OX14 4PG")
        .build();

    AddressFormatter formatter = AddressFormatterFactory.createFormatter(deliveryPoint);

    assertThat(formatter).isInstanceOf(Rule1Formatter.class);
  }

  @Test
  public void determineRule2() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withBuildingNumber("31 ACACIA")
        .withThroughfare("AVENUE")
        .withPostTown("ABINGDON")
        .withPostcode("OX14 4PG")
        .build();

    AddressFormatter formatter = AddressFormatterFactory.createFormatter(deliveryPoint);

    assertThat(formatter).isInstanceOf(Rule2Formatter.class);
  }

  @Test
  public void determineRule3() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withBuildingName("1A")
        .withThroughfare("STATION ROAD")
        .withDependentThroughfare("SEASTONE COURT")
        .withPostTown("HOLT")
        .withPostcode("NR25 7HG")
        .build();

    AddressFormatter formatter = AddressFormatterFactory.createFormatter(deliveryPoint);

    assertThat(formatter).isInstanceOf(Rule3Formatter.class);
  }

  @Test
  public void determineRule4() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withBuildingName("VICTORIA HOUSE")
        .withBuildingNumber("15")
        .withThroughfare("THE STREET")
        .withPostTown("CHRISTCHURCH")
        .withPostcode("BH23 6AA")
        .build();

    AddressFormatter formatter = AddressFormatterFactory.createFormatter(deliveryPoint);

    assertThat(formatter).isInstanceOf(Rule4Formatter.class);
  }

  @Test
  public void determineRule5() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("FLAT 1")
        .withBuildingNumber("12")
        .withThroughfare("LIME TREE AVENUE")
        .withPostTown("BRISTOL")
        .withPostcode("BS8 4AB")
        .build();

    AddressFormatter formatter = AddressFormatterFactory.createFormatter(deliveryPoint);

    assertThat(formatter).isInstanceOf(Rule5Formatter.class);
  }

  @Test
  public void determineRule6() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("10B")
        .withBuildingName("BARRY JACKSON TOWER")
        .withThroughfare("ESTONE WALK")
        .withPostTown("BIRMINGHAM")
        .withPostcode("B6 5BA")
        .build();

    AddressFormatter formatter = AddressFormatterFactory.createFormatter(deliveryPoint);

    assertThat(formatter).isInstanceOf(Rule6Formatter.class);
  }

  @Test
  public void determineRule7() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("2B")
        .withBuildingName("THE TOWER")
        .withBuildingNumber("27")
        .withThroughfare("JOHN STREET")
        .withPostTown("WINCHESTER")
        .withPostcode("SO23 9AP")
        .build();

    AddressFormatter formatter = AddressFormatterFactory.createFormatter(deliveryPoint);

    assertThat(formatter).isInstanceOf(Rule7Formatter.class);
  }

  @Test
  public void returnsAllFieldsFormatterIfCannotDetermineRule() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withThroughfare("JOHN STREET")
        .withPostTown("WINCHESTER")
        .withPostcode("SO23 9AP")
        .build();

    AddressFormatter formatter = AddressFormatterFactory.createFormatter(deliveryPoint);

    assertThat(formatter).isInstanceOf(AllFieldsFormatter.class);
  }
}