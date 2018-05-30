/**
 * 
 */
package com.Arkanoid;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * @author wojtek
 *
 */
public class ObstaclesView {
	private GraphicsContext gc;
	
	private ObstaclesModel model;
	private ObstaclesManager controller;
	
	public ObstaclesView(ObstaclesModel model, ObstaclesManager controller, GraphicsContext gc) {
		this.model = model;
		this.controller = controller;
		this.gc = gc;
	}
	
	public int createObstacles() {
		for(int i =0; i < model.getMaxObstaclesInColumn(); i++) {
			for(int j =0; j < model.getMaxObstaclesInRow(); j++) {
				if (model.getObstaclesMap()[i][j] == 1) {
					drawObstacle(i,j);
				}
			}
		}
		return 0;	
	}
	
	public void drawObstacle(int heightId, int widthId) {
		gc.setFill(Color.WHITE);
		gc.fillRect(controller.calculateX(widthId), controller.calculateY(heightId), model.getObstacleWidth(), model.getObstacleHeight());		
	}
	
}
