public class CentennialHallEnemyFactory  implements EnemyFactory {
    public PiranhaPlantSpecies createPiranhaPlant(){
        PoisonPiranhaPlant poisonPiranhaPlant = new PoisonPiranhaPlant();
        return poisonPiranhaPlant;
    };
    
    public GoombaSpecies createGoomba(){
        Galoomba galoomba = new Galoomba();
        return galoomba;
    };
    
    public KoopaTroopaSpecies createKoopaTroopa(){
        DryBonesKoopa dryBonesKoopa = new DryBonesKoopa();
        return dryBonesKoopa;
    };

    
}

