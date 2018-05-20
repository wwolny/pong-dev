package com.Button;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ColorButton extends Button {
	
	public ColorButton(String color) {
		setColor(color);
		setPrefWidth(50);
		setPrefHeight(50);
		initializeButtonListners();
	}
	
	private void setColor(String color) {
		setStyle("-fx-background-color: " + color + "; -fx-border-color: white;");
	}
	
	private void setButtonPressedStyle() {
		setPrefHeight(50);
		setLayoutY(getLayoutY() + 4);
	}
	
	private void setButtonReleasedStyle() {
		setPrefHeight(50);
		setLayoutY(getLayoutY() - 4);
	}
	
	private void initializeButtonListners() {
		
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}
			}
		});
		
		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
				}
			}
		});
		
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(new DropShadow());
			}
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
			}
		});
	}
}
