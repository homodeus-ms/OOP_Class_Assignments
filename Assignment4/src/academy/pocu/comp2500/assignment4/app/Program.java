package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;
import academy.pocu.comp2500.assignment4.registry.Registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Program {

    public static void main(String[] args) {


        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(25, 30);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.execute(new DecreaseCharByOne(12, 15));
        manager.execute(new DrawOnePixel(19, 18, 'i'));
        manager.execute(new ToLower(21, 6));
        manager.execute(new FillHorizontalByOne(23, '['));
        manager.execute(new DrawOnePixel(3, 11, 'F'));
        manager.redo();
        manager.execute(new ToUpper(0, 27));
        manager.execute(new FillHorizontalByOne(12, '2'));
        manager.execute(new Clear());
        manager.execute(new FillHorizontalByOne(13, '-'));
        manager.execute(new ToUpper(11, 21));
        manager.execute(new IncreaseCharByOne(0, 13));
        manager.execute(new ToUpper(18, 17));
        manager.undo();



        /*OverdrawAnalyzer analyzer = new OverdrawAnalyzer(30, 25);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.undo();
        manager.undo();
        manager.execute(new ToLower(3, 14));
        manager.execute(new DecreaseCharByOne(10, 10));
        manager.execute(new Clear());
        manager.execute(new DrawOnePixel(15, 17, '!'));
        manager.undo();
        manager.execute(new FillVerticalByOne(25, 'p'));
        manager.execute(new ToLower(16, 0));
        manager.redo();
        manager.execute(new IncreaseCharByOne(24, 22));
        manager.execute(new IncreaseCharByOne(21, 3));
        manager.execute(new ToLower(28, 2));
        manager.execute(new Clear());
        manager.redo();
        manager.undo();*/



        /*OverdrawAnalyzer analyzer = new OverdrawAnalyzer(25, 30);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.execute(new FillVerticalByOne(21, '8'));
        manager.execute(new FillHorizontalByOne(10, '#'));
        manager.execute(new ToLower(5, 1));
        manager.redo();
        manager.undo();*/


        /*OverdrawAnalyzer analyzer = new OverdrawAnalyzer(30, 25);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.execute(new FillHorizontalByOne(10, 't'));
        manager.execute(new FillHorizontalByOne(2, 'K'));
        manager.execute(new DrawOnePixel(8, 6, 'O'));
        manager.execute(new Clear());
        manager.undo();
        manager.undo();*/



        /*OverdrawAnalyzer analyzer = new OverdrawAnalyzer(30, 25);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.execute(new FillHorizontalByOne(10, 't'));
        manager.execute(new FillHorizontalByOne(2, 'K'));
        manager.execute(new DrawOnePixel(8, 6, 'O'));
        manager.execute(new Clear());
        manager.undo();
        manager.undo();
        manager.execute(new Clear());
        manager.execute(new DrawOnePixel(22, 18, 'K'));
        manager.execute(new Clear());
        manager.undo();
        manager.execute(new FillHorizontalByOne(12, 'B'));
        manager.execute(new DecreaseCharByOne(27, 7));
        manager.undo();
        manager.execute(new DecreaseCharByOne(26, 12));
        manager.execute(new ToUpper(14, 14));
        manager.execute(new ToUpper(3, 18));
        manager.redo();*/



        /*OverdrawAnalyzer analyzer = new OverdrawAnalyzer(25, 30);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.execute(new FillVerticalByOne(21, '8'));
        manager.execute(new FillHorizontalByOne(10, '#'));
        manager.execute(new ToLower(5, 1));
        manager.redo();
        manager.undo();*/


        // ================================================================




        /*manager.redo();
        manager.redo();
        manager.execute(new ToUpper(21, 8));
        manager.execute(new DrawOnePixel(14, 10, 'v'));
        manager.redo();
        manager.undo();
        manager.redo();
        manager.execute(new DecreaseCharByOne(23, 17));
        manager.undo();*/

        /*manager.execute(new FillHorizontalByOne(4, '|'));
        manager.execute(new FillVerticalByOne(3, '4'));
        manager.execute(new Clear());
        manager.execute(new ToLower(15, 3));
        manager.execute(new FillHorizontalByOne(14, ')'));
        manager.redo();
        manager.execute(new ToLower(20, 3));
        manager.execute(new Clear());
        manager.execute(new FillHorizontalByOne(19, 'm'));
        manager.execute(new DecreaseCharByOne(18, 2));
        manager.execute(new ToUpper(13, 6));
        manager.execute(new FillVerticalByOne(26, 'I'));
        manager.execute(new IncreaseCharByOne(2, 7));
        manager.execute(new Clear());
        manager.execute(new IncreaseCharByOne(7, 18));
        manager.execute(new ToLower(27, 24));
        manager.execute(new FillVerticalByOne(1, '7'));
        manager.execute(new IncreaseCharByOne(18, 18));
        manager.execute(new DecreaseCharByOne(10, 12));
        manager.undo();*/

        System.out.println(analyzer.getDrawing());


        /*OverdrawAnalyzer overdrawAnalyzer1 = new OverdrawAnalyzer(5, 5);
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

        assert (overdrawAnalyzer1.getOverdrawCount() == 19);*/



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
