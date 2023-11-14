package academy.pocu.comp2500.assignment4;

public class DecreaseCharByOne extends Command implements ICommand {

    public DecreaseCharByOne(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        this.canvas = canvas;
        if (!isExecuted && isValidPos(canvas, x, y) && canvas.getPixel(x, y) > 32) {

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
            return true;
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (isExecuted) {
            canvas.decreasePixel(x, y);
        }
        return false;
    }
}
