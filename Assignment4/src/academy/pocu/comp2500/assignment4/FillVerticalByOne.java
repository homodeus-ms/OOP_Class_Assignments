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
        if (!isExecuted && isValidPos(canvas, x, 0) && isValidChar(newChar)) {
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
            isExecuted = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean undo() {
        boolean isChanged = false;
        if (isExecuted) {
            for (int i = 0; i < height; ++i) {
                if (oldChars[i] != newChar) {
                    canvas.drawPixel(x, i, oldChars[i]);
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
            for (int i = 0; i < height; ++i) {
                if (oldChars[i] != newChar) {
                    canvas.drawPixel(x, i, newChar);
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }
}
