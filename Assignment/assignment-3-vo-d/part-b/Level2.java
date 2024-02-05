public class Level2 extends GameLevel{
    public Level2(String world){
        super(world);
        for (int i = 0; i < 7; i++){
            enemies.add(goomba);
        }
        for (int i = 0; i < 8; i++){
            enemies.add(piranhaPlant);
        }
        for (int i = 0; i < 15; i++){
            enemies.add(koopaTroopa);
        }
    }
    public void createEnemies(){
        renderEnvironemnt();
        renderEnemies();
        spawnEnemies();
    }
    @Override
    public String toString(){
        return "\nCompleted playing " + getName() + " Level 2";
    }
}
