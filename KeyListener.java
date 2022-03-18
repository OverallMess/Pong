import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
    private final boolean[] keyPressed = new boolean[128];

    @Override
    public void keyPressed(KeyEvent event) {
        keyPressed[event.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent event) {
        keyPressed[event.getKeyCode()] = false;
    }

    public boolean isKeyPressed(int keyCode) {
        return keyPressed[keyCode];
    }

}
