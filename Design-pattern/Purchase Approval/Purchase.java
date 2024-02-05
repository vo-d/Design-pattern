/** Adapted from dofactory.com */

public class Purchase{
    private int number;
    private double amount;
    private String purpose;

    public Purchase(int number, double amount, String purpose){
      this.number = number;
      this.amount = amount;
      this.purpose = purpose;
    }

    public int getNumber(){
      return number;
    }
    
    public void setNumber(int number){
      this.number = number;
    }

    public double getAmount(){
      return amount; 
    }
    
    public void setAmount(double amount)
    {
      this.amount = amount; 
    }
 
    public String getPurpose(){
      return purpose;
    }
    
    public void getPurpose(String purpose){
      this.purpose = purpose;
    }
  }