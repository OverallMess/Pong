import java.awt.Color;
import java.awt.Graphics2D;
public class Bat {
    private int width = 10;
    private int height = 150;
    private int yPos = Constants.SCREEN_HEIGHT / 2 - this.height / 2;
    private int speed = 1;

    private int xPos;

    public Bat(int xPos) {
        this.xPos = xPos;
    }

    private void draw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillRect(xPos, yPos, width, height);
    }

    public void update(Graphics2D g2) {
        this.draw(g2);
        if (isColliding()) {
            this.clamp();
        }
    }

    public void Move(int dir) {
        this.yPos += (this.speed * dir);
    }

    private boolean isColliding() {
        return this.yPos <= 30 || this.yPos + height >= Constants.SCREEN_HEIGHT;
    }

    public int getLeftEdge() {
        return this.xPos;
    }

    public int getRightEdge() {
        return this.xPos + width;
    }

    public int getTopEdge() {
        return this.yPos;
    }

    public int getBottomEdge() {
        return this.yPos + height;
    }
 
    private void clamp() {
        this.yPos = Math.min(Constants.SCREEN_HEIGHT - height, this.yPos);
        this.yPos = Math.max(30, this.yPos);
    }

}
