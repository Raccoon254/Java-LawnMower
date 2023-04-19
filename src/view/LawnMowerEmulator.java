package view;
import Model.*;
import controller.MowerObserver;
import javax.swing.*;
import java.awt.*;

/*
* --This class is used to represent the lawn mower emulator --Which is the main class of the application
* --This class has two methods --@main() and @onMove()
* --The @main() method is used to start the application
* --The @onMove() method is used to notify the observers when the mower moves
* --This class has two fields --@lawnPanel and @mower
* --The @lawnPanel field is used to represent the lawn panel
* --The @mower field is used to represent the mower
* --This class has one constructor --@LawnMowerEmulator()
* --This class implements the @MowerObserver interface
* */

public class LawnMowerEmulator extends JFrame implements MowerObserver {
    public LawnPanel lawnPanel;
    private final Mower mower;

    public LawnMowerEmulator() {
        // Initialize mower
        Motor motor = new Motor();
        GrassCutter grassCutter = new GrassCutter();
        Sensor sensor = new Sensor();
        mower = new Mower(0, 0, Direction.EAST, motor, grassCutter, sensor,LawnMowerEmulator.this);
        mower.setState(mower.getEastState());
        mower.getSensor().attach(this);

        setTitle("Lawn Mower Emulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        startButton.addActionListener(e -> mower.start());


        stopButton.addActionListener(e -> mower.stop());

        controlPanel.add(startButton);
        controlPanel.add(stopButton);

        lawnPanel = new LawnPanel(mower);

        add(controlPanel, BorderLayout.NORTH);
        add(lawnPanel, BorderLayout.CENTER);

        setSize(800, 600); // set the size of the window

        setLocationRelativeTo(null);
        setVisible(true);

        //mower = new Mower(0, 0, Direction.EAST, motor, grassCutter, sensor);
        mower.setState(mower.getEastState());
        mower.getSensor().attach(this);
    }


    @Override
    public void onMove(Mower mower) {
        lawnPanel.repaint();
    }

    public Mower getMower() {
        return mower;
    }

    public void clearMower(int positionX, int positionY) {
        mower.setPositionX(positionX);
        mower.setPositionY(positionY);
    }



    public static void main(String[] args) {
        new LawnMowerEmulator();
    }
}
