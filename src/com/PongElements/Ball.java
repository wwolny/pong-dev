/**
 * Pong application.
 */
package com.PongElements;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Ball object that can be used in Pong Game.
 * The ViewManager needed.
 * @author wojtek
 *
 */
public class Ball {
	private double posX;
	private double posY;
	private double radius;
	
	public Ball(double x, double y, double radius) {
		posX = x;
		posY = y;
		if(radius <= 0) this.radius = 10;
		else this.radius = radius;
	}
	
	public void setPos(double x, double y) {
		this.posX = x;
		this.posY = y;
	}
	
	public void render(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillOval(posX, posY, radius, radius);
	}
	
	public Rectangle2D getBoundry() {
		return new Rectangle2D(posX, posY, radius, radius);
	}
	
	public boolean collision(Obstacle obst) {
		return obst.getBoundry().intersects(this.getBoundry());
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		if(radius > 0)
			this.radius = radius;
	}
}
