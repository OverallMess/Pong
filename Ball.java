import java.awt.*;

public class Ball {
    private int xPos;
    private int yPos;
    private int width = 30;
    private int height = 30;

    private int speed = 3;
    
    public Ball() {
        this.CenterXPos();
        this.CenterYPos();
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillArc(xPos, yPos, width, height, 0, 360);
    }

    public void update(Graphics2D g2) {
        this.draw(g2);
        xPos += speed;
        if (isCollidingWithWall()) {
            speed = -speed;
        }
    }

    private boolean isCollidingWithWall() {
        return getXPos() + width >= Constants.SCREEN_WIDTH || getXPos() <= 0;
    }

    public int getXPos() {
        return this.xPos;
    }
    public int getYPos() {
        return this.yPos;
    }

    private void CenterXPos() {
       this.xPos = Constants.SCREEN_WIDTH / 2 - this.width / 2;
    }

    private void CenterYPos() {
        this.yPos = Constants.SCREEN_HEIGHT / 2 - this.height /2;
    }

}
