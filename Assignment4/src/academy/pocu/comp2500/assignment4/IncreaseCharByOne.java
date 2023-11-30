package academy.pocu.comp2500.assignment4;

public class IncreaseCharByOne extends Command implements ICommand {

    public IncreaseCharByOne(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        this.canvas = canvas;
        oldChar = canvas.getPixel(x, y);

        if (!isExecuted && isValidPos(canvas, x, y) && oldChar < 126) {

            newChar = (char) (oldChar + 1);
            canvas.increasePixel(x, y);

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
