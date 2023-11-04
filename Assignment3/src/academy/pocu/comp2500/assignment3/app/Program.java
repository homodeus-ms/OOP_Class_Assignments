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

        Unit u0 = new Tank(new IntVector2D(0x0, 2));
        Unit u1 = new Tank(new IntVector2D(0x0, 6));
        Unit u2 = new Mine(new IntVector2D(0x9, 7), 2);
        Unit u3 = new Mine(new IntVector2D(0x3, 3), 1);
        Unit u4 = new Mine(new IntVector2D(0x7, 0), 4);
        Unit u5 = new Mine(new IntVector2D(0x4, 3), 4);
        Unit u6 = new Mine(new IntVector2D(0x1, 4), 4);
        Unit u7 = new Mine(new IntVector2D(0x6, 3), 4);
        Unit u8 = new Mine(new IntVector2D(0xE, 3), 2);
        Unit u9 = new Mine(new IntVector2D(0xC, 1), 1);
        Unit uA = new Mine(new IntVector2D(0x0, 3), 2);
        Unit uB = new Mine(new IntVector2D(0x9, 1), 4);
        Unit uC = new Mine(new IntVector2D(0x6, 3), 3);
        Unit uD = new Mine(new IntVector2D(0x0, 5), 3);
        Unit uE = new Mine(new IntVector2D(0xF, 2), 3);
        Unit uF = new Mine(new IntVector2D(0x2, 6), 2);


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

        int stop = 27;

        for (Unit unit : units) {
            simulationManager.spawn(unit);
        }

        SimulationVisualizer visualizer = new SimulationVisualizer(units);



        for (int i = 0; i < 35; ++i) {
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
