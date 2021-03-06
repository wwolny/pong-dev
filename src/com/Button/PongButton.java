package com.Button;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;

public class PongButton  extends Button{
	private final String FONT_PATH = "resources/kenvector_future.ttf";
	private final String BUTTON_PRESSED_STYLE = "-fx-backgorund-color: transparent; -fx-background-image: url('resources/grey_button_pressed.png');";
	private final String BUTTON_FREE_STYLE = "-fx-backgorund-color: transparent; -fx-background-image: url('resources/grey_button.png');";
	
	public PongButton(String text, int fontSize) {
		setText(text);
		setButtonFont(fontSize);
		setPrefWidth(250);
		setPrefHeight(49);
		setStyle(BUTTON_FREE_STYLE);
		initializeButtonListners();
	}
	
	private void setButtonFont(int fontSize) {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), fontSize));
		} catch (FileNotFoundException e) {
			setFont(Font.font("Verdana", fontSize));
		}
	}
	
	private void setButtonPressedStyle() {
		setStyle(BUTTON_PRESSED_STYLE);
		setPrefHeight(45);
		setLayoutY(getLayoutY() + 4);
	}
	
	private void setButtonReleasedStyle() {
		setStyle(BUTTON_FREE_STYLE);
		setPrefHeight(49);
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

