package academy.pocu.comp2500.assignment4;

public abstract class Command {
    protected Canvas canvas;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected char newChar;
    protected char oldChar;
    protected boolean isExecuted;
    protected boolean isValid;


    protected boolean isValidPos(Canvas canvas, int x, int y) {
        return x >= 0 && x < canvas.getWidth() && y >= 0 && y < canvas.getHeight();
    }
    protected boolean isValidChar(char c) {
        return c >= 32 && c <= 126;
    }


    /*protected void copyAllPixels(char[][] source, char[][] target, int width, int height) {
        assert (source.length == target.length) : "sourceArr size != targetArr size";

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                target[i][j] = source[i][j];
            }
        }
    }*/
}
