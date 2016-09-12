package com.steinf.pafaddressformat.common;

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

  @Test
  public void containsNumber() throws Exception {
    String hasNumber = "asd8ur";

    boolean containsNumber = Strings.containsNumber(hasNumber);

    assertThat(containsNumber).isTrue();
  }

  @Test
  public void doesNotContainNumber() throws Exception {
    String noNumber = "asdur";

    boolean containsNumber = Strings.containsNumber(noNumber);

    assertThat(containsNumber).isFalse();
  }


  @Test
  public void isNumeric() throws Exception {
    String hasNumber = "41516";

    boolean isNumeric = Strings.isNumeric(hasNumber);

    assertThat(isNumeric).isTrue();
  }

  @Test
  public void isNotNumeric() throws Exception {
    String noNumber = "131-889";

    boolean notNumeric = Strings.isNumeric(noNumber);

    assertThat(notNumeric).isFalse();
  }
}