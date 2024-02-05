/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Game2Driver {
    public static void main(String[] args){

        // Create items
        Player player = new Player(10, null);
        Bread bread = new Bread();
        Pizza pizza = new Pizza();
        Poison poison = new Poison();
        Sword sword = new Sword();
        Ham ham = new Ham();

        // These variable will help keeping track of any change in the weapon or special weapon
        Weapon previousWeapon = player.getSword();
        Weapon previousSpecialWeapon = player.getspecialWeapon();


        // Create a list of String that will represent items
        ArrayList<String> itemList = new ArrayList<String>();
        itemList.add(sword.getDescription());
        itemList.add(ham.getDescription());
        itemList.add(bread.getDescription());  
        itemList.add(pizza.getDescription());
        itemList.add(poison.getDescription());
        itemList.add("iron");
        itemList.add("gold");
        itemList.add("diamond");

        // Create a random number generator and get random item string
        Random rng = new Random();
        int ranInt = rng.nextInt(itemList.size());
        String randomItem = itemList.get(ranInt);

        // Get input from player
        int result = JOptionPane.showConfirmDialog(null, randomItem + " :pick up?",null, JOptionPane.YES_NO_OPTION);

        // if this is true, the game will keep running
        boolean playable = true;

        
        while(playable){
            //If random item is bread
            if(randomItem.equals("bread")){

                // if the player want to pick up the item, add player health that is the energy of the bread, display HUD, generate new item and ask the player again
                if (result==0){
                    player.setHealth(player.getHealth() + bread.getEnergy());
                    eatFood( player,  bread);
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }
                // if the player doesn't want to pick up the item, continue asking 
                else{
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }
            }
            //If random item is pizza
            else if(randomItem.equals("pizza")){
                // if the player want to pick up the item, add player health that is the energy of the pizza, display HUD, generate new item and ask the player again
                if (result==0){
                    player.setHealth(player.getHealth() + pizza.getEnergy());
                    eatFood( player,  pizza);
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }
                // if the player doesn't want to pick up the item, continue asking 
                else{
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }
            }

            //If random item is sword
            else if(randomItem.equals("sword")){
                // if the player want to pick up the item, set sword to player weapon, remove sword from the random list, display HUD, generate new item and ask the player again
                if (result==0){
                    player.setSword(sword);
                    int weaponIndex = itemList.indexOf("sword");
                    itemList.remove(weaponIndex);
                    DisplayGetWeapon( previousWeapon,  previousSpecialWeapon,  player,  sword);
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }
                // if the player doesn't want to pick up the item, continue asking 
                else{
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }
            }

            //If random item is ham
            else if(randomItem.equals("ham")){
                // if the player want to pick up the item and doesn't have special weapon, ask the player if want to use ham as weapon
                if (result==0 && player.getspecialWeapon() == null){

                    // Get input from player
                    int result2 = JOptionPane.showConfirmDialog(null," Do you want to use the ham as a weapon?",null, JOptionPane.YES_NO_OPTION);

                    // if player want to use ham as weapon, add ham as special weapon, display HUD, and ask the player again
                    if (result2==0){
                        FoodAdapter hammer = new FoodAdapter(ham);
                        player.setspecialWeapon(hammer);
                        
                        DisplayGetWeapon( previousWeapon,  previousSpecialWeapon,  player,  hammer);
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                    // if player doesn't want to use ham as weapon, eat the ham
                    else{
                        player.setHealth(player.getHealth() + ham.getEnergy());
                        eatFood( player,  ham);
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                    
                }
                // if the player press "yes" and has ham as special weapon, eat the ham, display HUD and ask the user again
                else if (result==0 && player.getspecialWeapon() != null){
                    player.setHealth(player.getHealth() + ham.getEnergy());
                    eatFood( player,  ham);
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }     
                // If player doesn't want to pick up the ham, continue asking           
                else{
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }
            }

            //If random item is iron
            else if(randomItem.equals("iron")){

                // if the player want to pick up the item
                if (result==0){
                    previousWeapon = player.getSword();
                    previousSpecialWeapon = player.getspecialWeapon();

                    // controller will decide which weapon to enhance. If 0, then enhance the sword, if 1 then enhance the special weapon. After enhancing, display HUD, and the game keep running
                    int controller = -1;

                    // if user only has special weapon, controller switch to 1, if user only has sword, controller switch to 0
                    if (player.getSword() == null && player.getspecialWeapon() != null) {
                        controller = 1;
                    }
                    else if (player.getSword() != null && player.getspecialWeapon() == null) {
                        controller = 0;
                    }
                    //  in case the user has both weapon, ask which one to enhance
                    if ((player.getSword() != null && player.getspecialWeapon() != null)){
                        String[] buttons = {"sword", "ham"};
                        controller = JOptionPane.showOptionDialog(null, "Select the weapon to enhance: ", null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[1]);
                    }

                    if(controller == 1){
                        Weapon newSpecialWeapon = new Iron(player.getspecialWeapon());
                        player.setspecialWeapon(newSpecialWeapon);
                        DisplayGetWeapon( previousWeapon,  previousSpecialWeapon,  player,  newSpecialWeapon);
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                    else if(controller == 0){
                        Weapon newSword = new Iron(player.getSword());
                        player.setSword(newSword);
                        DisplayGetWeapon( previousWeapon,  previousSpecialWeapon,  player,  newSword);
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                    // if player doesn't have a weapon, tell the user that he/she doesn't have a weapon,  generate new item and ask the player again
                    else{
                        UpgradeFailedDisplay();
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                }
                // if the player doesn't want to pick up the item, continue asking 
                else{
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }
            }

            //If random item is gold
            else if(randomItem.equals("gold")){
                // if the player want to pick up the item
                if (result==0){
                    previousWeapon = player.getSword();
                    previousSpecialWeapon = player.getspecialWeapon();

                    // controller will decide which weapon to enhance. If 0, then enhance the sword, if 1 then enhance the special weapon. After enhancing, display HUD, and the game keep running
                    int controller = -1;

                    // if user only has special weapon, controller switch to 1, if user only has sword, controller switch to 0
                    if (player.getSword() == null && player.getspecialWeapon() != null) {
                        controller = 1;
                    }
                    else if (player.getSword() != null && player.getspecialWeapon() == null) {
                        controller = 0;
                    }
                    //  in case the user has both weapon, ask which one to enhance
                    if ((player.getSword() != null && player.getspecialWeapon() != null)){
                        String[] buttons = {"sword", "ham"};
                        controller = JOptionPane.showOptionDialog(null, "Select the weapon to enhance: ", null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[1]);
                    }

                    if(controller == 1){
                        Weapon newSpecialWeapon = new Iron(player.getspecialWeapon());
                        player.setspecialWeapon(newSpecialWeapon);
                        DisplayGetWeapon( previousWeapon,  previousSpecialWeapon,  player,  newSpecialWeapon);
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                    else if(controller == 0){
                        Weapon newSword = new Iron(player.getSword());
                        player.setSword(newSword);
                        DisplayGetWeapon( previousWeapon,  previousSpecialWeapon,  player,  newSword);;
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                    // if player doesn't have a weapon, tell the user that he/she doesn't have a weapon,  generate new item and ask the player again
                    else{
                        UpgradeFailedDisplay();
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                }
                // if the player doesn't want to pick up the item, continue asking 
                else{
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }
            }
            //If random item is diamond
            else if(randomItem.equals("diamond")){
                // if the player want to pick up the item 
                if (result==0){
                    previousWeapon = player.getSword();
                    previousSpecialWeapon = player.getspecialWeapon();

                    // controller will decide which weapon to enhance. If 0, then enhance the sword, if 1 then enhance the special weapon. After enhancing, display HUD, and the game keep running
                    int controller = -1;

                    // if user only has special weapon, controller switch to 1, if user only has sword, controller switch to 0
                    if (player.getSword() == null && player.getspecialWeapon() != null) {
                        controller = 1;
                    }
                    else if (player.getSword() != null && player.getspecialWeapon() == null) {
                        controller = 0;
                    }
                    //  in case the user has both weapon, ask which one to enhance
                    if ((player.getSword() != null && player.getspecialWeapon() != null)){
                        String[] buttons = {"sword", "ham"};
                        controller = JOptionPane.showOptionDialog(null, "Select the weapon to enhance: ", null,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[1]);
                    }
                    
                    if(controller == 1){
                        Weapon newSpecialWeapon = new Iron(player.getspecialWeapon());
                        player.setspecialWeapon(newSpecialWeapon);
                        DisplayGetWeapon( previousWeapon,  previousSpecialWeapon,  player,  newSpecialWeapon);
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                    else if(controller == 0){
                        Weapon newSword = new Iron(player.getSword());
                        player.setSword(newSword);
                        DisplayGetWeapon( previousWeapon,  previousSpecialWeapon,  player,  newSword);
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                    // if player doesn't have a weapon, tell the user that he/she doesn't have a weapon,  generate new item and ask the player again
                    else{
                        UpgradeFailedDisplay();
                        randomItem = GetRandomItem(itemList);
                        result = ask_again(randomItem);
                    }
                }
                // if the player doesn't want to pick up the item, continue asking 
                else{
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);
                }
            }  
            //If random item is poison
            else if(randomItem.equals("poison")){
                // if the player want to pick up the item, stop the game
                if (result==0){
                    playable = false;
                    eatPoison();
                }
                // if the player doesn't want to pick up the item, continue asking 
                else{
                    randomItem = GetRandomItem(itemList);
                    result = ask_again(randomItem);

                }
            }
        }
    }
    // Method to ask and get the answer again
    public static int ask_again(String randomItem){
        int result = JOptionPane.showConfirmDialog(null, randomItem + " :pick up?",null, JOptionPane.YES_NO_OPTION);
        return result;
    }

    // Method to get random item
    public static String GetRandomItem(ArrayList<String> itemList){
        Random rng = new Random();
        int ranInt = rng.nextInt(itemList.size());
        String randomItem = itemList.get(ranInt);
        return randomItem;
    }




    // Method to display gameplay when player pick up weapon or enhancement
    public static void DisplayGetWeapon(Weapon previousWeapon, Weapon previousSpecialWeapon, Player player, Item randomItem){
        // if the player pick up enhancement
        if (randomItem instanceof WeaponDecorator){

            // if there is change sword, that means that it has been enhanced, then display custom visual
            if(player.getSword() != previousWeapon){
                String [] weaponDesArray = player.getSword().getDescription().split(" ");
                System.out.println("[Added enhancement: " + weaponDesArray[0] + "]");
                System.out.println(weaponDesArray[weaponDesArray.length - 1] + " | damage: " + player.getSword().damage() +" | durability: " + player.getSword().durability());
                System.out.println();
            }

            // if there is change getspecial weapon, that means that it has been enhanced, then display custom visual
            else if (player.getspecialWeapon() != previousSpecialWeapon){
                String [] weaponDesArray = player.getspecialWeapon().getDescription().split(" ");
                System.out.println("[Added enhancement: " + weaponDesArray[0] + "]");
                System.out.println(weaponDesArray[weaponDesArray.length - 1] + " | damage: " + player.getspecialWeapon().damage() +" | durability: " + player.getspecialWeapon().durability());
                System.out.println();
            }         
        }
        // if the player pick up weapon
        else{
            // if the weapon is a special weapon (FoodAdapter), then display custom visual
            if (randomItem instanceof FoodAdapter){
                System.out.println("[New weapon: " + randomItem.getDescription() + "]");
                System.out.println(player.getspecialWeapon().getDescription() + " | damage: " + player.getspecialWeapon().damage() +" | durability: " + player.getspecialWeapon().durability());
                System.out.println();
            }
            // if the weapon is normal weapon, then display custom visual
            else{
                System.out.println("[New weapon: " + randomItem.getDescription() + "]");
                System.out.println(player.getSword().getDescription() + " | damage: " + player.getSword().damage() +" | durability: " + player.getSword().durability());
                System.out.println();
            }
        }
        
    }
        
    // Method to display custom visual if the player picked up and eat food
    public static void eatFood(Player player, Food food){
        System.out.println("[Ate the " + food.getDescription() + "]");
        System.out.println("Health: " + player.getHealth() + " HP");
        System.out.println();
    }

    // Method to display custom visual if the player picked up an upgrade but doens't have a weapon
    public static void UpgradeFailedDisplay(){
        System.out.println("[You don't have any weapon to upgrade]");
        System.out.println();
    }

    // Method to display custom visual if the player picked up poison
    public static void eatPoison(){
        System.out.println("[Ate the poison]\n*** Game over :( ***");
    }
}

