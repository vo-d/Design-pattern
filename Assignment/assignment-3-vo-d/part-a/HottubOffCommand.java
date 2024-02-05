public class HottubOffCommand extends Command {
    HotTub hottub;

    public HottubOffCommand(HotTub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.setTemperature(98);
        hottub.off();
    }

    public void undo() {
        hottub.on();
    }

}
