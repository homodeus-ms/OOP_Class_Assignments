package academy.pocu.comp2500.assignment4;

public class ToUpper extends Command implements ICommand {

    public ToUpper(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean execute(Canvas canvas) {
        if (!isExecuted && isValidPos(canvas, x, y)) {
            this.canvas = canvas;
            oldChar = canvas.getPixel(x, y);

            if (oldChar >= 'a' && oldChar <= 'z') {
                canvas.toUpper(x, y);
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
        if (isExecuted) {
            if (oldChar >= 'a' && oldChar <= 'z') {
                canvas.toLower(x, y);
            }
            doneUndo = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean redo() {
        if (isExecuted) {
            doneUndo = false;
            canvas.drawPixel(x, y, newChar);
            doneUndo = false;
            return true;
        }
        return false;
    }
}
