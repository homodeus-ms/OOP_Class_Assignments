package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OverdrawAnalyzer extends Canvas {

    private final ArrayList<LinkedList<Character>> histories;

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
        histories = new ArrayList<>(width * height);
        int size = width * height;
        for (int i = 0; i < size; ++i) {
            histories.add(new LinkedList<>());
        }
    }
    @Override
    public void drawPixel(int x, int y, char letter) {
        update(x, y, letter);
        super.drawPixel(x, y, letter);
    }
    @Override
    public boolean increasePixel(int x, int y) {
        char c = getPixel(x, y);
        update(x, y, ++c);
        super.increasePixel(x, y);
        return true;
    }
    @Override
    public boolean decreasePixel(int x, int y) {
        char c = getPixel(x, y);
        update(x, y, --c);
        super.decreasePixel(x, y);
        return true;
    }
    @Override
    public void toUpper(int x, int y) {
        super.toUpper(x, y);
        update(x, y, getPixel(x, y));
    }
    @Override
    public void toLower(int x, int y) {
        super.toLower(x, y);
        update(x, y, getPixel(x, y));
    }
    public LinkedList<Character> getPixelHistory(int x, int y) {
        return histories.get(getIndex(x, y));
    }
    public int getOverdrawCount(int x, int y) {
        return histories.get(getIndex(x, y)).size();
    }
    public int getOverdrawCount() {

        int count = 0;
        int size = histories.size();

        for (int i = 0; i < size; ++i) {
            count += histories.get(i).size();
        }

        return count;
    }

    /*public void fillHorizontalLine(int y, char letter) {
        super.fillHorizontalLine(y, letter);
    }
    public void fillVerticalLine(int x, char letter) {
        super.fillVerticalLine(x, letter);
    }
    public void clear() {
        super.clear();
    }*/
    private void update(int x, int y, char newChar) {
        int index = getIndex(x, y);
        histories.get(index).add(newChar);
    }
    private int getIndex(int x, int y) {
        return getWidth() * y + x;
    }

}
