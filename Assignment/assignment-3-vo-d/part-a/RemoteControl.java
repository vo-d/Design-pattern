import java.util.EmptyStackException;
import java.util.Stack;
import java.lang.CloneNotSupportedException;
/** From Head First Design Patterns, Freeman & Robson et al. */  

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> undoStack = new Stack<Command>();
    private Stack<Command> redoStack = new Stack<Command>();

    public RemoteControl() {
        final int NUM_COMMANDS = 7;
        onCommands = new Command[NUM_COMMANDS];
        offCommands = new Command[NUM_COMMANDS];

        Command noCommand = new NoCommand();
        for (int i = 0; i < NUM_COMMANDS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        Command clone = (Command)onCommands[slot].clone();
        undoStack.push(clone);
        //onCommands[slot].execute();
        onCommands[slot].executeWithLog();
    }

    public void offButtonWasPushed(int slot) {
        Command clone = (Command)offCommands[slot].clone();
        undoStack.push(clone);
        //offCommands[slot].execute();
        offCommands[slot].executeWithLog();
    }

    public void undoButtonWasPushed() {
        try{
            Command clone = undoStack.pop();
            //clone.undo();
            clone.undoWithLog();
            redoStack.push(clone);
        }
        catch(EmptyStackException e){
            System.out.println("Nothing to undo");
        }
        
    }

    public void redoButtonWasPushed() {
        try{
            Command clone = redoStack.pop();
            //clone.execute();
            clone.executeWithLog();
            undoStack.push(clone);
        }
        catch(EmptyStackException e){
            System.out.println("Nothing to redo");
        }
    }

    /* for debugging / testing */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                + "    " + offCommands[i].getClass().getName() + "\n");
        }
        return sb.toString();
    }
} 