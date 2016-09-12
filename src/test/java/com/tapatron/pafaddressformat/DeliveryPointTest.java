package com.tapatron.pafaddressformat;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DeliveryPointTest {

  @Test
  public void addressBuilderShouldConstructValidAddress() throws Exception {
    DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
        .withSubBuildingName("FLAT 1")
        .withBuildingName("VICTORIA HOUSE")
        .withBuildingNumber("15")
        .withDependentLocality("COOMBE BISSETT")
        .withOrganisation("SURE FIT COVERS")
        .withDepartment("EMERGENCY")
        .withPoBoxNumber("1242")
        .withDoubleDependentLocality("TYRE INDUSTRIAL ESTATE")
        .withDependentThroughfare("CHESHUNT MEWS")
        .withThroughfare("CYPRESS STREET")
        .withPostcode("CV3 3GU")
        .withPostTown("COVENTRY")
        .build();

    assertThat(deliveryPoint.getSubBuildingName()).isEqualTo("FLAT 1");
    assertThat(deliveryPoint.getBuildingName()).isEqualTo("VICTORIA HOUSE");
    assertThat(deliveryPoint.getBuildingNumber()).isEqualTo("15");
    assertThat(deliveryPoint.getDependentLocality()).isEqualTo("COOMBE BISSETT");
    assertThat(deliveryPoint.getOrganisation()).isEqualTo("SURE FIT COVERS");
    assertThat(deliveryPoint.getDepartment()).isEqualTo("EMERGENCY");
    assertThat(deliveryPoint.getPoBoxNumber()).isEqualTo("1242");
    assertThat(deliveryPoint.getDependentThroughfare()).isEqualTo("CHESHUNT MEWS");
    assertThat(deliveryPoint.getThroughfare()).isEqualTo("CYPRESS STREET");
    assertThat(deliveryPoint.getPostcode()).isEqualTo("CV3 3GU");
    assertThat(deliveryPoint.getPostTown()).isEqualTo("COVENTRY");
  }
}
