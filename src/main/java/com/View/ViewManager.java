package com.View;

import java.util.ArrayList;
import java.util.List;

import com.Button.PongButton;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ViewManager {
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 800;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;

	private final static int MENU_BUTTONS_START_X = 100;
	private final static int MENU_BUTTONS_START_Y = 150;

	List<PongButton> menuButtons;
	
	public ViewManager() {
		menuButtons = new ArrayList<PongButton>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		createBackground();
		createTitle();
		createButtons();
	}
	
	public Stage getMainStage() {
		return mainStage;
	}
	
	private void addMenuButton(PongButton btn) {
		btn.setLayoutX(MENU_BUTTONS_START_X);
		btn.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size()*100);
		menuButtons.add(btn);
		mainPane.getChildren().add(btn);
	}
	
	private void createButtons() {
		createPlayerButton();
		createComputerButton();
		createSettingsButton();
		createExitButton();		
	}
	
	private void createPlayerButton() {
		PongButton PlayerPlayerBtn = new PongButton("vs. Player");
		addMenuButton(PlayerPlayerBtn);
		
	}
	
	private void createComputerButton() {
		PongButton PlayerComputerBtn = new PongButton("vs. Comp");
		addMenuButton(PlayerComputerBtn);		
	}
	
	private void createSettingsButton() {
		PongButton SettingsBtn = new PongButton("Settings");
		addMenuButton(SettingsBtn);		
	}
	
	private void createExitButton() {
		PongButton ExitBtn = new PongButton("Exit");
		addMenuButton(ExitBtn);		
	}
	
	private void createBackground() {
		mainPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	private void createTitle() {
		//ImageView title = new ImageView("src/test/resources/PongTitle.png");		
	}
}