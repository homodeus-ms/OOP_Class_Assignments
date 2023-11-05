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

        Unit u0 = new Turret(new IntVector2D(0x6, 0));
        Unit u1 = new Tank(new IntVector2D(0x6, 0));
        Unit u2 = new SmartMine(new IntVector2D(0x5, 0), 4, 1);
        Unit u3 = new SmartMine(new IntVector2D(0x5, 0), 1, 3);
        Unit u4 = new Marine(new IntVector2D(3, 0));
        units.add(u0);
        units.add(u1);
        units.add(u2);
        units.add(u3);
        units.add(u4);


        /*Unit u0 = new Mine(new IntVector2D(0xE, 4), 1);
        Unit u1 = new Marine(new IntVector2D(0x9, 7));
        Unit u2 = new SmartMine(new IntVector2D(0x5, 2), 4, 2);
        Unit u3 = new Marine(new IntVector2D(0x1, 5));
        Unit u4 = new SmartMine(new IntVector2D(0x9, 3), 1, 1);
        Unit u5 = new SmartMine(new IntVector2D(0xB, 6), 3, 1);
        Unit u6 = new Turret(new IntVector2D(0x7, 7));
        Unit u7 = new SmartMine(new IntVector2D(0xC, 0), 3, 3);
        Unit u8 = new Wraith(new IntVector2D(0xC, 6));
        Unit u9 = new SmartMine(new IntVector2D(0xD, 6), 1, 3);
        Unit uA = new Wraith(new IntVector2D(0x5, 7));
        Unit uB = new Turret(new IntVector2D(0xB, 3));
        Unit uC = new SmartMine(new IntVector2D(0x0, 3), 2, 1);
        Unit uD = new Turret(new IntVector2D(0x9, 4));
        Unit uE = new Mine(new IntVector2D(0x7, 0), 1);
        Unit uF = new Tank(new IntVector2D(0xD, 7));


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
*/
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
