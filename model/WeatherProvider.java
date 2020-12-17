import java.util.Random;

public class WeatherProvider{
    private WeatherProvider weatherProvider;
    private final String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    public WeatherProvider(){

    }

    public WeatherProvider getWeatherProvider(){
        return (this);
    }

    public String getCurrentWeather(Coordinates coord){
        Random rand = new Random();
        int latitude = coord.getLatitude();
        int longitude = coord.getLongitude();
        int height = coord.getHeight();
        int x;

        height += 1;
        height = rand.nextInt(height);
        if (height > 75){
            x = rand.nextInt(2) + 2;
        }else{
            x = rand.nextInt(4);
        }
        System.out.println(x);
        return (this.weather[x]);
    }
}