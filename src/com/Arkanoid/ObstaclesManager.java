/**
 * 
 */
package com.Arkanoid;

import com.Controllers.GameController;

/**
 * Controller for the MVC connected with creating obstacles
 * @author wojtek
 *
 */
public class ObstaclesManager {
	private final ObstaclesModel model;
	private final GameController gameController;
	
	public ObstaclesManager(ObstaclesModel model, GameController gameController) {
		this.model = model;
		this.gameController = gameController;
	}
	
	/**
	 * Method that must be called before drawing any Obstacle
	 * This method generates limits that make GraphicsContxt draw only within specified field
	 */
	public void generateLimits() {
		if(model.getObstaclesMapHeight()*(model.getPadding()+model.getObstacleHeight()) 
				< model.getObstaclesFieldHeight())
			model.setMaxObstaclesInColumn(model.getObstaclesMapHeight());
		else {
			for (int i = model.getObstaclesMapHeight(); i > 0; i--) {
				if(i*(model.getPadding()+model.getObstacleHeight()) 
						< model.getObstaclesFieldHeight()) {
					model.setMaxObstaclesInColumn(i);
					break;
				}
			}
		}
		
		if(model.getObstaclesMapWidth()*(model.getPadding()+model.getObstacleWidth()) 
				< model.getObstaclesFieldWidth())
			model.setMaxObstaclesInRow(model.getObstaclesMapWidth());
		else {
			for (int i = model.getObstaclesMapWidth(); i > 0; i--) {
				if(i*(model.getPadding()+model.getObstacleWidth()) 
						< model.getObstaclesFieldWidth()) {
					model.setMaxObstaclesInRow(i);
					break;
				}
			}
		}		
	}
	
	/**
	 * Calculates the starting point of the pointed Obstacle (Y)
	 * @param heigthId
	 * @return y for graphic context
	 */
	public int calculateY(int heigthId) {
		return model.getObstaclesFieldStartY()+model.getPadding()
			+heigthId*(model.getPadding()+model.getObstacleHeight());
	}
	
	/**
	 * Calculates the starting point of the pointed Obstacle (X)
	 * @param widthId
	 * @return x for graphic context
	 */
	public int calculateX(int widthId) {
		return model.getObstaclesFieldStartX()+model.getPadding()
			+widthId*(model.getPadding()+model.getObstacleWidth());
	}
	
	/**
	 * Check each obstacle if it should be deleted with expected action
	 */
	public void checkObstacles() {
		for(int i =0; i < model.getMaxObstaclesInColumn(); i++) {
			for(int j =0; j < model.getMaxObstaclesInRow(); j++) {
				if (model.getObstaclesMap()[i][j] == 1) {
					checkCollision(i,j);
				}
			}
		}
	}
	
	public void checkCollision(int heightId, int widthId) {
		if(gameController.getBallX()+gameController.getBallRadius() > calculateX(widthId) 
			&& gameController.getBallX() < calculateX(widthId)+model.getObstacleWidth()
			&& gameController.getBallY() > calculateY(heightId) 
			&& gameController.getBallY() < calculateY(widthId)+model.getObstacleHeight()) {
				gameController.changeBallDirection();
				destroyObstacle(heightId, widthId);
		}
	}
	
	public void destroyObstacle(int heightId, int widthId) {
		model.setObstacleZero(widthId, heightId);
	}
}
