package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.Stack;

public class CommandHistoryManager {

    private final Canvas canvas;
    private Stack<ICommand> commands = new Stack<>();
    private ICommand recentUndo;

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;

    }
    public boolean execute(ICommand command) {
        boolean isExecuted = command.execute(canvas);
        if (isExecuted) {
            commands.push(command);
        }
        recentUndo = null;

        return isExecuted;
    }
    public boolean canUndo() {
        return !commands.isEmpty();
    }
    public boolean canRedo() {
        return recentUndo != null;
    }
    public boolean undo() {
        if (canUndo()) {
            ICommand lastCommand = commands.pop();
            lastCommand.undo();
            recentUndo = lastCommand;

            return true;
        }
        return false;
    }
    public boolean redo() {
        commands.clear(); // redo를 하면 성공/실패 상관없이 commands history 리셋됨

        if (canRedo()) {
            recentUndo.redo();
            // redo를 하면 undo가 리셋 된다고 가정해야할까?
            commands.push(recentUndo);
            recentUndo = null;
            return true;
        }
        return false;
    }
}
