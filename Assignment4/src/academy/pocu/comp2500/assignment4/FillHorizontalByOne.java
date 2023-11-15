package academy.pocu.comp2500.assignment4;

public class FillHorizontalByOne extends Command implements ICommand {

    char[] oldChars;

    public FillHorizontalByOne(int y, char c) {
        this.y = y;
        this.newChar = c;
    }

    @Override
    public boolean execute(Canvas canvas) {
        this.canvas = canvas;
        if (!isExecuted && isValidPos(canvas, 0, y) && isValidChar(newChar)) {
            this.width = canvas.getWidth();
            this.height = canvas.getHeight();
            oldChars = new char[width];

            for (int i = 0; i < width; ++i) {
                oldChars[i] = canvas.getPixel(i, y);
                if (oldChars[i] != newChar) {
                    canvas.drawPixel(i, y, newChar);
                    //isExecuted = true;
                }
            }
            isExecuted = true;
        }
        return isExecuted;
    }

    @Override
    public boolean undo() {
        boolean isChanged = false;
        if (isExecuted) {
            for (int i = 0; i < width; ++i) {
                if (oldChars[i] != newChar) {
                    canvas.drawPixel(i, y, oldChars[i]);
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    @Override
    public boolean redo() {
        boolean isChanged = false;
        if (isExecuted) {
            for (int i = 0; i < width; ++i) {
                if (oldChars[i] != newChar) {
                    canvas.drawPixel(i, y, newChar);
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }
}
