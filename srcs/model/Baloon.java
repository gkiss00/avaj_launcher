package model;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;
    private boolean isFlying = true;

    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    //@Override
    public void updateConditions(){
        if (this.isFlying == false)
            return;
        WeatherProvider wp = new WeatherProvider();
        String actualWheater = wp.getCurrentWeather(this.coordinates);

        if(actualWheater.compareTo("SUN") == 0){
            this.updateCoordinates(2, 0, 4);
            System.out.println(this + ": Le temps est bon, le ciel est bleau");
        }else if(actualWheater.compareTo("RAIN") == 0){
            this.updateCoordinates(0, 0, -5);
            System.out.println(this + ": It's raining men, hallelujah, it's raining men, amen");
        }else if(actualWheater.compareTo("FOG") == 0){
            this.updateCoordinates(0, 0, -3);
            System.out.println(this + ": On y voit rien dans ce brouillard");
        }else{
            this.updateCoordinates(0, 0, -15);
            System.out.println(this + ": Saroumane fait tomber a neige");
        }
    }
    //@Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

    public void unregisterTower(){
        if (this.isFlying){
            this.weatherTower = null;
            this.isFlying = false;
            this.lastCoordinates = this.coordinates;
        }
    }

    @Override
    public String toString(){
        String str = "";
        str += "Baloon";
        str += "#";
        str += this.name;
        str += "(";
        str += this.id;
        str += ")";
        return (str);
    }
}