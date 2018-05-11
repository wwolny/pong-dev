package com.PongElements;

import static org.junit.Assert.fail;

import org.junit.Test;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle {
	
	private int paddleNr, score=0;
	private double x, y, width = 10, height = 100, startWidth, startHeight;
	
	public Paddle(int paddleNr, int startWidth, int startHeight) {
		this.startHeight = startHeight;
		this.startWidth = startWidth;
		if(paddleNr == 1) {
			this.x = width;
		}
		else if (paddleNr == 2) {
			this.x = startWidth - width;
		}
		this.y = startHeight/2 - this.height/2;
	}
	
	public void moveUp() {
		if(y > 0 &&
				y < startHeight) {
			y -=5;
		}
	}
	
	public void moveDown() {
		if(y > 0 &&
				y < startHeight) {
			y +=5;
		}
	}
	
	public void updatePaddle(GraphicsContext gc) {
		gc.setFill(Color.WHITE);
		gc.fillRect(x, y, width, height);
	}
	
	public double getPosX() {
		return x;
	}

	public double getPosY() {
		return y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	@Test
	public void TestPaddle() {
		Paddle pad1 = new Paddle(1, 500, 600);
		if(pad1.getHeight() != 590) {
			fail("Paddle");
		} 
		else if(pad1.getWidth() != 10) {
			fail("Paddle");
		}
		for(int i = 0; i <100; i++) {
			pad1.moveUp();
		}
	}
	
}
