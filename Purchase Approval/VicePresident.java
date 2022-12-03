/** Adapted from dofactory.com */

public class VicePresident extends Approver{
    public VicePresident (String name){
        super(name);
    }

    public void processRequest(Purchase purchase)
    {
        if (purchase.getAmount() < 25000.0){
            System.out.println("VP "+name+" approved request# "
                +purchase.getNumber());
        }
        else if (successor != null){
            successor.processRequest(purchase);
        }
    }
}