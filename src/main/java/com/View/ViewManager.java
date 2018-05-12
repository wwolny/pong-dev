package com.View;

import com.View.Screens.MenuScreen;
import com.View.Screens.PlayerScene;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import static org.junit.Assert.*;


import javafx.stage.Stage;

public enum ViewManager {
	INSTANCE;
	
	private Stage mainStage;
	private MenuScreen Menu;
	private PlayerScene playerScene;

	private ViewManager() {
		Menu = new MenuScreen();
		playerScene = new PlayerScene();
		mainStage = new Stage();
		mainStage.setScene(Menu);
		Menu.createScene();
		playerScene.createScene();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	public void changeScene(String newScene) {
		if(newScene == "Player") {
			mainStage.setScene(playerScene);
		} else if (newScene == "Menu") {
			mainStage.setScene(Menu);
		}
		return;
	}
}