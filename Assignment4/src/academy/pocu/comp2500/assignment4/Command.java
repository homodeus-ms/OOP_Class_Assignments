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
    /*protected boolean isValid;
    protected boolean isCanvasUpdated;*/


    protected boolean isValidPos(Canvas canvas, int x, int y) {
        return x >= 0 && x < canvas.getWidth() && y >= 0 && y < canvas.getHeight();
    }
    protected boolean isValidChar(char c) {
        return c >= 32 && c <= 126;
    }


}
