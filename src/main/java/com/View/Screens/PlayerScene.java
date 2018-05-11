package com.View.Screens;

import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

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

public class PlayerScene extends Scene{
	private static final int width = 800;
	private static final int height = 600;
	
	Paddle player1;
	Paddle player2;
	
	private static final double ballRadius = 15;
	private static final boolean FALSE = false;
	private int ballYSpeed = 1;
	private int ballXSpeed = 1;
	private double ballXPos = width / 2;
	private double ballYPos = height / 2;
	private int scoreP1 = 0;
	private int scoreP2 = 0;
	private boolean gameStarted = FALSE;
	
	
	public PlayerScene() {
		super(new StackPane(), width, height);
	}
	
	public int createScene() {
		player1 = new Paddle(1, width, height);
		player2 = new Paddle(2, width, height);
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
			else if(key.getCode() == KeyCode.UP) {
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

	private void run(GraphicsContext gc) {
		createBackground(gc);
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		if(gameStarted) {
			ballXPos+=ballXSpeed;
			ballYPos+=ballYSpeed;
			
			gc.fillOval(ballXPos, ballYPos, ballRadius, ballRadius);
		} else {
			gc.setStroke(Color.YELLOW);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.strokeText("Click to Start", width / 2, height / 2);
			ballXPos = width / 2;
			ballYPos = height / 2;
			ballXSpeed = new Random().nextInt(2) == 0 ? 1: -1;
			ballYSpeed = new Random().nextInt(2) == 0 ? 1: -1;
		}
		if(ballYPos > height || ballYPos < 0) ballYSpeed *=-1;
		if(ballXPos < player1.getPosX() - player1.getWidth()) {
			scoreP2++;
			gameStarted = false;
		}
		if(ballXPos > player2.getPosX() + player2.getWidth()) {  
			scoreP1++;
			gameStarted = false;
		}
		if( ((ballXPos + ballRadius > player2.getPosX()) && ballYPos >= player2.getPosY() 
					&& ballYPos <= player2.getPosY() + player2.getHeight()) 
					|| ((ballXPos < player1.getPosX() + player1.getWidth()) 
					&& ballYPos >= player1.getPosY()
					&& ballYPos <= player1.getPosY() + player1.getHeight())) {
			ballYSpeed += 1 * Math.signum(ballYSpeed);
			ballXSpeed += 1 * Math.signum(ballXSpeed);
			ballXSpeed *= -1;
			ballYSpeed *= -1;
		}
		gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
		player1.updatePaddle(gc);
		player2.updatePaddle(gc);
	}
	
	
	private void createBackground(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
	}
	/*
	@Test
	public void TestPlayer() {
		PlayerScene player = new PlayerScene();
		if(player.createScene() != 1) {
			fail("PlayerScreen");
		} 
	}*/
		
}
