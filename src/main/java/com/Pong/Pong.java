package com.Pong;

import com.View.ViewManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class Pong extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			ViewManager manager = ViewManager.INSTANCE;
			primaryStage = manager.getMainStage();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


