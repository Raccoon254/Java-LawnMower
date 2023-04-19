package controller;
import Model.Direction;
import Model.Mower;

/*
* --This interface is used to execute the mower's state.
*  --This interface has only one method --@Execute()
*  --This method is used to execute the mower's state
*/
public interface MowerState {
    void execute(Mower mower, Direction direction);
}
