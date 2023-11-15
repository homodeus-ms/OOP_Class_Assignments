package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.*;
import academy.pocu.comp2500.assignment4.registry.Registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Program {

    public static void main(String[] args) {

        //test9();
        //test8();
        //test7();
        //test6();
        //test5();
        //test4();
        //test3();
        //test2();
        //test1();



        System.out.println("No Assert!");
    }
    public static void print(Canvas canvas, int x, int y) {
        System.out.println(canvas.getDrawing());
        System.out.printf("(%d, %d) count: %d%s", x, y, ((OverdrawAnalyzer) canvas).getOverdrawCount(x, y),
                System.lineSeparator());
        System.out.printf("Total Overdraw Count: %d%s", ((OverdrawAnalyzer) canvas).getOverdrawCount(),
                System.lineSeparator());
    }

    public static void test1() {
        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(25, 30);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.execute(new FillVerticalByOne(21, '8'));
        manager.execute(new FillHorizontalByOne(10, '#'));
        manager.execute(new ToLower(5, 1));
        manager.redo();
        manager.undo();
        System.out.println(analyzer.getDrawing());
    }
    public static void test2() {
        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(30, 25);
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
        manager.redo();
        System.out.println(analyzer.getDrawing());
    }
    public static void test3() {
        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(30, 25);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.execute(new FillHorizontalByOne(10, 't'));
        manager.execute(new FillHorizontalByOne(2, 'K'));
        manager.execute(new DrawOnePixel(8, 6, 'O'));
        manager.execute(new Clear());
        manager.undo();
        manager.undo();
        System.out.println(analyzer.getDrawing());
    }
    public static void test4() {
        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(25, 30);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.execute(new FillVerticalByOne(21, '8'));
        manager.execute(new FillHorizontalByOne(10, '#'));
        manager.execute(new ToLower(5, 1));
        manager.redo();
        manager.undo();
        System.out.println(analyzer.getDrawing());
    }
    public static void test5() {
        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(30, 25);
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
        manager.undo();
        System.out.println(analyzer.getDrawing());
    }
    public static void test6() {
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
        System.out.println(analyzer.getDrawing());
    }
    public static void test7() {
        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(30, 25);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.redo();
        manager.execute(new ToUpper(11, 10));
        manager.execute(new DecreaseCharByOne(29, 15));
        manager.redo();
        manager.execute(new IncreaseCharByOne(15, 24));
        manager.execute(new FillVerticalByOne(21, 'T'));
        manager.undo();
        manager.execute(new FillVerticalByOne(18, ';'));
        manager.undo();
        manager.execute(new DecreaseCharByOne(18, 22));
        manager.redo();

        System.out.println(analyzer.getDrawing());
    }
    public static void test8() {
        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.execute(new ToUpper(2, 0));
        manager.execute(new ToUpper(0, 1));
        manager.execute(new ToLower(4, 3));
        manager.execute(new FillHorizontalByOne(0, 'e'));
        manager.execute(new DecreaseCharByOne(4, 4));
        manager.execute(new DecreaseCharByOne(0, 1));
        manager.execute(new ToLower(0, 0));
        manager.execute(new DrawOnePixel(3, 2, 'Z'));
        manager.execute(new IncreaseCharByOne(3, 4));
        manager.execute(new ToUpper(4, 4));
        manager.execute(new DrawOnePixel(4, 0, '+'));
        manager.execute(new FillVerticalByOne(4, '^'));
        manager.execute(new ToLower(0, 3));
        manager.execute(new ToLower(1, 0));
        manager.redo();
        manager.undo();
        manager.execute(new ToLower(1, 3));
        manager.execute(new FillVerticalByOne(3, 'I'));
        manager.execute(new IncreaseCharByOne(4, 4));
        manager.redo();

        System.out.println(analyzer.getDrawing());
        System.out.println(analyzer.getOverdrawCount());
    }
    public static void test9() {
        OverdrawAnalyzer analyzer = new OverdrawAnalyzer(5, 5);
        CommandHistoryManager manager = new CommandHistoryManager(analyzer);

        manager.undo();
        manager.execute(new ToUpper(3, 4));
        manager.execute(new ToLower(0, 1));
        manager.execute(new Clear());
        manager.execute(new IncreaseCharByOne(2, 2));
        manager.execute(new DecreaseCharByOne(1, 3));
        manager.execute(new IncreaseCharByOne(1, 2));
        manager.undo();
        manager.undo();
        manager.execute(new Clear());
        manager.execute(new FillHorizontalByOne(4, 'p'));
        manager.redo();
        manager.undo();
        manager.execute(new IncreaseCharByOne(2, 1));
        manager.execute(new IncreaseCharByOne(3, 1));
        manager.execute(new ToUpper(2, 2));
        manager.undo();
        manager.execute(new FillHorizontalByOne(0, ' '));
        manager.undo();
        manager.execute(new FillHorizontalByOne(4, 'D'));

        System.out.println(analyzer.getDrawing());
        System.out.println(analyzer.getOverdrawCount());
    }

}
