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
	
	public enum Scenes {
		Menu,
		Player,
		CompConf,
		Settings,
		Level1,
		Level2
	}
	
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
	public int changeScene(Scenes newScene) {
		if(newScene == Scenes.Player) {
			mainStage.setScene(playerScene);
			return 1;
		} else if (newScene == Scenes.Menu) {
			mainStage.setScene(menuScene);
			return 2;
		} else if (newScene == Scenes.CompConf) {
			mainStage.setScene(compConf);
			return 3;
		} else if (newScene == Scenes.Settings) {
			mainStage.setScene(settings);
			return 4;
		} else if (newScene == Scenes.Level1) {
			mainStage.setScene(level1);
			return 5;
		} else if (newScene == Scenes.Level2) {
			mainStage.setScene(level2);
			return 6;
		}
		return 0;
	}
	
	/**
	 * Updates background in all scenes.
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
	
	/**
	 * @return Menu  of Scenes Enum
	 */
	public Scenes getMenu() {
		return Scenes.Menu;
	}
	
	/**	
	 * @return Player  of Scenes Enum
	 */
	public Scenes getPlayer() {
		return Scenes.Player;
	}
	
	/**
	 * @return Game versus Computer Configuration  of Scenes Enum
	 */
	public Scenes getCompConf() {
		return Scenes.CompConf;
	}
	
	/**
	 * @return Settings  of Scenes Enum
	 */
	public Scenes getSettings() {
		return Scenes.Settings;
	}
	
	/**
	 * @return Level1 of Scenes Enum
	 */
	public Scenes getLevel1() {
		return Scenes.Level1;
	}
	
	/**
	 * @return Level2 of Scenes Enum
	 */
	public Scenes getLevel2() {
		return Scenes.Level2;
	}	
}