/**
 * Pong application.
 */
package com.Scens;

import com.PongElements.Ball;
import com.PongElements.Paddle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 * Scene for the Pong game Player vs. Player
 * @author wojtek
 *
 */
public class PlayerScene extends Scene implements PongScens{
	private static final int width = 800;
	private static final int height = 600;
	private int scoreP1 = 0;
	private int scoreP2 = 0;
	private boolean gameStarted = false;
	
	private Paddle player1;
	private Paddle player2;
	private Ball ball; 
	
	/**
	 * Constructor of Player  
	 */
	public PlayerScene() {
		super(new StackPane(), width, height);
	}
	
	/**
	 * Method constructing the screen.
	 * Needs to be called in the ViewManager.
	 * Meets Interface for all scenes.
	 */
	public int createScene() {
		player1 = new Paddle(1, width, height);
		player2 = new Paddle(2, width, height);
		ball = new Ball(10);
		Canvas canvas = new Canvas(width, height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
		tl.setCycleCount(Timeline.INDEFINITE);
		
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.W) {
				player1.moveUp();
			}
			else if(key.getCode() == KeyCode.S) {
				player1.moveDown();
			}
		});
		
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.UP) {
				player2.moveUp();
			}
			else if(key.getCode() == KeyCode.DOWN) {
				player2.moveDown();
			}
		});
		
		canvas.setOnMouseClicked(e ->  gameStarted = true);
		
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
		createBackground(gc);
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		if(gameStarted) {
			ball.update(gc);
		} else {
			gc.setStroke(Color.YELLOW);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.strokeText("Click to Start", width / 2, height / 2);
			ball.start();
		}
		if(ball.getY() > height || ball.getY() < 0) ball.setSpeedY(ball.getSpeedY()*-1);
		if(ball.getX() < player1.getPosX() - player1.getWidth()) {
			scoreP2++;
			gameStarted = false;
		}
		if(ball.getX() > player2.getPosX() + player2.getWidth()) {  
			scoreP1++;
			gameStarted = false;
		}
		if( ((ball.getX() + ball.getRadius() > player2.getPosX()) 
					&& ball.getY() >= player2.getPosY() 
					&& ball.getY() <= player2.getPosY() + player2.getHeight()) 
					|| ((ball.getX() < player1.getPosX() + player1.getWidth()) 
					&& ball.getY() >= player1.getPosY()
					&& ball.getY() <= player1.getPosY() + player1.getHeight())) {
			ball.setSpeedY(-1*(ball.getSpeedY()+ Math.signum(ball.getSpeedY())));
			ball.setSpeedX(-1*(ball.getSpeedX()+ Math.signum(ball.getSpeedX())));
		}
		gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
		player1.update(gc);
		player2.update(gc);
	}
	
	/**
	 * Method creating the background.
	 * @param gc
	 */
	private void createBackground(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
	}		
}