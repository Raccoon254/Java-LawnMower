package controller;
import view.*;
import Model.*;
import controller.*;
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
