public class CentennialHall extends GameWorld{
    public GameLevel createLevel(int level){
        GameLevel gameLevel = null;
        if (level == 1){
            gameLevel = new Level1("Centennial");

            gameLevel.setName(toString());
            System.out.println("***Setting up "+gameLevel.getName()+" Level 1***");
            gameLevel.createEnemies();


            return gameLevel;
        }
        else if (level == 2){
            gameLevel = new Level2("Centennial");

            gameLevel.setName(toString());
            System.out.println("***Setting up "+gameLevel.getName()+" Level 2***");
            gameLevel.createEnemies();


            return gameLevel;
        }
        else if (level == 3){
            gameLevel = new Level3("Centennial");

            gameLevel.setName(toString());
            System.out.println("***Setting up "+gameLevel.getName()+" Level 3***");
            gameLevel.createEnemies();


            return gameLevel;
        }
        return gameLevel;
    }
    public String toString(){
        return "Centennial Hall";
    }
}

