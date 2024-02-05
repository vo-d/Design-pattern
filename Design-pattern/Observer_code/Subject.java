/**
 * From Head First Design Patterns, Freeman & Robson
 */

public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
