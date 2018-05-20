/**
 * Pong application
 */
package com;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Tests of the ViewManager
 * @author wojtek
 *
 */
public class ViewManagerTest {
	/**
	 * Test of getting an instance of the viewManager
	 */
	@Test
	public final void testGetInstance() {
		ViewManager viewMan = ViewManager.INSTANCE;
		assertThat("Can get the Instance of ViewManager.", viewMan, is(notNullValue()));
	}
	
	/**
	 * Test of getting an instance of the viewManager
	 */
	@Test
	public final void testGetInstances() {
		ViewManager viewMan1 = ViewManager.INSTANCE;
		ViewManager viewMan2 = ViewManager.INSTANCE;
		assertEquals("Instansces are equal",viewMan1, viewMan2);
	}
	
}
