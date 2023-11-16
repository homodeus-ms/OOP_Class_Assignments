package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.Stack;

public class CommandHistoryManager {

    private final Canvas canvas;
    private Stack<ICommand> commands = new Stack<>();
    private Stack<ICommand> undos = new Stack<>();
    private String currCanvas;

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;
        currCanvas = canvas.getDrawing();
    }
    public boolean execute(ICommand command) {
        boolean isExecuted = command.execute(canvas);
        currCanvas = canvas.getDrawing();
        if (isExecuted) {
            commands.push(command);
            undos.clear();
        }
        //recentUndo = null;

        return isExecuted;
    }
    public boolean canUndo() {
        return !commands.isEmpty() && currCanvas.equals(canvas.getDrawing());
    }
    public boolean canRedo() {
        return !undos.isEmpty();
    }
    public boolean undo() {
        if (canUndo()) {
            ICommand lastCommand = commands.pop();
            lastCommand.undo();
            currCanvas = canvas.getDrawing();
            undos.push(lastCommand);

            return true;
        }
        return false;
    }
    public boolean redo() {

        if (canRedo()) {
            ICommand lastUndo = undos.pop();
            lastUndo.redo();
            currCanvas = canvas.getDrawing();
            // redo를 하면 undo가 리셋 된다고 가정해야할까?
            //commands.clear();
            commands.push(lastUndo);

            return true;
        }
        return false;
    }
}
