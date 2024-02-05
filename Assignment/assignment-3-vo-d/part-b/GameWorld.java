public abstract class GameWorld {
    public abstract GameLevel createLevel(int level);

    public GameLevel playLevel(int level){
        GameLevel gameLevel = createLevel(level);
        return gameLevel;
    };
}
