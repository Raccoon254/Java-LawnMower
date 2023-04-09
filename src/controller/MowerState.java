package controller;
import view.*;
import Model.*;
import controller.*;
public interface MowerState {
    void execute(Mower mower, Direction direction);
}
