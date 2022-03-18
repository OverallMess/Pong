import java.awt.*;

public class Ball {
    private int xPos;
    private int yPos;
    private int width = 30;
    private int height = 30;

    private int xSpeed = 1;
    private int ySpeed = 1;
    
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
        xPos += xSpeed;
        yPos += ySpeed;
        if (isCollidingWithWall()) {
            ySpeed = -ySpeed;
        }
    }

    public void reset() {
        this.CenterXPos();
        this.CenterYPos();
    }

    public int getTopEdge() {
        return this.yPos;
    }

    public int getBottomEdge() {
        return this.yPos + height;
    }

    public int getRightEdge() {
        return this.xPos + width;
    }

    public int getLeftEdge() {
        return this.xPos;
    }

    private boolean isCollidingWithWall() {
        return this.yPos <= 30 || this.yPos + height >= Constants.SCREEN_HEIGHT;
    }

    public void rebound() {
        this.xSpeed = -this.xSpeed;
    }

    private void CenterXPos() {
       this.xPos = Constants.SCREEN_WIDTH / 2 - this.width / 2;
    }

    private void CenterYPos() {
        this.yPos = Constants.SCREEN_HEIGHT / 2 - this.height /2;
    }

}
