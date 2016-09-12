paf-address-format
===

A simple library that formats a PAF address for print.

## Usage

```java
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

// OR

String formatted = deliveryPoint.toString();

assertThat(formatted).isEqualTo(
    "1A SEASTONE COURT\n" +
    "STATION ROAD\n" +
    "HOLT\n" +
    "NR25 7HG"
);

```