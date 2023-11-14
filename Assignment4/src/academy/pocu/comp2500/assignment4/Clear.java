package academy.pocu.comp2500.assignment4;

public class Clear extends Command implements ICommand {

    private char[][] oldValues;

    public Clear() {

    }

    @Override
    public boolean execute(Canvas canvas) {
        width = canvas.getWidth();
        height = canvas.getHeight();
        this.canvas = canvas;

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

        isExecuted = true;

        return true;
    }

    @Override
    public boolean undo() {
        if (width == 0 || height == 0 || !isExecuted) {
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

        return true;
    }

    @Override
    public boolean redo() {
        if (isExecuted) {
            execute(canvas);
            return true;
        }

        return false;
    }
}
