/**
 * Pong application
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
 * Scene that will allow to create Scenes for different levels
 * @author wojtek
 *
 */
public class CompGameScene extends GameAbstractScene implements PongScens {
	private static final int UP = 1;
	private static final int DOWN = -1;
	private static final int STAY = 0;
	private int level;
	private int direction = 0;
	/**
	 * Constructor with integer specifying the hardness of the level
	 * @param level
	 */
	public CompGameScene(int level) {
		super();
		this.level = level;
	}
	
	@Override
	public int createScene() {
		player1 = new Paddle(1, WIDTH, HEIGHT);
		player2 = new Paddle(2, WIDTH, HEIGHT);
		ball = new Ball(10);
		canvas = new Canvas(WIDTH, HEIGHT);
		gc = canvas.getGraphicsContext2D();
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
		tl.setCycleCount(Timeline.INDEFINITE);
		
		if(level == 1) {
			player2.setSpeed(0.5);
		} 
		else if(level == 2) {
			player2.setSpeed(1);
		}
		
		this.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if(key.getCode() == KeyCode.UP) {
				direction = UP;
			}
			else if(key.getCode() == KeyCode.DOWN) {
				direction = DOWN;
			}
		});
		this.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			if(key.getCode() == KeyCode.UP || key.getCode() == KeyCode.DOWN) {
				direction = STAY;
			}
		});
		
		escapeListner();
		
		canvas.setOnMouseClicked(e ->  gameStarted = true);
		
		((StackPane)getRoot()).getChildren().add(canvas);
		tl.play();
		return 1;
	}

	@Override
	protected void run(GraphicsContext gc) {
		setScene();
		player1.move(direction);
		rivalPlay();
		player1.update(gc);
	}
	
	private void rivalPlay() {
		if(ball.getY() < player2.getPosY()) {
			player2.move(UP);
		}  else {
			player2.move(DOWN);
		}
		player2.update(gc);
	}
}
