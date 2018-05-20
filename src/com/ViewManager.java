/**
 * The manager of the Stage and current view.
 */
package com;

import com.Scens.CompChooseScene;
import com.Scens.CompGameScene;
import com.Scens.MenuScreen;
import com.Scens.PlayerScene;
import com.Scens.SettingsScene;

import javafx.stage.Stage;

/**
 * The enum Singleton that manages changing and loading the Scenes.
 * @author wojtek
 *
 */
public enum ViewManager {
	INSTANCE;
	
	private Stage mainStage;
	private MenuScreen menuScene;
	private PlayerScene playerScene;
	private CompChooseScene compConf;
	private SettingsScene settings;
	private CompGameScene level1;
	private CompGameScene level2;
	
	private ViewManager() {}
	
	/**
	 * The function that shows stage.
	 * @param startStage
	 */
	public void setManager(Stage startStage) {
		if(startStage == null)
			mainStage = new Stage();
		else mainStage = startStage;
		menuScene = new MenuScreen();
		playerScene = new PlayerScene();
		compConf = new CompChooseScene();
		settings = new SettingsScene();
		level1 = new CompGameScene(1);
		level2 = new CompGameScene(2);
		mainStage.setTitle("Pong");
		mainStage.setScene(menuScene);
		createScens();
		mainStage.setResizable(false);
		mainStage.show();
	}
	
	/**
	 * Method that calls all scenes
	 */
	private void createScens() {
		menuScene.createScene();
		playerScene.createScene();
		compConf.createScene();
		settings.createScene();
		level1.createScene();
		level2.createScene();
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
		} else if (newScene == "CompConf") {
			mainStage.setScene(compConf);
			return 3;
		} else if (newScene == "Settings") {
			mainStage.setScene(settings);
			return 4;
		} else if (newScene == "Level1") {
			mainStage.setScene(level1);
			return 5;
		} else if (newScene == "Level2") {
			mainStage.setScene(level2);
			return 6;
		}
		return 0;
	}
	
	/**
	 * Updates background in all scens.
	 */
	public void updateBackground() {
		menuScene.updateBackground();
		playerScene.updateBackground();
		compConf.updateBackground();
		settings.updateBackground();
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