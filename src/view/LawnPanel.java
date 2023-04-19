package view;
import Model.Mower;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/*
* --This class is used to represent the lawn panel
* --This class has two methods --@setCellColor() and @paintComponent()
* --The @setCellColor() method is used to set the color of the cell
* --The @paintComponent() method is used to paint the component
* --The class uses --Graphics, JPanel, Color, Mower, and Arrays
* */

public class LawnPanel extends JPanel {
    private final Color[][] cellColors;

    Mower mower;
    Color myColor = new Color(88, 96, 4);

    public LawnPanel(Mower mower) {
        this.mower = mower;
        // Initialize all cell colors to green
        cellColors = new Color[Lawn.WIDTH][Lawn.HEIGHT];
        for (int i = 0; i < Lawn.WIDTH; i++) {
            Arrays.fill(cellColors[i], myColor);
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
                g.setColor(new Color(0, 214, 28));
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