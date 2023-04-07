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
