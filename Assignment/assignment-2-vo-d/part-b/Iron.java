/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public class Iron extends WeaponDecorator {
    public Iron(Weapon weapon){
        super(weapon);
    }

    public String getDescription(){
        return "Iron " + weapon.getDescription();
    }
    public int damage(){
        return 1 + weapon.damage();
    }
    public int durability(){
        return 1 + weapon.durability();
    }
}
