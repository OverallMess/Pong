import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class GameScene implements Scene{

    KeyListener kl = null;
    Ball ball;
    Bat bat1;
    Bat bat2;

    public GameScene(KeyListener kl) {
        this.kl = kl;
        this.ball = new Ball();
        this.bat1 = new Bat(10);
        this.bat2 = new Bat(Constants.SCREEN_WIDTH - 20);
    }

    @Override
    public void update(Graphics2D g2) {
        ball.update(g2);
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

        bat1.update(g2);
        bat2.update(g2);
    }
}