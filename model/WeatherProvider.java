public class WeatherProvider{
    private WeatherProvider weatherProvider;
    private String[] weather;

    public WeatherProvider(){

    }

    public WeatherProvider getWeatherProvider(){
        return (this);
    }

    public String getCurrentWeather(Coordinates coord){
        return("oui");
    }
}