/**
 * ACS-3913-001 F2022 - Assignment 2
 * Name: Dai Dai Vo - 3129620
 */

public interface Subject{
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}