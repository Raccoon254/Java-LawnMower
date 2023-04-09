package view;
import view.*;
import Model.*;
import controller.*;
import view.*;
import Model.*;
import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LawnMowerEmulator extends JFrame implements MowerObserver {
    public LawnPanel lawnPanel;
    private Mower mower;

    public LawnMowerEmulator() {
        // Initialize mower
        Motor motor = new Motor();
        GrassCutter grassCutter = new GrassCutter();
        Sensor sensor = new Sensor();
        Lawn lawn = new Lawn();
        mower = new Mower(0, 0, Direction.EAST, motor, grassCutter, sensor,LawnMowerEmulator.this);
        mower.setState(mower.getEastState());
        mower.getSensor().attach(this);

        setTitle("Lawn Mower Emulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mower.start();
            }
        });


        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mower.stop();
            }
        });

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
