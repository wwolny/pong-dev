/**
  * Pong application.
 */
package com.Scens;

import com.Settings;
import com.ViewManager;
/**
 * The Interface for all scenes in the application.
 * @author wojtek
 *
 */
public interface PongScens {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	/**
	 * Instances of the both ViewManager and Settings manager.
	 */
	ViewManager manager = ViewManager.INSTANCE;
	Settings sett = Settings.INSTANCE;
	
	public int createScene();
	public void updateBackground();
}
