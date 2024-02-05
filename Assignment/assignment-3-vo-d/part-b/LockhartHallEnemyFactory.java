public class LockhartHallEnemyFactory  implements EnemyFactory {
    public PiranhaPlantSpecies createPiranhaPlant(){
        GiantPiranhaPlant giantPiranhaPlant = new GiantPiranhaPlant();
        return giantPiranhaPlant;
    };
    
    public GoombaSpecies createGoomba(){
        GrandGoomba grandGoomba = new GrandGoomba();
        return grandGoomba;
    };
    
    public KoopaTroopaSpecies createKoopaTroopa(){
        SuperKoopa superKoopa = new SuperKoopa();
        return superKoopa;
    };

}
