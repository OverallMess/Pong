import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuScene implements Scene {

    String mainText = "Press enter to continue...";
    KeyListener kl;

    public MenuScene(KeyListener kl) {
        this.kl = kl;
    }

    @Override
    public void update(Graphics2D g2) {
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        g2.drawString(mainText, Constants.SCREEN_WIDTH / 6, Constants.SCREEN_HEIGHT / 2);
        if (kl.isKeyPressed(KeyEvent.VK_ENTER)) {
            Window.getWindow().changeScene(1);
        }        
    }
    
}
