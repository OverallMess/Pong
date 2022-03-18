import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class GameScene implements Scene{

    KeyListener kl = null;
    Ball ball;
    Bat bat1;
    Bat bat2;
    Score score;

    public GameScene(KeyListener kl) {
        this.kl = kl;
        this.score = new Score();
        this.ball = new Ball();
        this.bat1 = new Bat(10);
        this.bat2 = new Bat(Constants.SCREEN_WIDTH - 20);
    }

    @Override
    public void update(Graphics2D g2) {
        ball.update(g2);
        
        checkBallGetOutOfBounds();

        checkBallHitWalls();

        checkKeyPress();

        checkLeftBatAndBall();

        checkRightBatAndBall();
        
        score.update(g2);
        bat1.update(g2);
        bat2.update(g2);
    }

    private void checkLeftBatAndBall() {
        if (ball.getLeftEdge() >= bat2.getRightEdge() &&
        ball.getTopEdge() <= bat2.getBottomEdge() &&
        ball.getBottomEdge() >= bat2.getTopEdge()
        ) {
            ball.rebound();
        }
    }

    private void checkRightBatAndBall() {
        if (ball.getLeftEdge() <= bat1.getRightEdge() &&
        ball.getTopEdge() <= bat1.getBottomEdge() &&
        ball.getBottomEdge() >= bat1.getTopEdge()
        ) {
            ball.rebound();
        }
    }

    private void checkBallHitWalls() {
        if (ball.getRightEdge() >= bat2.getLeftEdge() &&
        ball.getTopEdge() <= bat2.getBottomEdge() &&
        ball.getBottomEdge() >= bat2.getTopEdge()
        ) {
            ball.rebound();
        }
    }

    private void checkKeyPress() {
        if (kl.isKeyPressed(KeyEvent.VK_W)) {
            bat1.Move(-1);
        } else if (kl.isKeyPressed(KeyEvent.VK_S)) {
            bat1.Move(1);
        }

        if (kl.isKeyPressed(KeyEvent.VK_UP)) {
            bat2.Move(-1);
        } else if (kl.isKeyPressed(KeyEvent.VK_DOWN)) {
            bat2.Move(1);
        }
    }

    private void checkBallGetOutOfBounds() {
        if (ball.getLeftEdge() < 0) {
            ++score.p2Score;
            ball.reset();
            score.updateSummary();
        } else if (ball.getRightEdge() > Constants.SCREEN_WIDTH) {
            score.p1Score++;
            ball.reset();
            score.updateSummary();
        }
    }

}