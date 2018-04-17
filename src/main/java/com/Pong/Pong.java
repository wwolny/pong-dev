package com.Pong;

import com.View.ViewManager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Pong extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			ViewManager manager = new ViewManager();
			primaryStage = manager.getMainStage();
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
//	public void start(Stage primaryStage) throws Exception {
//		Button button = new Button("Przycisk");
//		button.setText("Say, Hello wOrld!");
//		button.setOnAction(new EventHandler<ActionEvent>() {
//			
//			public void handle(ActionEvent event) {
//				System.out.println("Hello World!");
//				
//			}
//		});
//		
//		StackPane stackPane = new StackPane();
//		stackPane.getChildren().add(button);
//		
//		Scene scene = new Scene(stackPane, 400, 600);
//		primaryStage.setTitle("Pierwsze okno");
//		primaryStage.setScene(scene);
//		primaryStage.show();
		
//		primaryStage.setWidth(200);
//		primaryStage.setHeight(200);
//		primaryStage.setResizable(false);
//		primaryStage.setFullScreen(true);
//		primaryStage.setX(0);
//		primaryStage.setY(0);
//		primaryStage.initStyle(StageStyle.UNDECORATED);
//		primaryStage.setOpacity(0.5);
}
