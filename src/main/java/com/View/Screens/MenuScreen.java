package com.View.Screens;

import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;

import com.Button.PongButton;
import com.View.ViewManager;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


//TODO: using resources in jar file 
public class MenuScreen extends Scene{
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 800;
	private final static int MENU_BUTTONS_START_X = 100;
	private final static int MENU_BUTTONS_START_Y = 150;
	
	List<PongButton> menuButtons;
	
	public MenuScreen() {
		super(new AnchorPane(), WIDTH, HEIGHT);
		menuButtons = new ArrayList<PongButton>();
	}
	
	public int createScene() {
		createBackground();
		createTitle();
		createButtons();
		createTitle();
		return 1;
	}
	
	private void addMenuButton(PongButton btn) {
		btn.setLayoutX(MENU_BUTTONS_START_X);
		btn.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size()*100);
		menuButtons.add(btn);
		((AnchorPane)getRoot()).getChildren().add(btn);
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
		PlayerPlayerBtn.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				ViewManager.INSTANCE.changeScene("Player");
			}
		});
	}
	
	private void createComputerButton() {
		PongButton PlayerComputerBtn = new PongButton("vs. PC");
		addMenuButton(PlayerComputerBtn);		
	}
	
	private void createSettingsButton() {
		PongButton SettingsBtn = new PongButton("Settings");
		addMenuButton(SettingsBtn);		
	}
	
	private void createExitButton() {
		PongButton ExitBtn = new PongButton("Exit");
		ExitBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.exit(0);
			}
		});	
		addMenuButton(ExitBtn);		
	}
	
	private void createBackground() {
		((AnchorPane)getRoot()).setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	private void createTitle() {
		//String titlePath = "file:src/main/resources/PongTitle.png";
		//InputStream titleURL = getClass().getResourceAsStream(titlePath);
		//titlePath = IOUtils.to
		//ClassLoader classLoader = getClass().getClassLoader();
		//String imageUrl = classLoader.getResource("PongTitle.png").toExternalForm();
		final ImageView title = new ImageView("file:src/main/resources/PongTitle.png");
		title.setLayoutX(MENU_BUTTONS_START_X);
		title. setLayoutY(-80);
		
		title.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				title.setEffect(new DropShadow());
			}
		});
		
		title.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				title.setEffect(null);
			}
		});
		
		((AnchorPane)getRoot()).getChildren().add(title);
	}	
}
