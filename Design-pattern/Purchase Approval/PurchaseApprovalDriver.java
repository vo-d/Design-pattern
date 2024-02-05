/** Adapted from dofactory.com */

import java.util.Scanner;
public  class PurchaseApprovalDriver{
    public static void main(String[] args){
        // Setup Chain of Responsibility starting with Jay
        Approver jay = new Director("Jay");
        Approver kobey = new VicePresident("Kobey");
        Approver daniel = new President("Daniel");

        jay.setSuccessor(kobey);
        kobey.setSuccessor(daniel);

        // Generate and process purchase requests
        jay.processRequest(new Purchase(2034, 350.00, "Assets"));        
        jay.processRequest(new Purchase(2035, 32590.10, "Project X"));
        jay.processRequest(new Purchase(2036, 24999.99, "Project Y"));
        jay.processRequest(new Purchase(2037, 122100.00, "Project Z"));
    }
}