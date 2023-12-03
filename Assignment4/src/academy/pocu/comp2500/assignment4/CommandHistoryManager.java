package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.Stack;

public class CommandHistoryManager {

    private final Canvas canvas;
    private ArrayList<ICommand> commands = new ArrayList<>();
    private ArrayList<ICommand> undos = new ArrayList<>();

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;

    }
    public boolean execute(ICommand command) {

        commands.add(command);
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
                if (commands.get(i).undo()) {
                    undos.add(commands.get(i));
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
                if (undos.get(i).redo()) {
                    undos.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}
