/**
 * The manager of the Stage and current view.
 */
package com;

import com.Controllers.CompGameView;
import com.Controllers.GameController;
import com.Controllers.GameModel;
import com.Controllers.PlayerView;
import com.Scens.CompChooseScene;
import com.Scens.MenuScreen;
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
	private CompChooseScene compConf;
	private SettingsScene settings;
	
	private PlayerView playerView;
	private GameModel playerModel;
	private GameController playerController;
	
	private CompGameView levelOneView;
	private GameModel levelOneModel;
	private GameController levelOneController;
	
	private CompGameView levelTwoView;
	private GameModel levelTwoModel;
	private GameController levelTwoController;
	
	private ViewManager() {}
	
	private enum Scenes {
		Menu,
		Player,
		CompConf,
		Settings,
		Level1,
		Level2
	}
	
	
	public enum Level {
		level1,
		level2
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
		compConf = new CompChooseScene();
		settings = new SettingsScene();
		
		playerModel = new GameModel();
		playerController = new GameController(playerModel);
		playerView = new PlayerView(playerModel, playerController);
		
		levelOneModel = new GameModel();
		levelOneController = new GameController(levelOneModel);
		levelOneView = new CompGameView(levelOneModel, levelOneController, Level.level1);
		
		levelTwoModel = new GameModel();
		levelTwoController = new GameController(levelTwoModel);
		levelTwoView = new CompGameView(levelTwoModel, levelTwoController, Level.level2);
		
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
		compConf.createScene();
		settings.createScene();
		
		playerView.createScene();
		levelOneView.createScene();
		levelTwoView.createScene();
	}
	
	/**
	 * The changing Scene method.
	 * @param newScene
	 * @return
	 */
	public int changeScene(Scenes newScene) {
		if(newScene == Scenes.Player) {
			mainStage.setScene(playerView);
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
			mainStage.setScene(levelOneView);
			return 5;
		} else if (newScene == Scenes.Level2) {
			mainStage.setScene(levelTwoView);
			return 6;
		}
		return 0;
	}
	
	/**
	 * Updates background in all scenes.
	 */
	public void updateBackground() {
		menuScene.updateBackground();
		compConf.updateBackground();
		settings.updateBackground();
		playerView.updateBackground();
		levelOneView.updateBackground();
		levelTwoView.updateBackground();
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
	public Scenes getLevel1Scene() {
		return Scenes.Level1;
	}
	
	/**
	 * @return Level2 of Scenes Enum
	 */
	public Scenes getLevel2Scene() {
		return Scenes.Level2;
	}
	/**
	 * @return Level1 of Scenes Enum
	 */
	public Level getLevel1Level() {
		return Level.level1;
	}
	
	/**
	 * @return Level2 of Scenes Enum
	 */
	public Level getLevel2Level() {
		return Level.level2;
	}
}