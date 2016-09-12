package com.steinf.pafaddressformat.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListsTest {
  @Test
  public void addsElementIfPresent() throws Exception {
    String element = "e";
    List<String> l = new ArrayList<>();

    Lists.addIfPresent(l, element);

    assertThat(l).contains("e").hasSize(1);
  }

  @Test
  public void doesNotAddElementIfNull() throws Exception {
    String element = null;
    List<String> l = new ArrayList<>();

    Lists.addIfPresent(l, element);

    assertThat(l).isEmpty();
  }

  @Test
  public void doesNotAddElementIfEmpty() throws Exception {
    String element = "";
    List<String> l = new ArrayList<>();

    Lists.addIfPresent(l, element);

    assertThat(l).isEmpty();
  }
}