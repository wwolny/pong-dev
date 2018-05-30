/**
 * 
 */
package com.Arkanoid;

/**
 * @author wojtek
 *
 */
public class ObstaclesModel {
	private final int obstaclesMapWidth = 5;
	private final int obstaclesMapHeight = 5;
	private int obstaclesMap[][];
	
	private int obstaclesFieldStartX;
	private int obstaclesFieldStartY;
	private int obstaclesFieldWidth;
	private int obstaclesFieldHeight;
	
	private final int defaultPadding = 50;
	private final int defaultObstacleWidth = 40;
	private final int defaultObstacleHeight = 100;
	
	private int padding = defaultPadding;
	private int obstacleWidth = defaultObstacleWidth;
	private int obstacleHeight = defaultObstacleHeight;
	
	private int maxObstaclesInRow = 0;
	private int maxObstaclesInColumn = 0;
	
	
	/**
	 * Constructor of the Model class
	 * Takes starting values for the graphics context
	 * 
	 * Starting X, Y and width and height of the field to write on
	 */
	public ObstaclesModel(int fieldStartX, int fieldStartY, int fieldWidth, int fieldHeight) {
		this.obstaclesFieldStartX = fieldStartX;
		this.obstaclesFieldStartY = fieldStartY;
		this.obstaclesFieldWidth = fieldWidth;
		this.obstaclesFieldHeight = fieldHeight;
		obstaclesMap = new int[obstaclesMapHeight][obstaclesMapWidth];
		for(int i = 0; i < obstaclesMapHeight; i++) {
			for (int j = 0; j < obstaclesMapWidth; j++) {
				if(Math.random() > 0.5)
					obstaclesMap[i][j] = 1;
				else 
					obstaclesMap[i][j] = 0;
				//obstaclesMap[i][j] = (int)((Math.random()+0.5)%1);
			}
		}
	}
		
	
	/**
	 * @return the obstaclesMap
	 */
	public int[][] getObstaclesMap() {
		return obstaclesMap;
	}
	
	public void  setObstacleZero(int widthId, int heightId) {
		obstaclesMap[heightId][widthId] = 0;
	}
	
	/**
	 * @param obstaclesMap the obstaclesMap to set
	 */
	public void setObstaclesMap(int[][] obstaclesMap) {
		this.obstaclesMap = obstaclesMap;
	}
	/**
	 * @return the obstaclesMapWidth
	 */
	public int getObstaclesMapWidth() {
		return obstaclesMapWidth;
	}
	
	/**
	 * @return the obstaclesMapHeight
	 */
	public int getObstaclesMapHeight() {
		return obstaclesMapHeight;
	}
	/**
	 * @return the obstaclesFieldStartX
	 */
	public int getObstaclesFieldStartX() {
		return obstaclesFieldStartX;
	}
	/**
	 * @param obstaclesFieldStartX the obstaclesFieldStartX to set
	 */
	public void setObstaclesFieldStartX(int obstaclesFieldStartX) {
		this.obstaclesFieldStartX = obstaclesFieldStartX;
	}
	/**
	 * @return the obstaclesFieldStartY
	 */
	public int getObstaclesFieldStartY() {
		return obstaclesFieldStartY;
	}
	/**
	 * @param obstaclesFieldStartY the obstaclesFieldStartY to set
	 */
	public void setObstaclesFieldStartY(int obstaclesFieldStartY) {
		this.obstaclesFieldStartY = obstaclesFieldStartY;
	}
	/**
	 * @return the obstaclesFieldWidth
	 */
	public int getObstaclesFieldWidth() {
		return obstaclesFieldWidth;
	}
	/**
	 * @param obstaclesFieldWidth the obstaclesFieldWidth to set
	 */
	public void setObstaclesFieldWidth(int obstaclesFieldWidth) {
		this.obstaclesFieldWidth = obstaclesFieldWidth;
	}
	/**
	 * @return the obstaclesFieldHeight
	 */
	public int getObstaclesFieldHeight() {
		return obstaclesFieldHeight;
	}
	/**
	 * @param obstaclesFieldHeight the obstaclesFieldHeight to set
	 */
	public void setObstaclesFieldHeight(int obstaclesFieldHeight) {
		this.obstaclesFieldHeight = obstaclesFieldHeight;
	}
	/**
	 * @return the obstacleWidth
	 */
	public int getObstacleWidth() {
		return obstacleWidth;
	}
	/**
	 * @param obstacleWidth the obstacleWidth to set
	 */
	public void setObstacleWidth(int obstacleWidth) {
		this.obstacleWidth = obstacleWidth;
	}
	/**
	 * @return the obstacleHeight
	 */
	public int getObstacleHeight() {
		return obstacleHeight;
	}
	/**
	 * @param obstacleHeight the obstacleHeight to set
	 */
	public void setObstacleHeight(int obstacleHeight) {
		this.obstacleHeight = obstacleHeight;
	}

	/**
	 * @return the padding
	 */
	public int getPadding() {
		return padding;
	}

	/**
	 * @param padding the padding to set
	 */
	public void setPadding(int padding) {
		this.padding = padding;
	}

	/**
	 * @return the maxObstaclesInRow
	 */
	public int getMaxObstaclesInRow() {
		return maxObstaclesInRow;
	}

	/**
	 * @param maxObstaclesInRow the maxObstaclesInRow to set
	 */
	public void setMaxObstaclesInRow(int maxObstaclesInRow) {
		this.maxObstaclesInRow = maxObstaclesInRow;
	}

	/**
	 * @return the maxObstaclesInColumn
	 */
	public int getMaxObstaclesInColumn() {
		return maxObstaclesInColumn;
	}

	/**
	 * @param maxObstaclesInColumn the maxObstaclesInColumn to set
	 */
	public void setMaxObstaclesInColumn(int maxObstaclesInColumn) {
		this.maxObstaclesInColumn = maxObstaclesInColumn;
	}
	
	
}
