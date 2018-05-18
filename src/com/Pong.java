/**
 * Pong
 * The Pong game application.
 */
package com;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Here starts the application.
 * 
 * @author wojtek
 * @version 0.0.0
 *
 */
public class Pong extends Application {
	private Stage mainStage;
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	/**
	 * Starting point of the application.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			ViewManager manager = ViewManager.INSTANCE;
			mainStage = new Stage();
			manager.setManager(mainStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


