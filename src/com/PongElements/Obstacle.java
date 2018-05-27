/**
 * Pong application
 */
package com.PongElements;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * View element that use Graphics Context to create obstacle at the Scene
 * @author wojtek
 *
 */
public class Obstacle {
	private double width = 50;
	private double height = 70;

	/**
	 * Constructor of the Obstacle.
	 */
	public Obstacle(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.YELLOW);
		gc.fillRect(x, y, width, height);
	}
	
	public Obstacle() {}
	
	public void update(GraphicsContext gc, int x, int y) {
		gc.setFill(Color.YELLOW);
		gc.fillRect(x, y, width, height);
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
