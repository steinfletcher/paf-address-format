package com.steinf.pafaddressformat;

import com.steinf.pafaddressformat.formatter.AddressFormatter;
import com.steinf.pafaddressformat.formatter.AddressFormatterFactory;

import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Represents a delivery point as described in the PAF Programmer Guide.
 *
 * @see <a href="http://www.royalmail.com/sites/default/files/docs/pdf/programmers_guide_edition_7_v5.pdf"></a>
 *
 * Usage:
 *
 * DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
 *   .withSubBuildingName("A")
 *   .withBuildingNumber("12")
 *   .withThroughfare("HIGH STREET NORTH")
 *   .withDependentLocality("COOMBE BISSETT")
 *   .withPostTown("SALISBURY")
 *   .withPostcode("SP5 4NA")
 *   .build();
 *
 *   List<String> parts = deliveryPoint.formattedParts();
 *
 *   assertThat(parts.get(0)).isEqualTo("12A HIGH STREET NORTH");
 *   assertThat(parts.get(1)).isEqualTo("COOMBE BISSETT");
 *   assertThat(parts.get(2)).isEqualTo("SALISBURY");
 *   assertThat(parts.get(3)).isEqualTo("SP5 4NA");
 *
 * OR
 *
 * String formatted = deliveryPoint.toString();
 *
 * assertThat(formatted).isEqualTo(
 *   "12A HIGH STREET NORTH\n" +
 *   "COOMBE BISSETT\n" +
 *   "SALISBURY\n" +
 *   "SP5 4NA"
 * );
 *
 */
public class DeliveryPoint {
  // premises elements
  private final String subBuildingName;
  private final String buildingName;
  private final String buildingNumber;
  private final String organisation;
  private final String department;
  private final String poBoxNumber;

  // throughfare elements
  private final String throughfare;
  private final String dependentThroughfare;

  // locality elements
  private final String doubleDependentLocality;
  private final String dependentLocality;
  private final String postTown;

  // postcode element
  private final String postcode;

  /**
   * Use {@link DeliveryPoint.Builder} to create new instances
   */
  private DeliveryPoint(String subBuildingName, String buildingName, String buildingNumber,
                       String organisation, String department, String poBoxNumber,
                       String throughfare, String dependentThroughfare,
                       String doubleDependentLocality, String dependentLocality, String postTown,
                       String postcode) {
    this.subBuildingName = subBuildingName;
    this.buildingName = buildingName;
    this.buildingNumber = buildingNumber;
    this.organisation = organisation;
    this.department = department;
    this.poBoxNumber = poBoxNumber;
    this.throughfare = throughfare;
    this.dependentThroughfare = dependentThroughfare;
    this.doubleDependentLocality = doubleDependentLocality;
    this.dependentLocality = dependentLocality;
    this.postTown = postTown;
    this.postcode = postcode;
  }

  public String getSubBuildingName() {
    return subBuildingName;
  }

  public String getBuildingName() {
    return buildingName;
  }

  public String getBuildingNumber() {
    return buildingNumber;
  }

  public String getOrganisation() {
    return organisation;
  }

  public String getDepartment() {
    return department;
  }

  public String getPoBoxNumber() {
    return poBoxNumber;
  }

  public String getDependentThroughfare() {
    return dependentThroughfare;
  }

  public String getThroughfare() {
    return throughfare;
  }

  public String getDoubleDependentLocality() {
    return doubleDependentLocality;
  }

  public String getDependentLocality() {
    return dependentLocality;
  }

  public String getPostTown() {
    return postTown;
  }

  public String getPostcode() {
    return postcode;
  }

  public List<String> formattedParts() {
    AddressFormatter formatter = AddressFormatterFactory.createFormatter(this);
    return formatter.format(this);
  }

  @Override
  public String toString() {
    List<String> parts = formattedParts();
    return parts.stream().collect(joining(System.getProperty("line.separator")));
  }

  public static class Builder {

    private String subBuildingName;
    private String buildingName;
    private String buildingNumber;
    private String organisation;
    private String department;
    private String poBoxNumber;
    private String throughfare;
    private String dependentThroughfare;
    private String doubleDependentLocality;
    private String dependentLocality;
    private String postTown;
    private String postcode;

    public Builder withSubBuildingName(String subBuildingName) {
      this.subBuildingName = subBuildingName;
      return this;
    }

    public Builder withBuildingName(String buildingName) {
      this.buildingName = buildingName;
      return this;
    }

    public Builder withBuildingNumber(String buildingNumber) {
      if (!"0".equals(buildingNumber)) {
        this.buildingNumber = buildingNumber;
      }
      return this;
    }

    public Builder withOrganisation(String organisation) {
      this.organisation = organisation;
      return this;
    }

    public Builder withDepartment(String department) {
      this.department = department;
      return this;
    }

    public Builder withPoBoxNumber(String poBoxNumber) {
      this.poBoxNumber = poBoxNumber;
      return this;
    }

    public Builder withThroughfare(String throughfare) {
      this.throughfare = throughfare;
      return this;
    }

    public Builder withDependentThroughfare(String dependentThroughfare) {
      this.dependentThroughfare = dependentThroughfare;
      return this;
    }

    public Builder withDoubleDependentLocality(String doubleDependentLocality) {
      this.doubleDependentLocality = doubleDependentLocality;
      return this;
    }

    public Builder withDependentLocality(String dependentLocality) {
      this.dependentLocality = dependentLocality;
      return this;
    }

    public Builder withPostTown(String postTown) {
      this.postTown = postTown;
      return this;
    }

    public Builder withPostcode(String postcode) {
      this.postcode = postcode;
      return this;
    }

    public DeliveryPoint build() {
      return new DeliveryPoint(subBuildingName, buildingName, buildingNumber, organisation,
          department, poBoxNumber, throughfare, dependentThroughfare, doubleDependentLocality, dependentLocality,
          postTown, postcode);
    }
  }
}
