package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {

    private final Canvas canvas;
    private ICommand recentCommand;
    private ICommand recentUndo;

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;

    }
    public boolean execute(ICommand command) {
        boolean isExecuted = command.execute(canvas);
        if (isExecuted) {
            recentCommand = command;
        }
        recentUndo = null;

        return isExecuted;
    }
    public boolean canUndo() {
        return recentCommand != null;
    }
    public boolean canRedo() {
        return recentUndo != null;
    }
    public boolean undo() {
        if (canUndo()) {
            recentCommand.undo();
            recentUndo = recentCommand;
            recentCommand = null;
            return true;
        }
        return false;
    }
    public boolean redo() {
        if (canRedo()) {
            recentUndo.redo();
            recentCommand = recentUndo;
            recentUndo = null;
            return true;
        }
        return false;
    }
}
