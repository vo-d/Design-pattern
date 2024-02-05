import java.util.ArrayList;

public abstract class GameLevel {
    protected String name;
    protected String environment;
    protected ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    protected PiranhaPlantSpecies piranhaPlant;
    protected KoopaTroopaSpecies koopaTroopa;
    protected GoombaSpecies goomba;

    public GameLevel(String world){
        if (world == "Duckworth"){
            this.environment = "classrooms, labs, fitness facility, gym";
            this.piranhaPlant = new PiranhaPlant();
            this.koopaTroopa = new KoopaTroopa();
            this.goomba = new Goomba();
        }
        else if (world == "Centennial"){
            this.environment = "classrooms, cafeteria, security, escalators";
            this.piranhaPlant = new PoisonPiranhaPlant();
            this.koopaTroopa = new DryBonesKoopa();
            this.goomba = new Galoomba();
        }
        else if (world == "Lockhart"){
            this.environment = "lecture halls, classrooms, mezzanine";
            this.piranhaPlant = new GiantPiranhaPlant();
            this.koopaTroopa = new SuperKoopa();
            this.goomba = new GrandGoomba();
        }
    }

    public abstract void createEnemies();

    public void renderEnemies(){
        System.out.println("Rendering enemies...");
    };

    public void spawnEnemies(){
        System.out.print("Spawning enemies: \n");
        for(int i = 0 ; i < enemies.size() -1 ; i ++){
            System.out.print(enemies.get(i) + ", ");
        }
        System.out.print(enemies.get(enemies.size()-1));
    };

    public void renderEnvironemnt(){
        System.out.println("Rendering environment: " + environment);
    };


    public String getName(){
        return this.name;
    };
    public void setName(String name){
        this.name = name;
    };
    public String getEnvironment(){
        return this.environment;
    };
    public void setEnvironemnt(String environment){
        this.environment = environment;
    };
    
}
