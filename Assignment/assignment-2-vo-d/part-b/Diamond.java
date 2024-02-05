/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public class Diamond extends WeaponDecorator {
    public Diamond(Weapon weapon){
        super(weapon);
    }

    public String getDescription(){
        return "Diamond " + weapon.getDescription();
    }
    public int damage(){
        return 2 + weapon.damage();
    }
    public int durability(){
        return 1 + weapon.durability();
    }
}
