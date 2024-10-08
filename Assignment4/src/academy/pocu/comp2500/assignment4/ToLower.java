package academy.pocu.comp2500.assignment4;

public class ToLower extends Command implements ICommand {

    public ToLower(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        this.canvas = canvas;

        if (!isExecuted && isValidPos(canvas, x, y)) {

            oldChar = canvas.getPixel(x, y);

            if (oldChar >= 'A' && oldChar <= 'Z') {
                canvas.toLower(x, y);
                newChar = canvas.getPixel(x, y);
            } else {
                newChar = oldChar;
            }
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
