public class SoutheastState implements MowerState {
    @Override
    public void execute(Mower mower, Direction direction) {
        if (mower.getSensor().isAtBottomEdge(mower.getPositionY(), Lawn.HEIGHT)) {
            mower.stop();
        } else {
            mower.getGrassCutter().cut(mower);
            mower.setPositionY(mower.getPositionY() + 1);
            mower.setPositionX(mower.getPositionX() + 1);
            mower.setState(mower.getWestState());
            mower.setDirection(Direction.WEST);
            mower.moveLeft();
        }
    }
}
