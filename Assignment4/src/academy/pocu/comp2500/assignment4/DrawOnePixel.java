package academy.pocu.comp2500.assignment4;

public class DrawOnePixel extends Command implements ICommand {

    public DrawOnePixel(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.newChar = c;
    }
    @Override
    public boolean execute(Canvas canvas) {
        if (!isExecuted && isValidPos(canvas, x, y) && isValidChar(newChar)) {
            this.canvas = canvas;
            oldChar = canvas.getPixel(x, y);
            //if (oldChar != newChar) {
            canvas.drawPixel(x, y, newChar);
            isExecuted = true;
            return true;

        }
        return false;
    }
    @Override
    public boolean undo() {
        if (isExecuted) {
            canvas.drawPixel(x, y, oldChar);
            return true;
        }
        return false;
    }
    @Override
    public boolean redo() {
        if (isExecuted) {
            canvas.drawPixel(x, y, newChar);
            return true;
        }
        return false;
    }
}
