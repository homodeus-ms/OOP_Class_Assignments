package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {

    private static SimulationManager instance;
    private final ArrayList<Unit> units;

    private SimulationManager(ArrayList<Unit> units) {
        this.units = units;
    }

    public static SimulationManager getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new SimulationManager(new ArrayList<>());

        return instance;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void spawn(Unit unit) {
        this.units.add(unit);
    }


    public void registerThinkable(Unit thinkable) {

    }

    public void registerMovable(Unit movable) {

    }

    public void registerCollisionEventListener(Unit listener) {

    }

    public void update() {

    }
}