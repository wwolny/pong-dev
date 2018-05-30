/**
 * 
 */
package com.Controllers;

import java.util.Random;

import com.ViewManager;
import com.Arkanoid.ObstaclesManager;

/**
 * @author wojtek
 *
 */
public class GameController {
	private final GameModel model;
	private ViewManager manager = ViewManager.INSTANCE;
	private ObstaclesManager obstaclesController;
	
	public GameController (GameModel model) {
		this.model = model;
		obstaclesController = new ObstaclesManager(model.getObstaclesModel(), this);
	}
	
	public void setObstacles() {
		model.setObstacles(true);
		obstaclesController.generateLimits();
	}
	
	
	public void setDefaultValues() {
		setDefaultPlayer1();
		setDefaultPlayer2();
		setDefaultBall();
		model.setObstacles(false);
	}
	
	public void setDefaultPlayer1() {
		model.setPlayer1Height(model.getDefaultPlayerHeight());
		model.setPlayer1Width(model.getDefaultPlayerWidth());
		model.setPlayer1Speed(model.getDefaultPlayerSpeed());
	}
	
	public void setDefaultPlayer2() {
		model.setPlayer2Height(model.getDefaultPlayerHeight());
		model.setPlayer2Width(model.getDefaultPlayerWidth());
		model.setPlayer2Speed(model.getDefaultPlayerSpeed());
		
	}
	
	public void setDefaultBall() {
		model.setBallSpeedX(model.getDefaultBallSpeedX());
		model.setBallSpeedY(model.getDefaultBallSpeedY());
		model.setBallRadius(model.getDefaultBallRadius());
	}
	
	public void changeSceneBackToMenu() {
		model.setGameStarted(false);
		model.setScoreP1(0);
		model.setScoreP2(0);
		setDefaultValues();
		model.setObstacles(false);
		manager.changeScene(manager.getMenu());
	}
	
	public void changePlayer1DirectionUp() {
		model.setPlayer1Direction(GameModel.getUp());
	}
	
	public void changePlayer1DirectionDown() {
		model.setPlayer1Direction(GameModel.getDown());
	}
	
	public void changePlayer2DirectionUp() {
		model.setPlayer2Direction(GameModel.getUp());
	}
	
	public void changePlayer2DirectionDown() {
		model.setPlayer2Direction(GameModel.getDown());
	}
	
	public void changePlayer2DirectionStay() {
		model.setPlayer2Direction(GameModel.getStay());
	}
	
	public void changePlayer1DirectionStay() {
		model.setPlayer1Direction(GameModel.getStay());
	}
	
	public void startGame() {
		if(!model.isGameStarted()) {
			model.setGameStarted(true);
			startBallPosition();
			setObstacles();
		}
	}
	
	public void movePlayer1() {
		if(model.getPlayer1Y() > 0 && model.getPlayer1Direction() >0) {
			model.setPlayer1Y(
					model.getPlayer1Y()
					-5*model.getPlayer1Speed()*model.getPlayer1Direction()
					);
		}
		else if(model.getPlayer1Y() < GameModel.getHeight() - model.getPlayer1Height() 
				&& model.getPlayer1Direction() < 0) {
			model.setPlayer1Y(
					model.getPlayer1Y()
					-5*model.getPlayer1Speed()*model.getPlayer1Direction()
					);
		}
	}
	
	
	public void movePlayer2() {
		if(model.getPlayer2Y() > 0 && model.getPlayer2Direction() >0) {
			model.setPlayer2Y(
					model.getPlayer2Y()
					-5*model.getPlayer2Speed()*model.getPlayer2Direction()
					);
		}
		else if(model.getPlayer2Y() < GameModel.getHeight() - model.getPlayer2Height() 
				&& model.getPlayer2Direction() < 0) {
			model.setPlayer2Y(
					model.getPlayer2Y()
					-5*model.getPlayer2Speed()*model.getPlayer2Direction()
					);
		}
	}
	
	public void moveBall() {
		if(model.isGameStarted()) {
			model.setBallX(model.getBallX()+model.getBallSpeedX());
			model.setBallY(model.getBallY()+model.getBallSpeedY());
			if(model.getBallY() + model.getBallRadius() > GameModel.HEIGHT || model.getBallY() < 0) 
				model.setBallSpeedY(-1*model.getBallSpeedY());
			if(model.getBallX() < model.getPlayer1X() - model.getPlayer1Width()) {
				model.setScoreP2(model.getScoreP2()+1);
				model.setGameStarted(false);
			}
			if(model.getBallX() > model.getPlayer2X() + model.getPlayer2Width()) {
				model.setScoreP1(model.getScoreP1()+1);
				model.setGameStarted(false);
			}
			if( ((model.getBallX() + model.getBallRadius() > model.getPlayer2X()) 
						&& model.getBallY() >= model.getPlayer2Y() 
						&& model.getBallY() <= model.getPlayer2Y() + model.getPlayer2Height()) 
						|| (model.getBallX() < model.getPlayer1X() + model.getPlayer1Width() 
						&& model.getBallY() >= model.getPlayer1Y()
						&& model.getBallY() <= model.getPlayer1Y() + model.getPlayer1Height())) {
							changeBallDirection();
			}
			obstaclesController.checkObstacles();
		}
	}
	
	public void changeBallDirection() {
		//model.setBallSpeedY(-1*(model.getBallSpeedY()+Math.signum(model.getBallSpeedY())));
		model.setBallSpeedX(-1*model.getBallSpeedX());//(model.getBallSpeedX()+ Math.signum(model.getBallSpeedX())));
	}
	
	public void startBallPosition() {
		model.setBallX(GameModel.WIDTH/2);
		model.setBallY(GameModel.HEIGHT/2);
		model.setBallSpeedX(new Random().nextInt(2) == 0 ? 1: -1);
		model.setBallSpeedY(new Random().nextInt(2) == 0 ? 1: -1);
		model.setObstacles(false);
	}
	
	public void setLevel1() {
		model.setLevel(1);
		model.setPlayer2Speed(0.5);
	}

	public void setLevel2() {
		model.setLevel(2);
		model.setPlayer2Speed(1);
	}
	
	public void rivalPlay() {
		if(model.getBallY() < model.getPlayer2Y()) {
			changePlayer2DirectionUp();
		}  else {
			changePlayer2DirectionDown();			
		}
		movePlayer2();
	}
	
	public double getBallX() {
		return model.getBallX();
	}
	
	public double getBallY() {
		return model.getBallY();
	}
	
	public int getBallRadius() {
		return model.getBallRadius();
	}
	
	public int getBallSpeedX() {
		return (int)model.getBallSpeedX();
	}
	
	public int getBallSpeedY() {
		return (int)model.getBallSpeedY();
	}

	/**
	 * @return the obstaclesController
	 */
	public ObstaclesManager getObstaclesController() {
		return obstaclesController;
	}
}
