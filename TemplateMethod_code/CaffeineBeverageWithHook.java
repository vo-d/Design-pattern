/** From Head First Design Patterns, Freeman & Robson et al. */ 

public abstract class CaffeineBeverageWithHook {
 
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }
 
    abstract void brew();
 
    abstract void addCondiments();
 
    void boilWater() {
        System.out.println("Boiling water");
    }
 
    void pourInCup() {
        System.out.println("Pouring into cup");
    }
 
    boolean customerWantsCondiments() {
        return true;
    }
}
