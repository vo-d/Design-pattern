/**
 * From Head First Design Patterns, Freeman & Robson
 */

public class MallardDuck extends Duck {
    
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
