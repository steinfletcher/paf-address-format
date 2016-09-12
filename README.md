paf-address-format
===

A simple library (with no dependencies) that formats a PAF address for print.

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
