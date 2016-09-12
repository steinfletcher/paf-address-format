paf-address-format
===

[![CircleCI](https://circleci.com/gh/steinfletcher/paf-address-format.svg?style=svg)](https://circleci.com/gh/steinfletcher/paf-address-format)

A simple library (with no dependencies) that formats a PAF address for print.

Attempts to comply with the Royal Mail's [PAF Programmer's guide](http://www.royalmail.com/sites/default/files/docs/pdf/programmers_guide_edition_7_v5.pdf)

## Usage

```java
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

// OR

String formatted = deliveryPoint.toString();

assertThat(formatted).isEqualTo(
    "12A HIGH STREET NORTH\n" +
    "COOMBE BISSETT\n" +
    "SALISBURY\n" +
    "SP5 4NA"
);

```
