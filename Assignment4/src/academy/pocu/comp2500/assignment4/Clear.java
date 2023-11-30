package academy.pocu.comp2500.assignment4;

public class Clear extends Command implements ICommand {

    private char[][] oldValues;

    public Clear() {

    }

    @Override
    public boolean execute(Canvas canvas) {

        this.canvas = canvas;

        if (!isExecuted) {
            width = canvas.getWidth();
            height = canvas.getHeight();

            oldValues = new char[height][width];

            for (int i = 0; i < height; ++i) {
                for (int j = 0; j < width; ++j) {
                    char c = canvas.getPixel(j, i);
                    if (c != ' ') {
                        oldValues[i][j] = c;
                        canvas.drawPixel(j, i, ' ');
                    } else {
                        oldValues[i][j] = ' ';
                    }
                }
            }
        }
        isExecuted = true;
        return true;
    }

    @Override
    public boolean undo() {

        if (width == 0 || height == 0 || !isExecuted) {
            return false;
        }
        if (!isSameCanvas(' ')) {
            return false;
        }

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                char c = oldValues[i][j];
                if (c != ' ') {
                    canvas.drawPixel(j, i, c);
                }
            }
        }
        doneUndo = true;

        return true;
    }

    @Override
    public boolean redo() {
        if (isExecuted && isSameCanvas(oldValues) && doneUndo) {
            isExecuted = false;
            execute(canvas);
            doneUndo = false;
            return true;
        }

        return false;
    }
    @Override
    public boolean isSameCanvas(char expected) {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (canvas.getPixel(j, i) != expected) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSameCanvas(char[][] expected) {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (canvas.getPixel(j, i) != expected[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
