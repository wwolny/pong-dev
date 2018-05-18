/**
 * Pong application.
 */
package com.PongElements;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Paddle object that can be created on left side of the Scene or the right side.
 * The side depends on the number provided while constructing the Paddle.
 * The number 1 set Paddle at the left side, and the number 2 set it on the right side.
 * @author wojtek
 *
 */
public class Paddle {
	//private int paddleNr;
	//private int score=0;
	private double x;
	private double y;
	private double width = 10;
	private double height = 100;
	private double startWidth;
	private double startHeight;
	
	/**
	 * Constructor of the Paddle.
	 * @param paddleNr 
	 * This parameter tells if it is right side paddle, or left side paddle.
	 * @param startWidth
	 * Gives information about the width of the Stage.
	 * @param startHeight
	 * Gives information about the height of the Stage.
	 */
	public Paddle(int paddleNr, int startWidth, int startHeight) {
		this.startHeight = startHeight;
		this.startWidth = startWidth;
		if(paddleNr == 1) {
			this.x = width;
		}
		else if (paddleNr == 2) {
			this.x = this.startWidth - width;
		}
		this.y = this.startHeight/2 - this.height/2;
	}
	
	/**
	 * Move paddle up.
	 */
	public void moveUp() {
		if(y > 0) {
			y -=5;
		}
	}
	
	/**
	 * Move paddle down.
	 */
	public void moveDown() {
		if(y < startHeight - height) {
			y +=5;
		}
	}
	
	/**
	 * Update paddle position.
	 * @param gc
	 */
	public void update(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(x, y, width, height);
	}
	
	/**
	 * @return x position
	 */
	public double getPosX() {
		return x;
	}
	
	/**
	 * @return y position
	 */
	public double getPosY() {
		return y;
	}
	
	/**
	 * @return width of paddle
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * @return height of paddle
	 */
	public double getHeight() {
		return height;
	}	
}
