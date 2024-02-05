/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */
public class FoodAdapter extends Weapon{
    private Food food;

    public FoodAdapter(Food food){
        super(food.getDescription());
        this.food = food;
    }

    public String getDescription(){
        return this.food.getDescription() + "-mer";
    }
    public int damage(){
        return this.food.getEnergy() /10;
    }
    public int durability(){
        return 0;
    }
}
