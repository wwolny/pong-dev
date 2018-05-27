/**
 * 
 */
package com.Controllers;

import com.ViewManager;

import javafx.scene.input.MouseEvent;

/**
 * Controller of the MenuScene
 * @author wojtek
 */
public class MenuController {
	private ViewManager manager = ViewManager.INSTANCE;
	
	public void handleChangeToPlayerScene(MouseEvent event) {
				manager.changeScene(manager.getPlayer());
	}
}
