/**
 * Pong application.
 */
package com.Scens;

import java.util.ArrayList;
import java.util.List;

import com.Button.PongButton;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Scene to choose the level of the game against computer or to see previous records.
 * @author wojtek
 *
 */
public class CompChooseScene extends Scene implements PongScens{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private static final int MAXROWS = 5;
	private int nxtRow = -1; 

	private Canvas canvas;
	private GraphicsContext gc;
	private VBox vbBtns;
	
	List<PongButton> compConfBtns;
	
	/**
	 * Constructor for the scene
	 */
	public CompChooseScene() {
		super(new GridPane(), WIDTH, HEIGHT);
		compConfBtns = new ArrayList<PongButton>();
		canvas = new Canvas(WIDTH, HEIGHT);
		vbBtns = new VBox();
	}
	
	/**
	 * Method that constructs the scene.
	 */
	public int createScene() {
		((GridPane)getRoot()).setAlignment(Pos.CENTER);
		((GridPane)getRoot()).setHgap(10);
		((GridPane)getRoot()).setVgap(12);
		gc = canvas.getGraphicsContext2D();
		createBackground(gc);
		((GridPane)getRoot()).getChildren().add(canvas);
		vbBtns.setAlignment(Pos.CENTER);
		vbBtns.setSpacing(50);
		vbBtns.setPadding(new Insets(0, 20, 10, 20));
		createButtons();
		return 0;
	}
	
	private void addCompConfButton(PongButton btn) {
		if(nxtRow < MAXROWS) {
			nxtRow++;
			compConfBtns.add(btn);
		}
	}	
	
	private void createButtons() {
		createLevel1Button();
		createLevel2Button();
		createStatsButton();
		createBackButton();
		for(int i = 0; i < compConfBtns.size(); i++) {
			vbBtns.getChildren().add(compConfBtns.get(i));
		}
		((GridPane)getRoot()).add(vbBtns, 0, 0);
	}
	
	private void createLevel1Button() {
		PongButton Level1Btn = new PongButton("Level 1", sett.getFontSize());
		addCompConfButton(Level1Btn);
		Level1Btn.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				manager.changeScene(manager.getLevel1());
			}
		});
	}
	
	private void createLevel2Button() {
		PongButton Level2Btn = new PongButton("Level 2", sett.getFontSize());
		addCompConfButton(Level2Btn);
		Level2Btn.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				manager.changeScene(manager.getLevel2());
			}
		});
	}
	
	private void createStatsButton() {
		PongButton StatsBtn = new PongButton("Statistics", sett.getFontSize());
		addCompConfButton(StatsBtn);	
	}
	
	private void createBackButton() {
		PongButton BackBtn = new PongButton("Back", sett.getFontSize());
		addCompConfButton(BackBtn);
		BackBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				manager.changeScene(manager.getMenu());
			}
		});
	}
	
	private void createBackground(GraphicsContext gc) {
		gc.setFill(sett.getBackgroundColor());
		gc.fillRect(0, 0, WIDTH, HEIGHT);
	}

	@Override
	public void updateBackground() {
		createBackground(gc);		
	}
}
