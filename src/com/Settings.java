/**
 * Pong application
 */
package com;

import javafx.scene.paint.Color;

/** 
 * Singleton containing information about current settings.
 * @author wojtek
 *
 */
public enum Settings {
	INSTANCE;
	
	ViewManager manager = ViewManager.INSTANCE;
	
	private final String labelsStyle = "-fx-font-style: normal; -fx-font-size: 23; -fx-background-color: white; fx-font-weight: 200;";
	private int fontSize = 23;
	private Color backgroundColor = Color.BLACK;

	/**
	 * @return the labelsStyle
	 */
	public String getLabelsStyle() {
		return labelsStyle;
	}

	
	/**
	 * @return the backgroundColor
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * @param backgroundColor the backgroundColor to set
	 */
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		manager.updateBackground();
	}

	/**
	 * @return get the font size
	 */
	public int getFontSize() {
		return fontSize;
	}
	
	/**
	 * @param newFontSize set font size
	 */
	public void setFontSize(int newFontSize) {
		if(newFontSize >0 && newFontSize < 30)
			fontSize = newFontSize;
	}
}
