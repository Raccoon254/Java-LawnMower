package Model;

import view.LawnMowerEmulator;

/*
* --This class is used to represent the sensor of the mower.
* --This class has four methods --@isAtRightEdge(), @isAtLeftEdge(), @isAtBottomEdge(), @attach()
* --The methods sense the location of the mower and notify the observers when the mower moves.
*/
public class Sensor {
    private LawnMowerEmulator observer;

    public boolean isAtRightEdge(int x, int y, int width) {
        if (x == width - 1) {
            observer.onMove(getCurrentMower());
            return true;
        }
        return false;
    }

    public boolean isAtLeftEdge(int x) {
        if (x == 0) {
            observer.onMove(getCurrentMower());
            return true;
        }
        return false;
    }

    public boolean isAtBottomEdge(int y, int height) {
        if (y == height - 1) {
            observer.onMove(getCurrentMower());
            return true;
        }
        return false;
    }

    public void attach(LawnMowerEmulator lawnMowerEmulator) {
        observer = lawnMowerEmulator;
    }

    private Mower getCurrentMower() {
        return observer.getMower();
    }
}
