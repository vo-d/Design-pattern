import java.util.ArrayList;
import java.util.Random;

public class Level3 extends GameLevel{
    Random ran = new Random();
    int ranNum = 0;

    

    public Level3(String world){
        super(world);

        
        ArrayList<Enemy> enemylist = new ArrayList<Enemy>();
        for (int i = 0; i < 10; i++){
            enemylist.add(piranhaPlant);
        }
        for (int i = 0; i < 10; i++){
            enemylist.add(koopaTroopa);
        }
        for (int i = 0; i < 10; i++){
            enemylist.add(goomba);
        }
        ArrayList<Enemy> enemyRanList = new ArrayList<Enemy>();
        for(int i = 30; i > 0; i --){
            ranNum = ran.nextInt(i);
            enemyRanList.add(enemylist.remove(ranNum));
        }
        this.enemies = enemyRanList;
    }
    public void createEnemies(){
        renderEnvironemnt();
        renderEnemies();
        spawnEnemies();
    }
    @Override
    public String toString(){
        return "\nCompleted playing " + getName() + " Level 3";
    }
}
