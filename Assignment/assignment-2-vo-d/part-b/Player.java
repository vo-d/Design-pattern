/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public class Player {
    public int health;
    public Weapon sword;
    public Weapon specialWeapon;

    
    public Player(int health){
        this.health = health;
        this.sword = null;
        this.specialWeapon = null;
    }
    public Player(int health, Weapon sword){
        this.health = health;
        this.sword = sword;
    }
    
    public int getHealth(){
        return this.health;
    }
    public Weapon getSword(){
        return this.sword;
    }
    public Weapon getspecialWeapon(){
        return this.specialWeapon;
    }

    public void setHealth(int health){
        this.health = health;
    }
    public void setSword(Weapon sword){
        this.sword = sword;
    }
    public void setspecialWeapon(Weapon specialWeapon){
        this.specialWeapon = specialWeapon;
    }
}

