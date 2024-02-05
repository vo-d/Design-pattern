/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public abstract class Food implements Item{
    protected String description;
    protected int energy;

    public Food(String description, int energy){
        this.description = description;
        this.energy = energy;
    }

    public String getDescription(){
        return this.description;
    }
    public int getEnergy(){
        return this.energy;
    }
}