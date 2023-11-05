package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public interface ICollisionEventListener {
    void checkTriggerAndExplodeOrNot(ArrayList<Unit> sourceUnits, ArrayList<Unit> targets);
}
