/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public class Gold extends WeaponDecorator {
    public Gold(Weapon weapon){
        super(weapon);
    }

    public String getDescription(){
        return "Gold " + weapon.getDescription();
    }
    public int damage(){
        return 1 + weapon.damage();
    }
    public int durability(){
        return 2 + weapon.durability();
    }
}
