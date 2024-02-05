/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public class Sword extends Weapon{
    public Sword(){
        super("sword");
    }

    public String getDescription(){
        return this.description;
    }
    public int damage(){
        return 2;
    }
    public int durability(){
        return 1;
    }

}