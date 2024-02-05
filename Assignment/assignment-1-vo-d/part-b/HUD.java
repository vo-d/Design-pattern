/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public class HUD implements Observer{

    // fields
    int health;
    int coinCount;
    String item;

    // Constructor
    public HUD(){
        this.health = 10;
        this.coinCount = 1;
    }

    // Method to display the hud
    public void display(){
        
        // if the item is not poison
        if (!this.item.equals("poison")){

            // if the item is coin, print unique line for collecting coin
            if (this.item.equals("coin")){
                System.out.println("[Collected the coin]");
            }
            // if the item is not coin, print unique line for getting item
            else{
                System.out.println("[Ate the " + this.item + "]");
            }

            int heartAmount = this.health/10;
            char heart= '♥';
            String heartDisplay = "";
            String space = " ";

            // Add a heart for each 10 health received
            for (int i =0; i<heartAmount; i++){
                heartDisplay = heartDisplay + heart;
            }
            // add space after those heart to maintain good look
            for (int i =0; i< 28 - heartAmount; i++){
                heartDisplay = heartDisplay + space;
            }
            System.out.println("--------------------------------\n| "+ heartDisplay +" |\n--------------------------------\n" + this.coinCount +" ⦷");
        }
        else{
            System.out.println("[Ate the poison]\n*** Game over :( ***");
        }
        
    }

    // update the HUD observer with info
    public void update(int health, int coinCount, String item){
        this.health = health;
        this.coinCount = coinCount;
        this.item = item;
    }
}