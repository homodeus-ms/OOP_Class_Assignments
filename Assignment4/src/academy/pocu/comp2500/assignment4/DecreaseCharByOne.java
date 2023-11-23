package academy.pocu.comp2500.assignment4;

public class DecreaseCharByOne extends Command implements ICommand {

    public DecreaseCharByOne(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        this.canvas = canvas;
        oldChar = canvas.getPixel(x, y);

        if (!isExecuted && isValidPos(canvas, x, y) && oldChar > 32) {

            newChar = (char) (oldChar - 1);
            canvas.decreasePixel(x, y);

            isExecuted = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean undo() {
        if (isExecuted) {
            canvas.increasePixel(x, y);
            doneUndo = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (isExecuted) {
            canvas.decreasePixel(x, y);
            doneUndo = false;
            return true;
        }
        return false;
    }

}
