public class WeatherProvider{
    private WeatherProvider weatherProvider;
    private final String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    public WeatherProvider(){

    }

    public WeatherProvider getWeatherProvider(){
        return (this);
    }

    public String getCurrentWeather(Coordinates coord){
        int latitude = coord.getLatitude();
        int longitude = coord.getLongitude();
        int height = coord.getHeight();
        int x;

        if (height > 75){
            x = ((longitude + latitude) % 2) + 2;
        }else{
            x = ((longitude + latitude) % 4);
        }
        return (this.weather[x]);
    }
}