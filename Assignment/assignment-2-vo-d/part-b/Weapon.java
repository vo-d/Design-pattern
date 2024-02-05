/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public abstract class Weapon implements Item{
    protected String description;

    public Weapon(){
        this.description = "unknown weapon";

    }
    public Weapon(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
    public abstract int damage();
    public abstract int durability();
    

}