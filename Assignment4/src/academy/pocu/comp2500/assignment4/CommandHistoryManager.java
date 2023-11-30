package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.Stack;

public class CommandHistoryManager {

    private final Canvas canvas;
    private Stack<ICommand> commands = new Stack<>();
    private Stack<ICommand> undos = new Stack<>();

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;

    }
    public boolean execute(ICommand command) {

        commands.push(command);
        boolean bExecuted = command.execute(canvas);
        if (bExecuted) {
            undos.clear();
        }

        return bExecuted;
    }
    public boolean canUndo() {
        if (commands.isEmpty()) {
            return false;
        }
        for (ICommand command : commands) {
            if (((Command) command).isExecuted && !((Command) command).doneUndo) {
                return true;
            }
        }

        return false;
    }
    public boolean canRedo() {
        return !undos.isEmpty();
    }
    public boolean undo() {
        if (canUndo()) {
            int size = commands.size();
            for (int i = size - 1; i >= 0; --i) {
                if (commands.elementAt(i).undo()) {
                    undos.push(commands.elementAt(i));
                    return true;
                }
            }
        }
        return false;
    }
    public boolean redo() {

        if (canRedo()) {
            int size = undos.size();
            for (int i = size - 1; i >= 0; --i) {
                if (undos.elementAt(i).redo()) {
                    undos.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}
