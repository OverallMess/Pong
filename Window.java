import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {

    private boolean isRunning = false;

    private static Window window = null;

    private KeyListener kl = new KeyListener();

    Scene currentScene = new MenuScene(kl);

    private Window(int width, int height, String title) {
        this.setSize(width, height);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(kl);
        this.setVisible(true);
        isRunning = true;

    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, "Bong");
        }
        return Window.window;
    }

    private void update() {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        getGraphics().drawImage(dbImage, 0, 0, Color.CYAN, this);
    }

    private void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        this.currentScene.update(g2);

    }

    public void changeScene(int state) {
        switch (state) {
            case 0:
                currentScene = new MenuScene(kl);
                break;
            case 1:
                currentScene = new GameScene(kl);
                break;
            default:
                currentScene = null;
                System.err.println("Unknown Scene");
                break;
        }
    }

	@Override
	public void run() {
        while (isRunning) {
            this.update();
        }
	}
}