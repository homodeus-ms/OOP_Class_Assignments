package academy.pocu.comp2500.assignment4;

import java.util.ArrayList;
import java.util.Stack;

public class CommandHistoryManager {

    private final Canvas canvas;
    private Stack<ICommand> commands = new Stack<>();
    private Stack<ICommand> undos = new Stack<>();
    //private String currCanvas;
    private int undoTargetIndex = -1;

    public CommandHistoryManager(final Canvas canvas) {
        this.canvas = canvas;
        //currCanvas = canvas.getDrawing();
    }
    public boolean execute(ICommand command) {

        commands.push(command);
        boolean bExcuted = command.execute(canvas);
        if (bExcuted) {
            undos.clear();
        }

        return bExcuted;
    }
    public boolean canUndo() {
        if (commands.isEmpty()) {
            return false;
        }
        /*int commandsSize = commands.size();*/
        /*for (int i = commandsSize - 1; i >= 0; --i) {
            Command lastCommand = (Command) commands.get(i);
            if (lastCommand.isExecuted && !lastCommand.getDoneUndo() && lastCommand.isSameCanvas()) {
                undoTargetIndex = i;
                return true;
            }
        }*/
        return true;
    }
    public boolean canRedo() {
        if (undos.isEmpty()) {
            return false;
        }
        /*Command lastCommand = (Command) undos.peek();
        return lastCommand.isExecuted && lastCommand.doneUndo;*/
        return true;
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
