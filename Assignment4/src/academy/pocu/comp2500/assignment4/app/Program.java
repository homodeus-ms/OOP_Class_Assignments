package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;
import academy.pocu.comp2500.assignment4.registry.Registry;

import java.util.HashMap;
import java.util.LinkedList;

public class Program {

    public static void main(String[] args) {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();


        System.out.println("No Assert!");
    }
    public static void print(Canvas canvas, int x, int y) {
        System.out.println(canvas.getDrawing());
        System.out.printf("(%d, %d) count: %d%s", x, y, ((OverdrawAnalyzer) canvas).getOverdrawCount(x, y),
                System.lineSeparator());
        System.out.printf("Total Overdraw Count: %d%s", ((OverdrawAnalyzer) canvas).getOverdrawCount(),
                System.lineSeparator());
    }
}
