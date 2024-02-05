/** From Head First Design Patterns, Freeman & Robson et al. */ 

import java.util.Scanner;

public class TeaWithHook extends CaffeineBeverageWithHook {
 
    public void brew() {
        System.out.println("Steeping the tea");
    }
 
    public void addCondiments() {
        System.out.println("Adding Lemon");
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
        System.out.print("Would you like lemon with your tea (y/n)? ");
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }
}
