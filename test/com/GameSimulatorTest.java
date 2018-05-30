/**
 * 
 */
package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.Controllers.GameController;
import com.Controllers.GameModel;

/**
 * @author wojtek
 *
 */
public class GameSimulatorTest {
	
	@Test
	public final void testDefaultHeight() {
		GameModel playerModel = new GameModel();
		assertEquals("Default values equlas default values", playerModel.getPlayer1Height(), playerModel.getDefaultPlayerHeight());
	}
	
	@Test
	public final void testDefaultWidth() {
		GameModel playerModel = new GameModel();
		assertEquals("Default values equlas default values", playerModel.getPlayer1Width(), playerModel.getDefaultPlayerWidth());
	}
	
	@Test
	public final void testDefaultBallRadius() {
		GameModel playerModel = new GameModel();
		assertEquals("Default values equlas default values", playerModel.getBallRadius(), playerModel.getDefaultBallRadius());
	}
	
	@Test
	public final void testPlayer1FirstTurn() {
		GameModel playerModel = new GameModel();
		GameController playerController = new GameController(playerModel);
		int tmp = (int)playerModel.getPlayer1Y();
		playerController.startGame();
		playerController.movePlayer1();
		assertEquals("Is the direction of player working", tmp == (int)playerModel.getPlayer1Y(), true);
	}
	
	@Test
	public final void testBallFirstTurn() {
		GameModel playerModel = new GameModel();
		GameController playerController = new GameController(playerModel);
		int tmp = (int)playerModel.getBallX();
		playerController.startGame();
		playerController.moveBall();
		assertEquals("Is the direction of ball working",  tmp != (int)playerModel.getBallX(), true);
	}
	

}
