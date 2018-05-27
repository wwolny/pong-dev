/**
 * Pong application
 */
package com.Controllers;

import com.Scens.PongScens;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * @author wojtek
 *
 */
public class PlayerView extends GameView implements PongScens {
	
	public PlayerView(GameModel model, GameController controller) {
		super(model, controller);
	}

	/**
	 * Method constructing the screen.
	 * Needs to be called in the ViewManager.
	 * Meets Interface for all scenes.
	 */
	public int createScene() {
		canvas = new Canvas(GameModel.WIDTH, GameModel.HEIGHT);
		gc = canvas.getGraphicsContext2D();
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), 
				e -> run(gc)));
		tl.setCycleCount(Timeline.INDEFINITE);
		
		createListners();
		
		((StackPane)getRoot()).getChildren().add(canvas);
		tl.play();
		return 1;
	}

	
	/**
	 * Method creating the Scene.
	 * Scene created with Canvas and GraphicContext
	 * @param gc
	 */
	private void run(GraphicsContext gc) {
		setScene();
		controller.movePlayer1();
		controller.movePlayer2();
		updatePaddlePlayer1();
		updatePaddlePlayer2();
	}
	
	private void createListners() {
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.W) 
				controller.changePlayer1DirectionUp();});
		
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.S) 
				controller.changePlayer1DirectionDown();});
		
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.UP) 
				controller.changePlayer2DirectionUp();});
		
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.DOWN) 
				controller.changePlayer2DirectionDown();});
		
		this.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			if(key.getCode() == KeyCode.S || key.getCode() == KeyCode.W)  
				controller.changePlayer1DirectionStay();});
		
		this.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			if(key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.UP) 
				controller.changePlayer2DirectionStay();});
		
		escapeListner();
		
		canvas.setOnMouseClicked(e -> controller.startGame());		
	}
}
