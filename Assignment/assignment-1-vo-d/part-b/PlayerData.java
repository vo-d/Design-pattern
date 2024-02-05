/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
import java.util.ArrayList;

public class PlayerData implements Subject{

    // fields
    int health;
    int coin;
    String item;
    ArrayList<Observer> observers;

    // constructor
    public PlayerData(){
        this.health = 10;
        this.coin = 1;
        this.item = "";
        this.observers = new ArrayList<Observer>();

        // add HUD and achievement observer into the list of observer
        HUD hud = new HUD();
        this.observers.add(hud);
        Achievement achievement = new Achievement();
        this.observers.add(achievement);
        hud.update(this.health, this.coin, this.item);
    }

    //getter
    public int getCoin(){
        return this.coin;
    }
    public int getHealth(){
        return this.health;
    }
    public String getItem(){
        return this.item;
    }

    //setter
    public void addCoin(){
        this.coin += 1;
    }
    public void addItem(String item){
        this.item = item;
    }
    public void addHealth(int health){
        this.health += health;
    }

    // add, remove, and update observers
    public void registerObserver(Observer observer){
        this.observers.add(observer);
    }
    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }
    public void notifyObservers(){
        for (Observer observer : this.observers){
            observer.update(this.health, this.coin, this.item);
            observer.display();
        }
    }

}