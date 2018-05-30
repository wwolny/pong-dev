/**
 * Pong application
 */
package com.Scens;

import java.util.ArrayList;
import java.util.List;

import com.Settings;
import com.ViewManager;
import com.Button.ColorButton;
import com.Button.PongButton;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Scene to change the graphics in the game
 * @author wojtek
 *
 */
public class SettingsScene extends Scene implements PongScens{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	ViewManager manager = ViewManager.INSTANCE;
	Settings sett = Settings.INSTANCE;
	
	private Canvas canvas;
	private GraphicsContext gc;
	private VBox vbBox;
	
	/**
	 * In order to add another colour of background the edit here is needed.
	 * The following step is to add in initializeBtnsListners() event
	 * The event must be implemented for very specific index in the enum
	 * And needs to change the colour of background to specified colour.
	 */
	public enum colors {
		BLACK,
		RED,
		GREEN,
		BLUE
	};
	
	/**
	 * The list that holds all buttons with colours
	 */
	List<ColorButton> colorBtns;
	
	/**
	 * Constructor of the scene
	 */
	public SettingsScene() {
		super(new GridPane(), WIDTH, HEIGHT);
		colorBtns = new ArrayList<ColorButton>();
		canvas = new Canvas(WIDTH, HEIGHT);
		vbBox = new VBox();
	}
	
	/**
	 * Obligatory method that creates scene
	 */
	public int createScene() {
		gc = canvas.getGraphicsContext2D();
		createBackground(gc);
		((GridPane)getRoot()).getChildren().add(canvas);
		vbBox.setAlignment(Pos.CENTER);
		vbBox.setSpacing(50);
		vbBox.setPadding(new Insets(0, 20, 10, 20));
		createBackgroundColorSetting();
		createBackBtn();
		((GridPane)getRoot()).add(vbBox, 0, 0);
		return 1;
	}

		
	private void createBackBtn() {
		PongButton BackBtn = new PongButton("Back", sett.getFontSize());
		vbBox.getChildren().add(BackBtn);
		BackBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				manager.changeScene(manager.getMenu());
			}
		});
	}

	private void createBackgroundColorSetting() {
		HBox BackgroundColorSett = new HBox();
		BackgroundColorSett.setAlignment(Pos.CENTER);
		BackgroundColorSett.setSpacing(50);
		BackgroundColorSett.setPadding(new Insets(0, 20, 10, 20));
		Label labColBack = new Label("Background Color:");
		labColBack.setStyle(sett.getLabelsStyle());
		BackgroundColorSett.getChildren().add(labColBack);
		for (int i = 0; i < colors.values().length; i++) {
			colorBtns.add(new ColorButton(colors.values()[i].toString().toLowerCase()));
			BackgroundColorSett.getChildren().add(colorBtns.get(i));
		}
		initializeBtnsListners();
		vbBox.getChildren().add(BackgroundColorSett);
	}

	private void initializeBtnsListners() {
		colorBtns.get(0).setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				sett.setBackgroundColor(Color.web("black", 0.5));
			}
		});
		colorBtns.get(1).setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				sett.setBackgroundColor(Color.web("red", 0.5));
			}
		});
		colorBtns.get(2).setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				sett.setBackgroundColor(Color.web("green", 0.5));
			}
		});
		colorBtns.get(3).setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				sett.setBackgroundColor(Color.web("blue", 0.5));
			}
		});
	}
	
	private void createBackground(GraphicsContext gc) {
		gc.setFill(sett.getBackgroundColor());
		gc.fillRect(0, 0, WIDTH, HEIGHT);
	}

	@Override
	public void updateBackground() {
		createBackground(gc);		
	}
}

