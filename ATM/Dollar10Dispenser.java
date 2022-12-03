/** Adapted from journaldev.com */

public class Dollar10Dispenser extends Dispenser {

    public void dispense(int currency) {
        int denomination = 10;
        if(currency >= denomination){
            int num = currency / denomination;
            int remainder = currency % denomination;
            System.out.println("Dispensing "+num+" $" + denomination + " bill");
            if(remainder !=0) dispenser.dispense(remainder);
        }
    }
}