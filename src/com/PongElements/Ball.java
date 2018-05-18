/**
 * Pong application.
 */
package com.PongElements;

import java.util.Random;

import com.ViewManager;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Ball object that can be used in Pong Game.
 * The ViewManager needed.
 * @author wojtek
 *
 */
public class Ball {
	private double startX;
	private double startY;
	private double x;
	private double y;
	private double speedX;
	private double speedY;
	private double radius;
	private ViewManager manager = ViewManager.INSTANCE;
	
	public Ball(double rad) {
		startX = manager.getMainStageX()/2;
		startY = manager.getMainStageY()/2;
		x = startX;
		y = startY;
		if(rad <= 0) radius = 10;
		else radius = rad;
	}
	
	public void update(GraphicsContext gc) {
		x+=speedX;
		y+=speedY;
		gc.setFill(Color.WHITE);
		gc.fillOval(x, y, radius, radius);
	}
	
	public void start() {
		x = manager.getMainStageX()/ 2;
		y = manager.getMainStageY()/ 2;
		speedX = new Random().nextInt(2) == 0 ? 1: -1;
		speedY = new Random().nextInt(2) == 0 ? 1: -1;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		if(x >= 0 && x < startX)
			this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		if(y >= 0 && y < startY)
			this.y = y;
	}

	/**
	 * @return the speedX
	 */
	public double getSpeedX() {
		return speedX;
	}

	/**
	 * @param speedX the speedX to set
	 */
	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	/**
	 * @return the speedY
	 */
	public double getSpeedY() {
		return speedY;
	}

	/**
	 * @param speedY the speedY to set
	 */
	public void setSpeedY(double speedY) {
		this.speedY = speedY;
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
