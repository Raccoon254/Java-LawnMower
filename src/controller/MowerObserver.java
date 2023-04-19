package controller;

import Model.Mower;
/*
 * --This interface is used to notify the observers when the mower moves.
 * --The mower is the subject and the observers are the observers.
 */
public interface MowerObserver {
    void onMove(Mower mower);
}
