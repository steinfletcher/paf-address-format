paf-address-format
===

[![CircleCI](https://circleci.com/gh/steinfletcher/paf-address-format.svg?style=svg&circle-token=bd07a471e0058fe5d3334d035939573e00dfcc47)](https://circleci.com/gh/steinfletcher/paf-address-format)

A simple library (with no dependencies) that formats a PAF address for print.

Attempts to comply with the Royal Mail's [PAF Programmer's guide](http://www.royalmail.com/sites/default/files/docs/pdf/programmers_guide_edition_7_v5.pdf)

## Why?

There are 7 rules which determine the print format of an address and several exceptions can be applied to these rules.
 Writing some code to format an address is not a trivial task.  Given an address, this library determines the rule type, 
 analyzes which exceptions should be applied and invokes a specific formatter for the address.

## Usage

### Extract the lines of the print address

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
```

### Get the entire address as a string including platform specific new line characters

```java
DeliveryPoint deliveryPoint = new DeliveryPoint.Builder()
  .withSubBuildingName("2B")
  .withBuildingName("THE TOWER")
  .withBuildingNumber("27")
  .withThroughfare("JOHN STREET")
  .withPostTown("WINCHESTER")
  .withPostcode("SO23 9AP")
  .build();

String formatted = deliveryPoint.toString();

assertThat(formatted).isEqualTo(
    "2B THE TOWER\n" +
    "27 JOHN STREET\n" +
    "WINCHESTER\n" +
    "SO23 9AP"
);

```
