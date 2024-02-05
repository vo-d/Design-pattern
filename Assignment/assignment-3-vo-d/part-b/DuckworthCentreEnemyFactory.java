public class DuckworthCentreEnemyFactory implements EnemyFactory {
    public PiranhaPlantSpecies createPiranhaPlant(){
        PiranhaPlant piranhaPlant = new PiranhaPlant();
        return piranhaPlant;
    };
    
    public GoombaSpecies createGoomba(){
        Galoomba galoomba = new Galoomba();
        return galoomba;
    };
    
    public KoopaTroopaSpecies createKoopaTroopa(){
        KoopaTroopa koopaTroopa = new KoopaTroopa();
        return koopaTroopa;
    };

    

}

