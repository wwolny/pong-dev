/**
 * The manager of the Stage and current view.
 */
package com;

import com.Scens.MenuScreen;
import com.Scens.PlayerScene;

import javafx.stage.Stage;

/**
 * The Enum Singleton that manages changing and loading the Scenes.
 * @author wojtek
 *
 */
public enum ViewManager {
	INSTANCE;
	
	private Stage mainStage;
	private MenuScreen menuScene;
	private PlayerScene playerScene;
	
	private ViewManager() {}
	
	/**
	 * The function that shows stage.
	 * @param startStage
	 */
	public void setManager(Stage startStage) {
		mainStage = startStage;
		menuScene = new MenuScreen();
		playerScene = new PlayerScene();
		mainStage.setTitle("Pong");
		mainStage.setTitle("Pong");
		mainStage.setScene(menuScene);
		menuScene.createScene();
		playerScene.createScene();
		mainStage.setResizable(false);
		mainStage.show();
	}
	
	/**
	 * The changing Scene method.
	 * @param newScene
	 * @return
	 */
	public int changeScene(String newScene) {
		if(newScene == "Player") {
			mainStage.setScene(playerScene);
			return 1;
		} else if (newScene == "Menu") {
			mainStage.setScene(menuScene);
			return 2;
		}
		return 0;
	}
	
	/**
	 * The getter of current Stage Width.
	 * @return
	 */
	public double getMainStageX() {
		return mainStage.getWidth();
	}
	
	/**
	 * The getter of current Stage Height.
	 * @return
	 */
	public double getMainStageY() {
		return mainStage.getHeight();
	}
	
}