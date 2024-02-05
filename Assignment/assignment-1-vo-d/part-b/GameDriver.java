/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
import javax.swing.JOptionPane;

public class GameDriver {
    public static void main(String[] args){
        // Add item into the list of item
        String[] items = {"coin","bread","ham","pizza","poison"};
 

        //Instantiate new player 
        PlayerData newPlayer = new PlayerData();

        //Start the game
        System.out.println("*************************************\n*** <your awesome game name here> ***\n*************************************");

        //Get random number depend on the size of the item list to get the random item
        int randomGen = (int)(Math.random()*items.length);
        String randomItem = items[randomGen];

        // Get the user input of picking up item or not
        int result = JOptionPane.showConfirmDialog(null, randomItem + " :pick up?",null, JOptionPane.YES_NO_OPTION);

        // if this is true, the game will keep running
        boolean playable = true;

        // If random item is not poison or you press no when it is poison
        while(playable){

            //If random item is coin
            if(randomItem.equals("coin")){
                // if the player press "yes", then add coin and notify the observer
                if (result==0){
                    newPlayer.addCoin();
                    updateItem_notify(newPlayer, "coin", 0);
                    randomItem = GetRandomItem(items);
                    result = ask_again(randomItem);
                }
                // If no, continue asking 
                else{
                    randomItem = GetRandomItem(items);
                    result = ask_again(randomItem);
                }
            }
            //If random item is bread
            else if(randomItem.equals("bread")){
                // if the player press "yes", update the player data with bread as item and add 10 health
                if (result==0){
                    updateItem_notify(newPlayer, "bread", 10);
                    randomItem = GetRandomItem(items);
                    result = ask_again(randomItem);
                }
                // If no, continue asking 
                else{
                    randomItem = GetRandomItem(items);
                    result = ask_again(randomItem);

                }
            }
            //If random item is ham
            else if(randomItem.equals("ham")){
                // if the player press "yes", update the player data with ham as item and add 20 health
                if (result==0){
                    updateItem_notify(newPlayer, "ham", 20);
                    randomItem = GetRandomItem(items);
                    result = ask_again(randomItem);
                }
                // If no, continue asking 
                else{
                    randomItem = GetRandomItem(items);
                    result = ask_again(randomItem);

                }
            }
            //If random item is pizza
            else if(randomItem.equals("pizza")){
                // if the player press "yes", update the player data with pizza as item and add 30 health
                if (result==0){
                    updateItem_notify(newPlayer, "pizza", 30);
                    randomItem = GetRandomItem(items);
                    result = ask_again(randomItem);
                }
                // If no, continue asking 
                else{
                    randomItem = GetRandomItem(items);
                    result = ask_again(randomItem);

                }
            }
            //If random item is poison
            else if(randomItem.equals("poison")){
                // if the player press "yes", update the player data with poison and stop the game
                if (result==0){
                    updateItem_notify( newPlayer,  "poison", 0);
                    playable = false;
                }
                // If no, continue asking 
                else{
                    randomItem = GetRandomItem(items);
                    result = ask_again(randomItem);

                }
            }

        }
    }

    // Method to get random item
    public static String GetRandomItem(String [] items){
        int randomGen = (int)(Math.random()*items.length);
        String randomItem = items[randomGen];
        return randomItem;
    }

    // Method to ask and get the answer again
    public static int ask_again(String randomItem){
        int result = JOptionPane.showConfirmDialog(null, randomItem + " :pick up?",null, JOptionPane.YES_NO_OPTION);
        return result;
    }

    // Method to update the item and notify the observers
    public static void updateItem_notify(PlayerData data, String item, int health){
        int CurrentHealth = data.getHealth();
        data.addItem(item);

        // this if else statement will keep the health at 100 max
        if(CurrentHealth + health <= 100){
            data.addHealth(health);
        }
        else{
            data.addHealth(100-CurrentHealth);
        }
        data.notifyObservers();
    }

    
}
