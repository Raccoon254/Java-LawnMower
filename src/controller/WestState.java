package controller;

import Model.Direction;
import Model.Mower;

/*
* --This class is used to execute the mower's state when it is facing west.
* --This class implements the MowerState interface that has only one method --Execute
* --This class enables the mower move west by one unit and cut the grass by adding one unit to the x value of the mower
* --This class also checks if the mower is at the left edge of the lawn and if it is, it changes the state to southwest
* --This class also calls the cut method of the grass cutter class to cut the grass
*/
public class WestState implements MowerState {
    @Override
    public void execute(Mower mower, Direction direction) {
        if (mower.getSensor().isAtLeftEdge(mower.getPositionX())) {
            mower.setState(mower.getSouthwestState());
            mower.moveDown();
        } else {
            mower.getGrassCutter().cut(mower);
            mower.setPositionX(mower.getPositionX() - 1);
        }
    }
}
