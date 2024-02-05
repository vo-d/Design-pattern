/** From Head First Design Patterns, Freeman & Robson et al. */ 

import java.util.Scanner;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    public void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    public boolean customerWantsCondiments() {

        String answer = getUserInput();

        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getUserInput() {
        // get the user's response
        System.out.print("Would you like milk and sugar with your coffee (y/n)? ");
        Scanner kb = new Scanner(System.in);
        return  kb.nextLine();
    }
}
