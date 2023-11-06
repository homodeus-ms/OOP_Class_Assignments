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

        /*Unit u0 = new Wraith(new IntVector2D(3, 3));
        Unit u1 = new Wraith(new IntVector2D(4, 3));
        Unit u2 = new Wraith(new IntVector2D(4, 4));
        Unit u3 = new Wraith(new IntVector2D(3, 4));
        Unit u4 = new Wraith(new IntVector2D(2, 4));


        units.add(u0);
        units.add(u1);
        units.add(u2);
        units.add(u3);
        units.add(u4);*/

        // k00 테스트 중 하나
        Unit u0 = new Wraith(new IntVector2D(0xF, 0));
        Unit u1 = new Marine(new IntVector2D(0x4, 3));
        Unit u2 = new Marine(new IntVector2D(0xA, 5));
        Unit u3 = new Turret(new IntVector2D(0x3, 4));
        Unit u4 = new Wraith(new IntVector2D(0xE, 7));
        Unit u5 = new Mine(new IntVector2D(0xE, 6), 3);
        Unit u6 = new Mine(new IntVector2D(0x5, 0), 3);
        Unit u7 = new SmartMine(new IntVector2D(0x8, 0), 2, 2);
        Unit u8 = new Mine(new IntVector2D(0x4, 2), 3);
        Unit u9 = new Tank(new IntVector2D(0x9, 6));
        Unit uA = new Turret(new IntVector2D(0x3, 7));
        Unit uB = new SmartMine(new IntVector2D(0xE, 3), 3, 1);
        Unit uC = new Tank(new IntVector2D(0x8, 0));
        Unit uD = new SmartMine(new IntVector2D(0x2, 4), 4, 1);
        Unit uE = new Wraith(new IntVector2D(0xA, 0));
        Unit uF = new Wraith(new IntVector2D(0x4, 5));


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

        //k00 테스트중 하나
        /*Unit u0 = new Marine(new IntVector2D(0xC, 6));
        Unit u1 = new Turret(new IntVector2D(0x7, 4));
        Unit u2 = new SmartMine(new IntVector2D(0x2, 5), 2, 2);
        Unit u3 = new Mine(new IntVector2D(0x7, 3), 2);
        Unit u4 = new Mine(new IntVector2D(0x7, 7), 4);
        Unit u5 = new Turret(new IntVector2D(0x1, 6));
        Unit u6 = new Mine(new IntVector2D(0xB, 0), 4);
        Unit u7 = new SmartMine(new IntVector2D(0x3, 0), 2, 1);
        Unit u8 = new Turret(new IntVector2D(0xA, 0));
        Unit u9 = new Turret(new IntVector2D(0xD, 3));
        Unit uA = new Turret(new IntVector2D(0xE, 2));
        Unit uB = new Tank(new IntVector2D(0xE, 6));
        Unit uC = new SmartMine(new IntVector2D(0xA, 0), 1, 3);
        Unit uD = new Marine(new IntVector2D(0xC, 6));
        Unit uE = new Wraith(new IntVector2D(0x8, 7));
        Unit uF = new Wraith(new IntVector2D(0xF, 7));


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
        units.add(uF);*/


        // k02 테스트에 왼쪽, 윗쪽에 몰려있는 테스트
        /*Unit u0 = new SmartMine(new IntVector2D(0x5, 0), 3, 1);
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
        Unit uF = new Destroyer(new IntVector2D(0x3, 3));


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
        units.add(uF);*/

        //k02 테스트중 하나

        /*Unit u0 = new Wraith(new IntVector2D(2, 2));
        units.add(u0);
        Unit u1 = new Wraith(new IntVector2D(14, 2));
        units.add(u1);
        Unit u2 = new Wraith(new IntVector2D(8, 1));
        units.add(u2);
        Unit u3 = new Wraith(new IntVector2D(14, 4));
        units.add(u3);
        Unit u4 = new Wraith(new IntVector2D(9, 3));
        units.add(u4);
        Unit u5 = new Wraith(new IntVector2D(4, 5));
        units.add(u5);
        Unit u6 = new Wraith(new IntVector2D(6, 0));
        units.add(u6);
        Unit u7 = new Wraith(new IntVector2D(0, 6));
        units.add(u7);
        Unit u8 = new Wraith(new IntVector2D(13, 1));
        units.add(u8);
        Unit u9 = new Wraith(new IntVector2D(2, 5));
        units.add(u9);
        Unit uA = new Wraith(new IntVector2D(13, 3));
        units.add(uA);
        Unit uB = new Wraith(new IntVector2D(12, 6));
        units.add(uB);
        Unit uC = new Wraith(new IntVector2D(9, 1));
        units.add(uC);*/



        int stop = 13;

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
