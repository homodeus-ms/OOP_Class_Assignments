package academy.pocu.comp2500.assignment4;

import java.util.LinkedList;

public class OverdrawAnalyzer extends Canvas {

    LinkedList<Character>[][] histories;

    public OverdrawAnalyzer(int width, int height) {
        super(width, height);
        histories = new LinkedList[height][width];
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
        return histories[y][x] == null ? new LinkedList<>() : histories[y][x];
    }
    public int getOverdrawCount(int x, int y) {
        return histories[y][x] == null ? 0 : histories[y][x].size();
    }
    public int getOverdrawCount() {
        int count = 0;
        int width = getWidth();
        int height = getHeight();

        for (int i = 0 ; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (histories[i][j] != null) {
                    count += histories[i][j].size();
                }
            }
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
        if (histories[y][x] == null) {
            histories[y][x] = new LinkedList<>();
        }
        histories[y][x].add(newChar);
    }

}
