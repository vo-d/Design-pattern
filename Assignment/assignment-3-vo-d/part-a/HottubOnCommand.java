/** From Head First Design Patterns, Freeman & Robson et al. */ 

public class HottubOnCommand extends Command {
    HotTub hottub;

    public HottubOnCommand(HotTub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.on();
        hottub.setTemperature(104);
        hottub.circulate();
    }

    public void undo() {
        hottub.off();
    }

}
