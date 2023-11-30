package academy.pocu.comp2500.assignment4;

public class FillVerticalByOne extends Command implements ICommand {

    private char[] oldChars;

    public FillVerticalByOne(int x, char c) {
        this.x = x;
        this.newChar = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        this.canvas = canvas;

        if (!isExecuted && isValidPos(canvas, x, 0)) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            oldChars = new char[height];

            for (int i = 0; i < height; ++i) {
                oldChars[i] = canvas.getPixel(x, i);
                if (oldChars[i] != newChar) {
                    canvas.drawPixel(x, i, newChar);
                    //isExecuted = true;
                }
            }
        }
        isExecuted = true;
        return true;
    }

    @Override
    public boolean undo() {
        //boolean isChanged = false;
        if (isExecuted && isSameCanvas(newChar) && !doneUndo) {
            for (int i = 0; i < height; ++i) {
                if (oldChars[i] != newChar) {
                    canvas.drawPixel(x, i, oldChars[i]);
                    //isChanged = true;
                }
            }
            doneUndo = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean redo() {
        //boolean isChanged = false;
        if (isExecuted && isSameCanvas(oldChars) && doneUndo) {
            for (int i = 0; i < height; ++i) {
                if (oldChars[i] != newChar) {
                    canvas.drawPixel(x, i, newChar);
                    //isChanged = true;
                }
            }
            doneUndo = false;
            return true;
        }
        return false;
    }
    @Override
    public boolean isSameCanvas(char expected) {
        for (int i = 0; i < height; ++i) {
            if (canvas.getPixel(x, i) != expected) {
                return false;
            }
        }
        return true;
    }
    public boolean isSameCanvas(char[] expecteds) {
        for (int i = 0; i < width; ++i) {
            if (canvas.getPixel(i, y) != oldChars[i]) {
                return false;
            }
        }
        return true;
    }
}
