/**
 * From Head First Design Patterns, Freeman & Robson
 */

public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;
    protected CondimentDecorator(Beverage beverage){
        this.beverage = beverage;
    }
    public abstract String getDescription();
}
