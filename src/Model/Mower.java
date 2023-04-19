
package Model;
import controller.*;
import view.LawnMowerEmulator;

/*
* --This class is used to represent the mower.
* --This class has 13 methods --@start(), @stop(), @moveLeft(), @moveRight(), @moveDown(), @getPositionX(), @getPositionY(),
* @setPositionX(), @setPositionY(), @getDirection(), @setDirection(), @getMotor(), @getGrassCutter(), @getSensor()
* --The method names are descriptive enough to explain what they do
*
*/
public class Mower {
    private int positionX;
    private int positionY;
    private Direction direction;
    private final Motor motor;
    private final GrassCutter grassCutter;
    private final Sensor sensor;
    private final MowerState eastState;
    private final MowerState westState;
    private final MowerState southeastState;
    private final MowerState southwestState;
    private MowerState currentState;
    boolean isRunning = false;
    private final LawnMowerEmulator lawnMowerEmulator;


    public Mower(int positionX, int positionY, Direction direction, Motor motor,
                 GrassCutter grassCutter, Sensor sensor,LawnMowerEmulator lawnMowerEmulator) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.motor = motor;
        this.grassCutter = grassCutter;
        this.sensor = sensor;
        this.eastState = new EastState();
        this.westState = new WestState();
        this.southeastState = new SoutheastState();
        this.southwestState = new SouthwestState();
        this.currentState = eastState;
        this.lawnMowerEmulator = lawnMowerEmulator;
    }

    public void setState(MowerState state) {
        this.currentState = state;
    }

    /*
    * --The method is used to start the mower --By using a thread
    * --The sleep method controls the speed of the mower
    */

    public void start() {
        motor.start();
        if (!isRunning) {
            isRunning = true;

            new Thread(() -> {
                while (isRunning) {
                    moveRight();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }).start();
        }
    }




    public void stop() {
        isRunning = false;
    }


    public void moveLeft() {
        currentState.execute(this, Direction.WEST);
    }

    public void moveRight() {
        currentState.execute(this, Direction.EAST);
        if (!sensor.isAtRightEdge(positionX, positionY, grassCutter.getWidth())) {
            lawnMowerEmulator.clearMower(positionX, positionY);
            lawnMowerEmulator.onMove(this);
        }
    }


    //Getters and Setters 👇
    public void moveDown() {
        currentState.execute(this, Direction.SOUTHWEST);
        currentState.execute(this, Direction.SOUTHEAST);
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Motor getMotor() {
        return motor;
    }

    public GrassCutter getGrassCutter() {
        return grassCutter;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public MowerState getEastState() {
        return eastState;
    }

    public MowerState getWestState() {
        return westState;
    }

    public MowerState getSoutheastState() {
        return southeastState;
    }

    public MowerState getSouthwestState() {
        return southwestState;
    }

    public LawnMowerEmulator getLawn() {
        return lawnMowerEmulator;
    }
}
