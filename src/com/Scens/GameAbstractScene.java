/**
 * Pong application
 */
package com.Scens;

import com.PongElements.Ball;
import com.PongElements.Paddle;

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
 * Abstract class for all game scenes
 * @author wojtek
 *
 */
abstract class GameAbstractScene extends Scene implements PongScens {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	protected int scoreP1 = 0;
	protected int scoreP2 = 0;
	protected boolean gameStarted = false;
	
	protected Canvas canvas;
	protected GraphicsContext gc;
	protected Paddle player1;
	protected Paddle player2;
	protected Ball ball; 

	/**
	 * Constructor of Game Scene
	 */
	public GameAbstractScene() {
		super(new StackPane(), WIDTH, HEIGHT);
	}
	
	public abstract int createScene();
	protected abstract void run(GraphicsContext gc);
	
	protected void escapeListner() {
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.ESCAPE) {
				manager.changeScene(manager.getMenu());
				gameStarted = false;
				scoreP1 =0;
				scoreP2 = 0;
			}
		});
	}
	
	protected void setScene() {
		createBackground(gc);
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		if(gameStarted) {
			ball.update(gc);
		} else {
			gc.setStroke(Color.YELLOW);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.strokeText("Click to Start", WIDTH / 2, HEIGHT / 2);
			ball.start();
		}
		if(ball.getY() > HEIGHT || ball.getY() < 0) ball.setSpeedY(ball.getSpeedY()*-1);
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
		gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, WIDTH / 2, 100);
	}
	
	/**
	 * Method creating the background.
	 * @param gc
	 */
	protected void createBackground(GraphicsContext gc) {
		gc.setFill(sett.getBackgroundColor());
		gc.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	@Override
	public void updateBackground() {
		createBackground(gc);		
	}	
}
