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
