/** Adapted from journaldev.com */

import java.util.Scanner;
public class ATM {

    public static void main(String[] args) {
        Dispenser c1  = new Dollar50Dispenser();
        Dispenser c2 = new Dollar20Dispenser();
        Dispenser c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextDispenser(c2);
        c2.setNextDispenser(c3);
        int amount = 0;
        System.out.println("Enter amount to dispense");
        Scanner input = new Scanner(System.in);
        amount = input.nextInt();
        if (amount % 10 == 0) {
            c1.dispense(amount);
        } else System.out.println("Amount should be in multiple of 10s.");
    }

}