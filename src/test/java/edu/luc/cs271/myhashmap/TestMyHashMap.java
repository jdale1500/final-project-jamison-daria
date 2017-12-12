package edu.luc.cs271.myhashmap;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyHashMap {
  private IStack<String> fixture;

  @Before
  public void setUp() {
    fixture = new LinkedStack<>();
  }

  @After
  public void tearDown() {
    fixture = null;
  }

  @Test
  public void testInitial() {
    assertTrue(fixture.isEmpty());
    try {
      fixture.pop();
      fail("java.util.NoSuchElementException expected");
    } catch (final NoSuchElementException ex) {
      // exception occurred => all good
    }

  }

  @Test
  public void testAfterPush() {
    final String value = "hello";
    fixture.push(value);
    assertFalse(fixture.isEmpty());
    assertEquals(value, fixture.peek());
  }

  @Test
  public void testPushThenPop() {
    final String value = "hello";
    fixture.push(value);
    assertEquals(value, fixture.pop());
    assertTrue(fixture.isEmpty());
  }

  @Test
  public void testPush2ThenPop2() {
    final String value1 = "hello";
    final String value2 = "world";
    fixture.push(value1);
    fixture.push(value2);
    assertEquals(value2, fixture.pop());
    assertEquals(value1, fixture.pop());
    assertTrue(fixture.isEmpty());
  }

  @Test
  public void testAsListEmpty() {
    assertEquals(0, fixture.asList().size());
  }

  @Test
  public void testAsListNonempty() {
    final String value1 = "hello";
    final String value2 = "world";
    fixture.push(value1);
    fixture.push(value2);
    final List<String> list = fixture.asList();
    assertEquals(2, list.size());
    assertEquals(Arrays.asList(value2, value1), list);
  }

}