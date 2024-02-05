import java.io.StreamCorruptedException;

public class MacroCommand extends Command{
    Command[] command; 
    public MacroCommand(Command[] command){
        this.command = command;
    }
    public void execute(){
        for(int i = 0; i < command.length; i ++){
            command[i].execute();
        }
    }
    public void undo(){
        for(int i = 0; i < command.length; i ++){
            command[i].undo();
        }
    }
}