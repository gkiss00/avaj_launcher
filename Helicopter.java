public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    //@Override
    public void updateConditions(){
        WeatherProvider wp = new WeatherProvider();
        String actualWheater = wp.getCurrentWeather(this.coordinates);
        Coordinates previous = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight());

        if(actualWheater.compareTo("SUN") == 0){
            this.updateCoordinates(10, 0, 2);
            System.out.println(this + ": Le temps est bon, le ciel est bleau");
        }else if(actualWheater.compareTo("RAIN") == 0){
            this.updateCoordinates(5, 0, 0);
            System.out.println(this + ": It's raining men, hallelujah, it's raining men, amen");
        }else if(actualWheater.compareTo("FOG") == 0){
            this.updateCoordinates(1, 0, 0);
            System.out.println(this + ": On y voit rien dans ce brouillard");
        }else{
            this.updateCoordinates(0, 0, -12);
            System.out.println(this + ": Saroumane fait tomber a neige");
        }
        if (previous.getHeight() != 0 && this.coordinates.getHeight() == 0){
            System.out.println(this.toString() + " is landing");
            this.weatherTower.unRegister(this);
        }
    }
    //@Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

    @Override
    public String toString(){
        String str = "";
        str += "Helicopter";
        str += "#";
        str += this.name;
        str += "(";
        str += this.id;
        str += ")";
        return (str);
    }
}