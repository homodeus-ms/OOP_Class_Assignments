package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.Stack;

public class CommandHistoryManager {

    private final Canvas canvas;
    private Stack<ICommand> commands = new Stack<>();
    private Stack<ICommand> undos = new Stack();

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;
        
    }
    public boolean execute(ICommand command) {
        boolean isExecuted = command.execute(canvas);
        if (isExecuted) {
            commands.push(command);
            undos.clear();
        }
        //recentUndo = null;

        return isExecuted;
    }
    public boolean canUndo() {
        return !commands.isEmpty();
    }
    public boolean canRedo() {
        return !undos.isEmpty();
    }
    public boolean undo() {
        if (canUndo()) {
            ICommand lastCommand = commands.pop();
            lastCommand.undo();
            undos.push(lastCommand);

            return true;
        }
        return false;
    }
    public boolean redo() {

        if (canRedo()) {
            ICommand lastUndo = undos.pop();
            lastUndo.redo();
            // redo를 하면 undo가 리셋 된다고 가정해야할까?
            //commands.clear();
            commands.push(lastUndo);

            return true;
        }
        return false;
    }
}
