package academy.pocu.comp2500.assignment3.app;

import academy.pocu.comp2500.assignment3.*;
import academy.pocu.comp2500.assignment3.registry.Registry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        SimulationManager simulationManager = SimulationManager.getInstance();

        ArrayList<Unit> units = new ArrayList<>();

        Unit u0 = new Wraith(new IntVector2D(0x6, 5));
        Unit u1 = new SmartMine(new IntVector2D(0xB, 4), 4, 3);
        Unit u2 = new Wraith(new IntVector2D(0x2, 2));
        Unit u3 = new Marine(new IntVector2D(0xA, 3));
        Unit u4 = new Tank(new IntVector2D(0x8, 4));
        Unit u5 = new Tank(new IntVector2D(0xA, 0));
        Unit u6 = new Wraith(new IntVector2D(0xB, 6));
        Unit u7 = new Turret(new IntVector2D(0x0, 7));
        Unit u8 = new Mine(new IntVector2D(0xB, 1), 4);
        Unit u9 = new Mine(new IntVector2D(0x5, 5), 1);
        Unit uA = new Marine(new IntVector2D(0xB, 4));
        Unit uB = new Mine(new IntVector2D(0xE, 6), 4);
        Unit uC = new Wraith(new IntVector2D(0xB, 2));
        Unit uD = new Turret(new IntVector2D(0xF, 3));
        Unit uE = new Marine(new IntVector2D(0xB, 7));
        Unit uF = new SmartMine(new IntVector2D(0x4, 7), 3, 3);


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



        for (int i = 0; i < 10; ++i) {
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
