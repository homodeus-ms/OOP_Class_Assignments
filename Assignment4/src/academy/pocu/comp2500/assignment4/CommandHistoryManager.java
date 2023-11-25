package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.Stack;

public class CommandHistoryManager {

    private final Canvas canvas;
    private Stack<ICommand> commands = new Stack<>();
    private Stack<ICommand> undos = new Stack<>();
    private String currCanvas;
    private int undoTargetIndex = -1;

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;
        currCanvas = canvas.getDrawing();
    }
    public boolean execute(ICommand command) {
        if (!currCanvas.equals(canvas.getDrawing())) {
            commands.clear();
            undos.clear();
        }
        commands.push(command);
        boolean isExecuted = command.execute(canvas);
        currCanvas = canvas.getDrawing();

        if (isExecuted) {
            //commands.push(command);
            undos.clear();
        }

        return isExecuted;
    }
    public boolean canUndo() {
        if (commands.isEmpty()) {
            return false;
        }
        int commandsSize = commands.size();
        for (int i = commandsSize - 1; i >= 0; --i) {
            Command lastCommand = (Command) commands.get(i);
            if (lastCommand.isExecuted && !lastCommand.getDoneUndo() && lastCommand.isSameCanvas()) {
                undoTargetIndex = i;
                return true;
            }
        }
        return false;
    }
    public boolean canRedo() {
        if (undos.isEmpty()) {
            return false;
        }
        Command lastCommand = (Command) undos.peek();
        return lastCommand.isExecuted && lastCommand.doneUndo;
    }
    public boolean undo() {
        if (canUndo()) {
            ICommand lastCommand = commands.get(undoTargetIndex);
            lastCommand.undo();
            undos.add(lastCommand);

            return true;
        }
        return false;
    }
    public boolean redo() {

        if (canRedo()) {
            ICommand lastUndo = undos.pop();
            lastUndo.redo();

            return true;
        }
        return false;
    }
}
