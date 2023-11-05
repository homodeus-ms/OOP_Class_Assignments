package academy.pocu.comp2500.assignment3.app;

import academy.pocu.comp2500.assignment3.*;
import academy.pocu.comp2500.assignment3.registry.Registry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        SimulationManager simulationManager = SimulationManager.getInstance();

        ArrayList<Unit> units = new ArrayList<>();



        Unit u0 = new SmartMine(new IntVector2D(0x5, 0), 3, 1);
        Unit u1 = new Mine(new IntVector2D(0x0, 2), 3);
        Unit u2 = new Marine(new IntVector2D(0x3, 0));
        Unit u3 = new SmartMine(new IntVector2D(0x3, 2), 2, 2);
        Unit u4 = new Wraith(new IntVector2D(0x4, 0));
        Unit u5 = new Mine(new IntVector2D(0x1, 3), 2);
        Unit u6 = new Turret(new IntVector2D(0x2, 2));
        Unit u7 = new Marine(new IntVector2D(0x4, 3));
        Unit u8 = new Mine(new IntVector2D(0x0, 0), 2);
        Unit u9 = new Wraith(new IntVector2D(0x5, 1));
        Unit uA = new Mine(new IntVector2D(0x7, 3), 2);
        Unit uB = new Marine(new IntVector2D(0x6, 0));
        Unit uC = new SmartMine(new IntVector2D(0x6, 0), 4, 1);
        Unit uD = new Marine(new IntVector2D(0x2, 3));
        Unit uE = new Wraith(new IntVector2D(0x0, 2));
        Unit uF = new SmartMine(new IntVector2D(0x3, 3), 4, 1);


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



        for (int i = 0; i < 25; ++i) {
            clearConsole();
            visualizer.visualize(i, simulationManager.getUnits());
            simulationManager.update();
            if (i >= stop - 1) {
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
