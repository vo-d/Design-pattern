/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public class Achievement implements Observer{

    //fields 
    int health = 0;
    int coinCount = 0;
    String item = "";

    int previousHealth = 0;
    int previousCoinCount = 0;
    String previousItem = "";

    // constructor
    public Achievement(){}

    // Display the achievement
    public void display(){

        // if the coin count reach 10, the achievement will appear, but will disappear if the coin is still at 10 after the round after that
        if ((this.coinCount == 10) && (this.previousCoinCount != 10)){
            System.out.println("*** Achievement unlocked:   Livin’ Large!***");
        }

        // Only display this achievement when you don't have pizza in the item slot
        if ((this.item.equals("pizza")) && !(this.previousItem.equals("pizza"))){
            System.out.println("*** Achievement unlocked:   ‘Za Bomb!***");
        }

        // only display this achievement one time
        if((this.health == 100) && (this.previousHealth != 100)){
            System.out.println("*** Achievement unlocked:  Hearty!***");
        }
    }

    // update the info to display the achievement
    public void update(int health, int coinCount, String newItem){
        this.previousItem = this.item;
        this.previousHealth = this.health;
        this.previousCoinCount = this.coinCount;

        this.health = health;
        this.coinCount = coinCount;
        this.item = newItem;
    }
    
}