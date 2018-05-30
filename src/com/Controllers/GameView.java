/**
 * Pong Application
 */
package com.Controllers;

import com.Settings;
import com.ViewManager;
import com.Arkanoid.ObstaclesView;
import com.Scens.PongScens;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * @author wojtek
 *
 */
abstract class GameView extends Scene implements PongScens {
	protected Canvas canvas;
	protected GraphicsContext gc;
	
	protected GameModel model;
	protected GameController controller;
	private ObstaclesView obstaclesView;
	
	protected Settings sett = Settings.INSTANCE;
	protected ViewManager manager = ViewManager.INSTANCE;
	
	public GameView(GameModel model, GameController controller) {
		super(new StackPane(), GameModel.WIDTH, GameModel.HEIGHT);
		this.model = model;
		this.controller = controller;
		canvas = new Canvas(GameModel.WIDTH, GameModel.HEIGHT);
		gc = canvas.getGraphicsContext2D();
		obstaclesView = new ObstaclesView(this.model.getObstaclesModel(), this.controller.getObstaclesController(), gc);	
	}
	
	public abstract int createScene();
	
	protected void setScene() {
		createBackground(gc);
		if(model.getScoreP1() == model.getPlayToScore() || model.getScoreP2() == model.getPlayToScore()) {
			endGame();
			model.setGameStarted(false);
		}
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		if(model.isGameStarted()) {
			model.getBall().render(gc);
			//updateBall();
			if(model.isObstacles()) {
				obstaclesView.createObstacles();
			}
		} else {
			gc.setStroke(Color.YELLOW);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.strokeText("Click to Start", GameModel.WIDTH / 2, GameModel.HEIGHT / 2);
			controller.startBallPosition();
		}
		controller.moveBall();
		gc.fillText(model.getScoreP1() + "\t\t\t\t\t\t\t\t" + model.getScoreP2(), GameModel.WIDTH / 2, 100);
	}
	
	protected void escapeListner() {
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.ESCAPE) { controller.changeSceneBackToMenu();}
		});
	}
	

	/**
	 * Draw Paddle 1
	 */
	public void updatePaddlePlayer1() {
		gc.setFill(Color.WHITE);
		gc.fillRect(model.getPlayer1X(), model.getPlayer1Y(), model.getPlayer1Width(), model.getPlayer1Height());
	}
	
	/**
	 * Draw Paddle 2
	 */
	public void updatePaddlePlayer2() {
		gc.setFill(Color.WHITE);
		gc.fillRect(model.getPlayer2X(), model.getPlayer2Y(), model.getPlayer2Width(), model.getPlayer2Height());
	}
	
	/**
	 * Draw ball
	 */
	protected void updateBall() {
		gc.setFill(Color.WHITE);
		gc.fillOval(model.getBallX(), model.getBallY(), 
						model.getBallRadius(), model.getBallRadius());
	}
	
	protected void endGame() {
		manager.openPopUpWindow("\tGAME OVER \n Player1: "+model.getScoreP1()+"\tPlayer2: "+model.getScoreP2());
	}
	
	
	/**
	 * Method creating the background.
	 * @param gc
	 */
	protected void createBackground(GraphicsContext gc) {
		gc.setFill(sett.getBackgroundColor());
		gc.fillRect(0, 0, GameModel.WIDTH, GameModel.HEIGHT);
	}
	
	/**
	 * Method implemented by PongScene
	 * Updates Background color
	 */
	@Override
	public void updateBackground() {
		createBackground(gc);		
	}
}
