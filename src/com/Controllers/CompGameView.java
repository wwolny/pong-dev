/**
 * Pong Application
 */
package com.Controllers;

import com.ViewManager;
import com.Scens.PongScens;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * Scene that will allow to create Scenes for different levels
 * @author wojtek
 *
 */
public class CompGameView extends GameView implements PongScens  {
	private ViewManager manager = ViewManager.INSTANCE;
	
	public CompGameView(GameModel model, GameController controller, ViewManager.Level level) {
		super(model, controller);
		if(level == manager.getLevel1Level())
			controller.setLevel1();
		if(level == manager.getLevel2Level())
			controller.setLevel2();
	}

	@Override
	public int createScene() {
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), 
				e -> run(gc)));
		tl.setCycleCount(Timeline.INDEFINITE);
		
		createListners();
		
		((StackPane)getRoot()).getChildren().add(canvas);
		tl.play();
		return 1;
	}	
	
	private void createListners() {
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.UP) 
				controller.changePlayer1DirectionUp();});
		
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.DOWN) 
				controller.changePlayer1DirectionDown();});
		
		this.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			if(key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.UP) 
				controller.changePlayer1DirectionStay();});
		
		escapeListner();
		canvas.setOnMouseClicked(e -> controller.startGame());
	}
	
	private void run(GraphicsContext gc) {
		setScene();
		controller.movePlayer1();
		controller.rivalPlay();
		updatePaddlePlayer1();
		updatePaddlePlayer2();
	}
}
