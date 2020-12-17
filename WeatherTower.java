public class WeatherTower extends Tower{
    public String getWeather(Coordinates coord){
        WeatherProvider wp = new WeatherProvider();
        return (wp.getCurrentWeather(coord));
    }

    private void changeWeather(){

    }
}