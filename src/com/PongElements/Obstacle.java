/**
 * Pong applications
 */
package com.PongElements;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * View element that use Graphics Context to create obstacle at the Scene
 * @author wojtek
 *
 */
public class Obstacle {
	private double posX;
	private double posY;
	private double width;
	private double height;

	/**
	 * Constructor of the Obstacle.
	 */
	public Obstacle(double x, double y, double width, double height) {
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
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}	
}
