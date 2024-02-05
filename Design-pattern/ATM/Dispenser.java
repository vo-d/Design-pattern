public abstract class Dispenser {

    protected Dispenser dispenser;

    public void setNextDispenser(Dispenser nextDispenser){
        this.dispenser=nextDispenser;
    }
    
    public abstract void dispense(int cur);
}

