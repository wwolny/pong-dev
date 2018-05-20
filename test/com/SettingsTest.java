/**
 * Pong application 
 */
package com;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import javafx.scene.paint.Color;


/**
 * Tests of Settings enum
 * @author wojtek
 *
 */
public class SettingsTest {
	
	/**
	 * test getting the Instance of enum
	 */
	@Test
	public final void testGetInstance() {
		Settings settMan = Settings.INSTANCE;
		assertThat("Settings can get the instance of the enum", settMan, is(notNullValue()));
	}
	
	@Test
	public final void testDefaultColor() {
		Settings settMan = Settings.INSTANCE;
		assertEquals("Default Background color is black",settMan.getBackgroundColor(), Color.BLACK);
	}

}
