package com.PongElements;

import com.View.ViewManager;

public class Ball {
	private double startX, startY, x, y, radius;
	
	public Ball(int radius) {
		startX = ViewManager.INSTANCE.getMainStage().getX()/2;
		startY = ViewManager.INSTANCE.getMainStage().getY()/2;
		if(radius <= 0) radius = 10;
	}
}
