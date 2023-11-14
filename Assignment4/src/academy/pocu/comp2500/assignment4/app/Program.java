package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;
import academy.pocu.comp2500.assignment4.registry.Registry;

import java.util.HashMap;
import java.util.LinkedList;

public class Program {

    public static void main(String[] args) {
        OverdrawAnalyzer overdrawAnalyzer1 = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager commandHistoryManager = new CommandHistoryManager(overdrawAnalyzer1);
        commandHistoryManager.execute(new ToUpper(2, 0));
        commandHistoryManager.execute(new ToUpper(0, 1));
        commandHistoryManager.execute(new ToLower(4, 3));
        commandHistoryManager.execute(new FillHorizontalByOne(0, 'e'));
        commandHistoryManager.execute(new DecreaseCharByOne(4, 4));
        commandHistoryManager.execute(new DecreaseCharByOne(0, 1));
        commandHistoryManager.execute(new ToLower(0, 0));
        commandHistoryManager.execute(new DrawOnePixel(3, 2, 'Z'));
        commandHistoryManager.execute(new IncreaseCharByOne(3, 4));
        commandHistoryManager.execute(new ToUpper(4, 4));
        commandHistoryManager.execute(new DrawOnePixel(4, 0, '+'));
        commandHistoryManager.execute(new FillVerticalByOne(4, '^'));
        commandHistoryManager.execute(new ToLower(0, 3));
        commandHistoryManager.execute(new ToLower(1, 0));
        commandHistoryManager.redo();
        commandHistoryManager.undo();
        commandHistoryManager.execute(new ToLower(1, 3));
        commandHistoryManager.execute(new FillVerticalByOne(3, 'I'));
        commandHistoryManager.execute(new IncreaseCharByOne(4, 4));
        commandHistoryManager.redo();

        System.out.print(overdrawAnalyzer1.getDrawing());

        print(overdrawAnalyzer1, 0, 0);

        assert (overdrawAnalyzer1.getOverdrawCount() == 19);



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
