package academy.pocu.comp2500.assignment3.app;

import academy.pocu.comp2500.assignment3.*;
import academy.pocu.comp2500.assignment3.registry.Registry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.spi.TimeZoneNameProvider;

public class Program {

    public static void main(String[] args) {


        SimulationManager simulationManager = SimulationManager.getInstance();

        ArrayList<Unit> units = new ArrayList<>();

        Unit u0 = new Wraith(new IntVector2D(6, 5));
        Unit u1 = new SmartMine(new IntVector2D(11, 4), 4, 3);
        Unit u2 = new Wraith(new IntVector2D(2, 2));
        Unit u3 = new Marine(new IntVector2D(10, 3));
        Unit u4 = new Tank(new IntVector2D(8, 4));
        Unit u5 = new Tank(new IntVector2D(10, 0));
        Unit u6 = new Wraith(new IntVector2D(11, 6));
        Unit u7 = new Turret(new IntVector2D(0, 7));
        Unit u8 = new Mine(new IntVector2D(11, 1), 4);
        Unit u9 = new Mine(new IntVector2D(5, 5), 1);
        Unit uA = new Marine(new IntVector2D(11, 4));
        Unit uB = new Mine(new IntVector2D(14, 6), 4);
        Unit uC = new Wraith(new IntVector2D(11, 2));
        Unit uD = new Turret(new IntVector2D(15, 3));
        Unit uE = new Marine(new IntVector2D(11, 7));
        Unit uF = new SmartMine(new IntVector2D(4, 7), 3, 3);

        units.add(u0);
        units.add(u1);
        units.add(u2);
        units.add(u3);
        units.add(u4);
        units.add(u5);
        units.add(u6);
        units.add(u7);
        units.add(u8);
        units.add(u9);
        units.add(uA);
        units.add(uB);
        units.add(uC);
        units.add(uD);
        units.add(uE);
        units.add(uF);


        int stop = 1;

        for (Unit unit : units) {
            simulationManager.spawn(unit);
        }

        SimulationVisualizer visualizer = new SimulationVisualizer(units);



        for (int i = 0; i < 100; ++i) {
            clearConsole();
            visualizer.visualize(i, simulationManager.getUnits());
            simulationManager.update();
            if (i >= stop) {
                continueOnEnter();
            }

        }
    }
    public void simmulateUntil(int stop, SimulationManager simulationManager,
                               SimulationVisualizer visualizer) {
        for (int i = 0; i < stop; ++i) {
            clearConsole();
            visualizer.visualize(i, simulationManager.getUnits());
            simulationManager.update();
            continueOnEnter();
        }
    }

    public static void continueOnEnter() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Press enter to continue");
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
