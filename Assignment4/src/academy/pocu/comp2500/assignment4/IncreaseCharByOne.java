package academy.pocu.comp2500.assignment4;

public class IncreaseCharByOne extends Command implements ICommand {

    public IncreaseCharByOne(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        this.canvas = canvas;
        if (!isExecuted && isValidPos(canvas, x, y) && canvas.getPixel(x, y) < 126) {

            canvas.increasePixel(x, y);
            isExecuted = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean undo() {
        if (isExecuted) {
            canvas.decreasePixel(x, y);
            return true;
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (isExecuted) {
            canvas.increasePixel(x, y);
            return true;
        }
        return false;
    }
}
