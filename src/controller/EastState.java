package controller;

import Model.Direction;
import Model.Mower;
import view.Lawn;
/*
* This is the east state of the mower -- Responsible for moving the mower east
* and cutting the grass
*
* --This is a concrete state class
* --This class implements the MowerState interface that has only one method --Execute
* --This class enables the mower move east by one unit and cut the grass adding one unit to the x value of the mower
* --This class also checks if the mower is at the right edge of the lawn and if it is, it changes the state to southeast
* --This class also checks if the mower is at the bottom edge of the lawn and if it is, it stops the mower
* --This class also calls the cut method of the grass cutter class to cut the grass
*/

public class EastState implements MowerState {
    @Override
    public void execute(Mower mower, Direction direction) {
        if (mower.getSensor().isAtRightEdge(mower.getPositionX(), mower.getPositionY(), Lawn.WIDTH)) {
            mower.setState(mower.getSoutheastState());
            mower.moveDown();
        } else {
            mower.getGrassCutter().cut(mower);
            mower.setPositionX(mower.getPositionX() + 1);
        }
    }
}
