package academy.pocu.comp2500.assignment4;

public class DrawOnePixel extends Command implements ICommand {

    public DrawOnePixel(int x, int y, char c) {
        this.x = x;
        this.y = y;
        this.newChar = c;
    }
    @Override
    public boolean execute(Canvas canvas) {
        if (!isExecuted && isValidPos(canvas, x, y)) {
            this.canvas = canvas;
            oldChar = canvas.getPixel(x, y);
            canvas.drawPixel(x, y, newChar);
            isExecuted = true;
            return true;
        }
        return false;
    }
    @Override
    public boolean undo() {
        if (isExecuted && isSameCanvas(newChar) && !doneUndo) {
            canvas.drawPixel(x, y, oldChar);
            doneUndo = true;
            return true;
        }
        return false;
    }
    @Override
    public boolean redo() {
        if (isExecuted && isSameCanvas(oldChar) && doneUndo) {
            canvas.drawPixel(x, y, newChar);
            doneUndo = false;
            return true;
        }
        return false;
    }

}
