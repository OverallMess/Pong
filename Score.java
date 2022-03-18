import java.awt.Graphics2D;
import java.awt.*;

public class Score {
    public int p1Score = 0;
    public int p2Score = 0;

    private int xPos = Constants.SCREEN_WIDTH / 3 + 60;
    private int yPos = 100;

    public String summary = p1Score + " : " + p2Score;

    public void update(Graphics2D g2) {
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 64));
        g2.drawString(summary, xPos, yPos);
    }

    public void updateSummary() {
        summary = p1Score + " : " + p2Score;
    }

}
