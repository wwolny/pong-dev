/**
 * 
 */
package com;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Arkanoid.ObstaclesManager;
import com.Arkanoid.ObstaclesModel;
import com.Controllers.GameController;
import com.Controllers.GameModel;

/**
 * @author wojtek
 *
 */
public class ArkanoidTest {

	@Test
	public final void testObstacles() {
		GameModel playerModel = new GameModel();
		GameController playerController = new GameController(playerModel);
		ObstaclesManager manager = playerController.getObstaclesController();
		ObstaclesModel model = playerModel.getObstaclesModel();
		playerController.startGame();
		assertEquals("Is calculated limit x under max value of field width", manager.calculateX(model.getMaxObstaclesInRow()-1) < model.getObstaclesFieldStartX()+model.getObstaclesFieldWidth(), true);
		assertEquals("Is calculated limit x over min value of field width", manager.calculateX(model.getMaxObstaclesInRow()-1) > model.getObstaclesFieldStartX(), true);
		assertEquals("Is calculated limit y under max value of field height", manager.calculateY(model.getMaxObstaclesInColumn()-1) < model.getObstaclesFieldStartY()+model.getObstaclesFieldHeight(), true);
		assertEquals("Is calculated limit y over min value of field height", manager.calculateY(model.getMaxObstaclesInColumn()-1) > model.getObstaclesFieldStartX(), true);
	}

}
