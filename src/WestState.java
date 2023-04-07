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
