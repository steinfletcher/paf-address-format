package com.tapatron.pafaddressformat.common;

import com.tapatron.pafaddressformat.common.Strings;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringsTest {
  @Test
  public void returnsTrueIfEmptyBlank() throws Exception {
    String blankEmpty = "";

    boolean isBlank = Strings.isNullOrEmpty(blankEmpty);

    assertThat(isBlank).isTrue();
    assertThat(Strings.isPresent(blankEmpty)).isFalse();
  }

  @Test
  public void returnsTrueIfNullBlank() throws Exception {
    String blankNull = null;

    boolean isBlank = Strings.isNullOrEmpty(blankNull);

    assertThat(isBlank).isTrue();
    assertThat(Strings.isPresent(blankNull)).isFalse();
  }

  @Test
  public void returnsFalseIfPresent() throws Exception {
    String notBlank = "isPresent";

    boolean isBlank = Strings.isNullOrEmpty(notBlank);

    assertThat(isBlank).isFalse();
    assertThat(Strings.isPresent(notBlank)).isTrue();
  }
}