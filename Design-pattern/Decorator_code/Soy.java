/**
 * From Head First Design Patterns, Freeman & Robson
 */

public class Soy extends CondimentDecorator {


    public Soy(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        return .15 + beverage.cost();
    }
}
