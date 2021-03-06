package model;

public interface Flyable{

    public String toString();

    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);

    public void unregisterTower();
}