package com.steinf.pafaddressformat.formatter;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RuleExceptionTest {
  @Test
  public void isNotRule3SpecialException() throws Exception {
    String buildingName = "FLOWER HOUSE 9999";

    boolean isException = RuleException.isRule3SpecialException(buildingName);

    assertThat(isException).isFalse();
  }

  @Test
  public void isRule3SpecialExceptionAboveRange() throws Exception {
    String buildingName = "FLOWER HOUSE 10000";

    boolean isException = RuleException.isRule3SpecialException(buildingName);

    assertThat(isException).isTrue();
  }

  @Test
  public void isRule3SpecialExceptionContainsHyphen() throws Exception {
    String buildingName = "FLOWER HOUSE 7-12";

    boolean isException = RuleException.isRule3SpecialException(buildingName);

    assertThat(isException).isTrue();
  }

  @Test
  public void isRule3SpecialExceptionContainsLetter() throws Exception {
    String buildingName = "FLOWER HOUSE 123A";

    boolean isException = RuleException.isRule3SpecialException(buildingName);

    assertThat(isException).isTrue();
  }
}