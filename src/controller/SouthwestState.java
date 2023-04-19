package controller;

import Model.Direction;
import Model.Mower;
import view.Lawn;

/*
* --This class is used to execute the mower's state when it is in the southwest state --At the left edge.
* --This class implements the MowerState interface that has only one method --Execute
* --This class enables the mower move southwest by one unit and cut the grass adding one unit to the x and y values of the mower
* --This class also checks if the mower is at the bottom edge of the lawn and if it is, it stops the mower
* --This class also changes the mower's state to east and direction to east
*/
public class SouthwestState implements MowerState {
    @Override
    public void execute(Mower mower, Direction direction) {
        if (mower.getSensor().isAtBottomEdge(mower.getPositionY(), Lawn.HEIGHT)) {
            mower.stop();
        } else {
            mower.getGrassCutter().cut(mower);
            mower.setPositionY(mower.getPositionY() + 1);
            mower.setPositionX(mower.getPositionX() - 1);
            mower.setState(mower.getEastState());
            mower.setDirection(Direction.EAST);
            mower.moveRight();
        }
    }
}
