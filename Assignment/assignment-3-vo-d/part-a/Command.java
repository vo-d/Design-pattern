/** From Head First Design Patterns, Freeman & Robson et al. */  

public abstract class Command implements Cloneable{
    public abstract void execute();
    public abstract void undo();
    public Logger logger = Logger.getLogger();
    
    public Object clone() {
        try {
            return (Command)super.clone();
        }
        catch(CloneNotSupportedException e) {
            System.out.println("Clone not supported " + e.getMessage());
            return null;
        }     
    }
    public void logCommand(){
        logger.log(this.getClass().getName());
    }
    public void executeWithLog(){
        this.execute();
        logCommand();
    }

    public void undoWithLog(){
        this.undo();
        logCommand();
    }
}
