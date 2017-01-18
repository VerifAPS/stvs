package edu.kit.iti.formal.stvs.model.common;

import javafx.beans.InvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by leonk on 18.01.2017.
 */
public class SelectionTest {
  @Test
  public void testClearColumnListenerSelection(){
    BooleanProperty wasCalled = new SimpleBooleanProperty(false);
    Selection selection = new Selection("fgrfg", 4);
    InvalidationListener listener = i -> wasCalled.set(true);
    selection.addListener(listener);
    selection.columnProperty().clear();
    assertTrue(wasCalled.get());
    assertTrue(selection.columnProperty().isNull().get());

    wasCalled.set(false);
    selection.removeListener(listener);
    selection.setColumn("Test");
    assertFalse(wasCalled.get());
    assertEquals(selection.getColumn(), "Test");
  }

  @Test
  public void testSetRow(){
    Selection selection = new Selection();
    assertTrue(selection.rowProperty().isNull().get());
    selection.setRow(5);
    assertEquals(selection.getRow(), 5);
    assertEquals(selection.rowProperty().get(), 5);
  }
}