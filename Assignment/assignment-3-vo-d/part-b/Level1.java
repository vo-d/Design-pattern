import java.util.ArrayList;

public class Level1 extends GameLevel{
    public Level1(String world){
        super(world);
        
        ArrayList<Enemy> enemylist = new ArrayList<Enemy>();
        for (int i = 0; i < 7; i++){
            enemylist.add(piranhaPlant);
        }
        for (int i = 0; i < 7; i++){
            enemylist.add(koopaTroopa);
        }
        for (int i = 0; i < 7; i++){
            enemylist.add(goomba);
        }
        this.enemies = enemylist;
    }
    public void createEnemies(){
        renderEnvironemnt();
        renderEnemies();
        spawnEnemies();
    }
    @Override
    public String toString(){
        return "\nCompleted playing " + getName() + " Level 1";
    }
}
