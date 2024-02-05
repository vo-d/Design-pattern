/** Adapted from dofactory.com */

public class President extends Approver{
    
    public President (String name){
        super(name);
    }
    
    public void processRequest(Purchase purchase)
    {
      if (purchase.getAmount() < 100000.0){
        System.out.println("President "+name+" approved request# "
            +purchase.getNumber());
      }
      else{
        System.out.println("Request# "+purchase.getNumber()
        +" requires an executive meeting!");
      }
    }
  }