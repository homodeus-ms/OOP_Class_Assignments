package academy.pocu.comp2500.assignment4;

import java.util.HashMap;

public class Canvas {

    private final int LETTER_MIN = 32;
    private final int LETTER_MAX = 126;
    private final int width;
    private final int height;
    //private final Vector2D vectorKey = new Vector2D(-1, -1);
    private char[][] canvas;
    private StringBuilder builder;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        canvas = new char[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                canvas[i][j] = ' ';
            }
        }
        builder = new StringBuilder(width * height * 2);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void drawPixel(int x, int y, char letter) {
        if (isValidPos(x, y) && isValidLetter(letter)) {
            canvas[y][x] = letter;
        }
    }
    public char getPixel(int x, int y) {
        if (isValidPos(x, y)) {
            return canvas[y][x];
        }
        return ' ';
    }
    public boolean increasePixel(int x, int y) {
        if (isValidPos(x, y) && canvas[y][x] < LETTER_MAX) {
            ++canvas[y][x];
            return true;
        }
        return false;
    }
    public boolean decreasePixel(int x, int y) {
        if (isValidPos(x, y) && canvas[y][x] > LETTER_MIN) {
            --canvas[y][x];
            return true;
        }
        return false;
    }
    public void toUpper(int x, int y) {
        if (isValidPos(x, y) && canvas[y][x] >= 'a' && canvas[y][x] <= 'z') {
            canvas[y][x] ^= 0x20;
        }
    }
    public void toLower(int x, int y) {
        if (isValidPos(x, y) && canvas[y][x] >= 'A' && canvas[y][x] <= 'Z') {
            canvas[y][x] |= 0x20;
        }
    }
    public void fillHorizontalLine(int y, char letter) {
        if (isValidPos(0, y) && isValidLetter(letter)) {
            for (int i = 0; i < width; ++i) {
                canvas[y][i] = letter;
            }
        }
    }
    public void fillVerticalLine(int x, char letter) {
        if (isValidPos(x, 0) && isValidLetter(letter)) {
            for (int i = 0; i < height; ++i) {
                canvas[i][x] = letter;
            }
        }
    }
    public void clear() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                canvas[i][j] = ' ';
            }
        }
    }
    public String getDrawing() {

        builder.append('+');
        for (int i = 0; i < width; ++i) {
            builder.append('-');
        }
        builder.append('+');
        builder.append(System.lineSeparator());

        String outLine = builder.toString();

        for (int i = 0; i < height; ++i) {
            builder.append('|');
            for (int j = 0; j < width; ++j) {
                builder.append(canvas[i][j]);
            }
            builder.append('|');
            builder.append(System.lineSeparator());
        }

        builder.append(outLine);

        return builder.toString();
    }

    private boolean isValidPos(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
    private boolean isValidLetter(char letter) {
        return letter >= LETTER_MIN && letter <= LETTER_MAX;
    }

    // 해쉬맵으로 받는 것 일단 뮤트해놓음. 어레이로 받아도 되는지 일단 시험
    /*private HashMap<Vector2D, Character> letterMap = new HashMap<>();

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void drawPixel(int x, int y, char letter) {
        if (isValidPos(x, y) && isValidLetter(letter)) {
            Vector2D v = new Vector2D(x, y);
            letterMap.put(v, letter);
        }
    }
    public char getPixel(int x, int y) {
        vectorKey.setVector(x, y);
        return letterMap.get(vectorKey);
    }
    public boolean increasePixel(int x, int y) {
        vectorKey.setVector(x, y);
        if (letterMap.containsKey(vectorKey)) {
            char c = letterMap.get(vectorKey);
            if (c == 126) {
                return false;
            } else {
                letterMap.put(vectorKey, ++c);
                return true;
            }
        }
        return false;
    }
    public boolean decreasePixel(int x, int y) {
        vectorKey.setVector(x, y);
        if (letterMap.containsKey(vectorKey)) {
            char c = letterMap.get(vectorKey);
            if (c == 32) {
                return false;
            } else {
                letterMap.put(vectorKey, --c);
                return true;
            }
        }
        return false;
    }
    public void toUpper(int x, int y) {
        vectorKey.setVector(x, y);
        if (letterMap.containsKey(vectorKey)) {
            char c = letterMap.get(vectorKey);
            if (c >= 'a' && c <= 'z') {
                c ^= 0x20;
                letterMap.put(vectorKey, c);
            }
        }
    }
    public void toLower(int x, int y) {
        vectorKey.setVector(x, y);
        if (letterMap.containsKey(vectorKey)) {
            char c = letterMap.get(vectorKey);
            if (c >= 'A' && c <= 'Z') {
                c |= 0x20;
                letterMap.put(vectorKey, c);
            }
        }
    }
    public void fillHorizontalLine(int y, char letter) {
        if (isValidPos(0, y) && isValidLetter(letter) ) {
            for (int i = 0; i < width; ++i) {
                vectorKey.setVector(i, y);
                letterMap.put(vectorKey, letter);
            }
        }
    }
    public void fillVerticalLine(int x, char letter) {
        if (isValidPos(x, 0) && isValidLetter(letter) ) {
            for (int i = 0; i < height; ++i) {
                vectorKey.setVector(x, i);
                letterMap.put(vectorKey, letter);
            }
        }
    }
    public void clear() {
        letterMap.clear();
    }
    public void getDrawing() {

    }*/

}
