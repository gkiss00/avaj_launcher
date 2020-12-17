import java.util.Random;

public class WeatherProvider{
    private WeatherProvider weatherProvider;
    private String[] weather;

    public WeatherProvider(){

    }

    public WeatherProvider getWeatherProvider(){
        return (this);
    }

    public String getCurrentWeather(Coordinates coord){
        Random rand = new Random();
        String weather[] = {"SUN", "RAIN", "FOG", "SNOW"};
        int latitude = coord.getLatitude();
        int longitude = coord.getLongitude();
        int height = coord.getHeight();
        int r;
        int x;

        r = rand.nextInt(height);
        if (r < 75){
            x = rand.nextInt(3);
        }else{
            x = rand.nextInt(4);
        }
        return (weather[x]);
    }
}