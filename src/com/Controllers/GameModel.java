/**
 * Pong application
 */
package com.Controllers;

/**
 * 
 * @author wojtek
 *
 */
public class GameModel {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private static final int UP = 1;
	private static final int DOWN = -1;
	private static final int STAY = 0;

	protected int player1Width = 10;
	protected int player1Height = 100;
	protected double player1X = player1Width;
	protected double player1Y = HEIGHT/2 - player1Height/2;
	protected int player1Direction = STAY;
	protected double player1Speed = 1;

	protected int player2Width = 10;
	protected int player2Height= 100;
	protected double player2X = WIDTH - player2Width;
	protected double player2Y = HEIGHT/2 - player2Height/2;
	protected int player2Direction = STAY;
	protected double player2Speed = 1;
	
	protected double ballX = WIDTH/2;
	protected double ballY = HEIGHT/2;
	protected double ballSpeedX = 1;
	protected double ballSpeedY = 1;
	protected int ballRadius = 10;
	
	protected int scoreP1 = 0;
	protected int scoreP2 = 0;
	
	protected boolean gameStarted = false;

	
	
	/**
	 * @return the width
	 */
	public static int getWidth() {
		return WIDTH;
	}

	/**
	 * @return the height
	 */
	public static int getHeight() {
		return HEIGHT;
	}

	/**
	 * @return the up
	 */
	public static int getUp() {
		return UP;
	}

	/**
	 * @return the down
	 */
	public static int getDown() {
		return DOWN;
	}

	/**
	 * @return the stay
	 */
	public static int getStay() {
		return STAY;
	}

	/**
	 * @return the player1X
	 */
	public double getPlayer1X() {
		return player1X;
	}

	/**
	 * @param player1x the player1X to set
	 */
	public void setPlayer1X(double player1x) {
		player1X = player1x;
	}

	/**
	 * @return the player1Y
	 */
	public double getPlayer1Y() {
		return player1Y;
	}

	/**
	 * @param player1y the player1Y to set
	 */
	public void setPlayer1Y(double player1y) {
		player1Y = player1y;
	}

	/**
	 * @return the player1Width
	 */
	public int getPlayer1Width() {
		return player1Width;
	}

	/**
	 * @param player1Width the player1Width to set
	 */
	public void setPlayer1Width(int player1Width) {
		this.player1Width = player1Width;
	}

	/**
	 * @return the player1Height
	 */
	public int getPlayer1Height() {
		return player1Height;
	}

	/**
	 * @param player1Height the player1Height to set
	 */
	public void setPlayer1Height(int player1Height) {
		this.player1Height = player1Height;
	}

	/**
	 * @return the player1Direction
	 */
	public int getPlayer1Direction() {
		return player1Direction;
	}

	/**
	 * @param player1Direction the player1Direction to set
	 */
	public void setPlayer1Direction(int player1Direction) {
		this.player1Direction = player1Direction;
	}

	/**
	 * @return the player1Speed
	 */
	public double getPlayer1Speed() {
		return player1Speed;
	}

	/**
	 * @param player1Speed the player1Speed to set
	 */
	public void setPlayer1Speed(double player1Speed) {
		this.player1Speed = player1Speed;
	}

	/**
	 * @return the player2X
	 */
	public double getPlayer2X() {
		return player2X;
	}

	/**
	 * @param player2x the player2X to set
	 */
	public void setPlayer2X(double player2x) {
		player2X = player2x;
	}

	/**
	 * @return the player2Y
	 */
	public double getPlayer2Y() {
		return player2Y;
	}

	/**
	 * @param player2y the player2Y to set
	 */
	public void setPlayer2Y(double player2y) {
		player2Y = player2y;
	}

	/**
	 * @return the player2Width
	 */
	public int getPlayer2Width() {
		return player2Width;
	}

	/**
	 * @param player2Width the player2Width to set
	 */
	public void setPlayer2Width(int player2Width) {
		this.player2Width = player2Width;
	}

	/**
	 * @return the player2Height
	 */
	public int getPlayer2Height() {
		return player2Height;
	}

	/**
	 * @param player2Height the player2Height to set
	 */
	public void setPlayer2Height(int player2Height) {
		this.player2Height = player2Height;
	}

	/**
	 * @return the player2Speed
	 */
	public double getPlayer2Speed() {
		return player2Speed;
	}

	/**
	 * @param d the player2Speed to set
	 */
	public void setPlayer2Speed(double d) {
		this.player2Speed = d;
	}

	/**
	 * @return the player2Direction
	 */
	public int getPlayer2Direction() {
		return player2Direction;
	}

	/**
	 * @param player2Direction the player2Direction to set
	 */
	public void setPlayer2Direction(int player2Direction) {
		this.player2Direction = player2Direction;
	}

	/**
	 * @return the ballX
	 */
	public double getBallX() {
		return ballX;
	}

	/**
	 * @param ballX the ballX to set
	 */
	public void setBallX(double ballX) {
		this.ballX = ballX;
	}

	/**
	 * @return the ballY
	 */
	public double getBallY() {
		return ballY;
	}

	/**
	 * @param ballY the ballY to set
	 */
	public void setBallY(double ballY) {
		this.ballY = ballY;
	}

	/**
	 * @return the ballSpeedX
	 */
	public double getBallSpeedX() {
		return ballSpeedX;
	}

	/**
	 * @param ballSpeedX the ballSpeedX to set
	 */
	public void setBallSpeedX(double ballSpeedX) {
		this.ballSpeedX = ballSpeedX;
	}

	/**
	 * @return the ballSpeedY
	 */
	public double getBallSpeedY() {
		return ballSpeedY;
	}

	/**
	 * @param f the ballSpeedY to set
	 */
	public void setBallSpeedY(double f) {
		this.ballSpeedY = f;
	}

	/**
	 * @return the ballRadius
	 */
	public int getBallRadius() {
		return ballRadius;
	}

	/**
	 * @param ballRadius the ballRadius to set
	 */
	public void setBallRadius(int ballRadius) {
		this.ballRadius = ballRadius;
	}

	/**
	 * @return the scoreP1
	 */
	public int getScoreP1() {
		return scoreP1;
	}

	/**
	 * @param scoreP1 the scoreP1 to set
	 */
	public void setScoreP1(int scoreP1) {
		this.scoreP1 = scoreP1;
	}

	/**
	 * @return the scoreP2
	 */
	public int getScoreP2() {
		return scoreP2;
	}

	/**
	 * @param scoreP2 the scoreP2 to set
	 */
	public void setScoreP2(int scoreP2) {
		this.scoreP2 = scoreP2;
	}

	/**
	 * @return the gameStarted
	 */
	public boolean isGameStarted() {
		return gameStarted;
	}
	
	/**
	 * @param gameStarted the gameStarted to set
	 */
	public void setGameStarted(boolean gameStarted) {
		this.gameStarted = gameStarted;
	}
		
}
