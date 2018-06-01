/**
 * Pong application.
 */
package com.PongElements;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Paddle object.
 * @author wojtek
 *
 */
public class Paddle {
	private double posX;
	private double posY;
	private double width;
	private double height;

	/**
	 * Constructor of the Paddle.
	 */
	public Paddle(double x, double y, double width, double height) {
		this.posX = x;
		this.posY = y;
		this.width = width;
		this.height = height;		
	}
		
	public void setPos(double x, double y) {
		this.posX = x;
		this.posY = y;
	}
		
	public void render(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(posX, posY, width, height);
	}
		
	public Rectangle2D getBoundry() {
		return new Rectangle2D(posX, posY, width, height);
	}
		
	public boolean collision(Obstacle obst) {
		return obst.getBoundry().intersects(this.getBoundry());
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
