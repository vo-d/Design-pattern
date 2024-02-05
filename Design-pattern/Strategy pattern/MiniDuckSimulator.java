/**
 * From Head First Design Patterns, Freeman & Robson
 */

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.swim();
        mallard.performQuack();
        mallard.performFly();
        System.out.println("---------------------");
    
    }

}
