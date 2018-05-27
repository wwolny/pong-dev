/** 
 * PONG application.
 */
package com.Scens;

import java.util.ArrayList;
import java.util.List;

import com.Button.PongButton;
import com.Controllers.MenuController;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * The Menu scene.
 * @author wojtek
 *
 */
//TODO: using resources in jar file 
public class MenuScreen extends Scene implements PongScens{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private final static int MENU_BUTTONS_START_X = 100;
	private final static int MENU_BUTTONS_START_Y = 150;
	
	private Canvas canvas;
	private GraphicsContext gc;
	private MenuController controller;
	/**
	 * The list of buttons.
	 */
	List<PongButton> menuButtons;
	
	public MenuScreen() {
		super(new AnchorPane(), WIDTH, HEIGHT);
		menuButtons = new ArrayList<PongButton>();
	}
	
	public int createScene() {
		canvas = new Canvas(WIDTH, HEIGHT);
		gc = canvas.getGraphicsContext2D();
		createBackground(gc);
		((AnchorPane)getRoot()).getChildren().add(canvas);
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
		PongButton PlayerPlayerBtn = new PongButton("vs. Player", sett.getFontSize());
		addMenuButton(PlayerPlayerBtn);
		PlayerPlayerBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				manager.changeScene(manager.getPlayer());
			}
		});
	}
	
	private void createComputerButton() {
		PongButton PlayerComputerBtn = new PongButton("vs. PC", sett.getFontSize());
		addMenuButton(PlayerComputerBtn);	
		PlayerComputerBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				manager.changeScene(manager.getCompConf());
			}
		});
	}
	
	private void createSettingsButton() {
		PongButton SettingsBtn = new PongButton("Settings", sett.getFontSize());
		addMenuButton(SettingsBtn);	
		SettingsBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				manager.changeScene(manager.getSettings());
			}
		});
	}
	
	private void createExitButton() {
		PongButton ExitBtn = new PongButton("Exit", sett.getFontSize());
		ExitBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.exit(0);
			}
		});	
		addMenuButton(ExitBtn);		
	}
	
	private void createBackground(GraphicsContext gc) {
		gc.setFill(sett.getBackgroundColor());
		gc.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	private void createTitle() {
		//String titlePath = "file:src/main/resources/PongTitle.png";
		//InputStream titleURL = getClass().getResourceAsStream(titlePath);
		//titlePath = IOUtils.to
		//ClassLoader classLoader = getClass().getClassLoader();
		//String imageUrl = classLoader.getResource("PongTitle.png").toExternalForm();
		final ImageView title = new ImageView("file:resources/PongTitle.png");
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

	@Override
	public void updateBackground() {
		createBackground(gc);
	}	
}