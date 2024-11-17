package edu.grinnell.csc207;

import java.lang.reflect.Array;

import edu.grinnell.csc207.util.AssociativeArray;
import edu.grinnell.csc207.util.NullKeyException;
import edu.grinnell.csc207.util.KeyNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * A place for you to put your own tests (beyond the shared repo).
 *
 * @author Your Name Here
 */
public class TestsFromStudent {
  /**
   * A simple test.
   */
  @Test
  public void alwaysPass() throws Exception {
  } // alwaysPass()
  @Test
    /**
   * Do we get a the new value after changing the value of an already created key?
   *
   * @throws Exception
   */
  public void bohrerPurnellMylesTest01() throws Exception {
    // Build an array
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    // add a pair to arr
    arr.set("Wood", "Lumberjack");
    // make a clone
    AssociativeArray<String, String> arrClone = arr.clone();
    // change the key/value pair of clone
    arrClone.set("Wood", "Chip");
    try {
      assertEquals("Chip", arrClone.get("Wood"));
    } catch (Exception e) {
      fail("Cloned array does not contain the expected value");
    } // try/catch
    // change key, pair value
    arrClone.set("Wood", "Chipmonk");
    try {
      assertEquals("Chipmonk", arrClone.get("Wood"));
    } catch (Exception e) {
      fail("Cloned array does not contain the expected value");
    } // try/catch
    // Set a new key/value pair with opposite key/value values.
    arrClone.set("Chipmonk", "Wood");
    // Make sure it contains the appropriate value
    try {
      assertEquals("Wood", arrClone.get("Chipmonk"));
    } catch (Exception e) {
      fail("Clone does not contain intended value");
    } // try/catch
    // Ensure the original array does not include cloned values.
    try {
      assertEquals("Wood", arr.get("Chipmonk"));
      fail("Failed bohrerPurnellTest01");
    } catch (Exception e) {
      // expected
    } // try/catch
  } // bohrerPurnellTest01()


  @Test
  /**
  * Does setting keys/value pairs with differing capitalization create new key/value pairs?
  *
  * @throws Exception
  */
  public void bohrerPurnellMylesTest02() throws Exception {
    // Build an array
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    // add key/value pair
    arr.set("Super", "Suit");
    // add key/value pair with differing key capitalization
    arr.set("super", "Man");
    try {
      assertEquals("Suit", arr.get("Super"));
    } catch (Exception e) {
      fail("array arr does not contain the expected value");
    } // try/catch
    try {
      assertEquals("Man", arr.get("super"));
    } catch (Exception e) {
      fail("array arr does not contain the expected value");
    } // try/catch
    // try with varying captilization at different parts of the key
    // add key/value pair
    arr.set("supeR", "Duper");
    // add key/value pair with differing key capitalization
    arr.set("suPer", "Pact");
    try {
      assertEquals("Pact", arr.get("suPer"));
    } catch (Exception e) {
      fail("array arr does not contain the expected value");
    } // try/catch
    try {
      assertEquals("Duper", arr.get("supeR"));
    } catch (Exception e) {
      fail("array arr does not contain the expected value");
    } // try/catch
    // Ensure there are no issues with the same concept but with values
    // add a key/pair set to arr
    arr.set("Captain", "America");
    // add key/value pair with differing key capitalization
    arr.set("US", "america");
    try {
      assertEquals("America", arr.get("Captain"));
    } catch (Exception e) {
      fail("array does not contain the expected value");
    } // try/catch
    try {
      assertEquals("america", arr.get("US"));
    } catch (Exception e) {
      fail("array does not contain intended value");
    } // try/catch
  } // bohrerPurnellTest02()

  @Test
  /**
  * Does trying to get a null key accurately not change the size of the array?
  *
  * @throws Exception
  */
  public void bohrerPurnellMylesEdge01() throws Exception {
    // Build an array
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    // add key/value pair
    arr.set("Super", "Suit");
    try {
      assertEquals("Suit", arr.get(null));
      fail("Null key attempted to be got");
    } catch (Exception e) {
      assertEquals(1, arr.size());
    }
  } // bohrerPurnellEdge01()
} // class TestsFromStudent
