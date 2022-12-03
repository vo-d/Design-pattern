/** Adapted from dofactory.com */

public class Director extends Approver{
    
    public Director (String name){
        super(name);
    }
    
    public void processRequest(Purchase purchase)
    {
      if (purchase.getAmount() < 10000.0){
        System.out.println("Director "+name+" approved request# "+
           purchase.getNumber());
      }
      else if (successor != null){
        successor.processRequest(purchase);
      }
    }
  }