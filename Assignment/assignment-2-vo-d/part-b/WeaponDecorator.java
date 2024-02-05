/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public abstract class WeaponDecorator extends Weapon{
    protected Weapon weapon;
    public WeaponDecorator(Weapon weapon){
        this.weapon = weapon;
    }
    public abstract String getDescription();
}