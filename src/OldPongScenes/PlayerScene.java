/**
 * Pong application.
 */
package OldPongScenes;

import com.PongElements.Ball;
import com.PongElements.Paddle;
import com.Scens.PongScens;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * Scene for the Pong game Player vs. Player
 * @author wojtek
 *
 */
public class PlayerScene extends GameAbstractScene implements PongScens{	
	private static final int UP = 1;
	private static final int DOWN = -1;
	private static final int STAY = 0;
	private int direction1 = 0;
	private int direction2 = 0;
	/**
	 * Method constructing the screen.
	 * Needs to be called in the ViewManager.
	 * Meets Interface for all scenes.
	 */
	public int createScene() {
		player1 = new Paddle(1, WIDTH, HEIGHT);
		player2 = new Paddle(2, WIDTH, HEIGHT);
		ball = new Ball(10);
		canvas = new Canvas(WIDTH, HEIGHT);
		gc = canvas.getGraphicsContext2D();
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
		tl.setCycleCount(Timeline.INDEFINITE);
		
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.W) {
				direction1 = UP;
			}
		});
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.S) {
				direction1 = DOWN;
			}
		});
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.UP) {
				direction2 = UP;
			}
		});
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.DOWN) {
				direction2 = DOWN;
			}	
		});
		
		this.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			if(key.getCode() == KeyCode.S || key.getCode() == KeyCode.W) {
				direction1 = STAY;
			}	
		});
		
		this.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			if(key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.UP) {
				direction2 = STAY;
			}	
		});
		
		escapeListner();
		
		canvas.setOnMouseClicked(e ->  gameStarted = true);
		
		((StackPane)getRoot()).getChildren().add(canvas);
		tl.play();
		return 1;
	}
	
	/**
	 * Method creating the Scene.
	 * Scene created with Canvas and GraphicContext
	 * @param gc
	 */
	protected void run(GraphicsContext gc) {
		setScene();
		player1.move(direction1);
		player2.move(direction2);
		player1.update(gc);
		player2.update(gc);
	}
}