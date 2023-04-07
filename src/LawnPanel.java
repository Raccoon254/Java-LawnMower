import javax.swing.*;
import java.awt.*;

public class LawnPanel extends JPanel {
    private Color[][] cellColors;

    Mower mower;
    public LawnPanel(Mower mower) {
        this.mower = mower;
        // Initialize all cell colors to green
        cellColors = new Color[Lawn.WIDTH][Lawn.HEIGHT];
        for (int i = 0; i < Lawn.WIDTH; i++) {
            for (int j = 0; j < Lawn.HEIGHT; j++) {
                cellColors[i][j] = Color.GREEN;
            }
        }
    }


    public void setCellColor(int row, int col, Color color) {
        if (cellColors != null && row >= 0 && row < Lawn.HEIGHT && col >= 0 && col < Lawn.WIDTH) {
            cellColors[row][col] = color;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw lawn grid
        int cellWidth = getWidth() / Lawn.WIDTH;
        int cellHeight = getHeight() / Lawn.HEIGHT;

        for (int i = 0; i < Lawn.WIDTH; i++) {
            for (int j = 0; j < Lawn.HEIGHT; j++) {
                int x = i * cellWidth;
                int y = j * cellHeight;
                g.setColor(cellColors[i][j]);
                g.fillRect(x, y, cellWidth, cellHeight);
                g.setColor(Color.GRAY);
                g.drawRect(x, y, cellWidth, cellHeight);
            }
        }

        // Draw mower
        g.setColor(Color.BLUE);
        int mowerX = mower.getPositionX() * cellWidth;
        int mowerY = mower.getPositionY() * cellHeight;
        g.fillRect(mowerX, mowerY, cellWidth, cellHeight);
    }
}