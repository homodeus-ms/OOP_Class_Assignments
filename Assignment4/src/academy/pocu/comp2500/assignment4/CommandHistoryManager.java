package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;

public class CommandHistoryManager {

    private final Canvas canvas;
    private final ArrayList<ICommand> commands;
    private final ArrayList<ICommand> undos;

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;
        commands = new ArrayList<>();
        undos = new ArrayList<>();
    }
    public boolean execute(ICommand command) {
        boolean isExecuted = command.execute(canvas);
        if (isExecuted) {
            commands.add(command);
            undos.clear();
        }
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
            int lastIndex = commands.size() - 1;
            undos.add(commands.get(lastIndex));
            commands.get(lastIndex).undo();
            commands.remove(lastIndex);
            return true;
        }
        return false;
    }
    public boolean redo() {
        if (canRedo()) {
            int lastIndex = undos.size() - 1;
            commands.add(undos.get(lastIndex));
            undos.get(lastIndex).redo();
            undos.remove(lastIndex);
            return true;
        }
        return false;
    }
}
