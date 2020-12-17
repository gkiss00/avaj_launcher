public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    //@Override
    public void updateConditions(){
        WeatherProvider wp = new WeatherProvider();
        String actualWheater = wp.getCurrentWeather(this.coordinates);

        if(actualWheater.compareTo("SUN") == 0){
            this.updateCoordinates(0, 10, 2);
            System.out.println(this + ": Le temps est bon, le ciel est bleau");
        }else if(actualWheater.compareTo("RAIN") == 0){
            this.updateCoordinates(0, 5, 0);
            System.out.println(this + ": It's raining men, hallelujah, it's raining men, amen");
        }else if(actualWheater.compareTo("FOG") == 0){
            this.updateCoordinates(0, 1, 0);
            System.out.println(this + ": On y voit rien dans ce brouillard");
        }else{
            this.updateCoordinates(0, 0, -7);
            System.out.println(this + ": Saroumane fait tomber a neige");
        }
    }
    //@Override
    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        System.out.println("Tower says : "
        + this.toString()
        + " registred to weater tower.");
    }

    @Override
    public String toString(){
        String str = "";
        str += "Baloon";
        str += this.name;
        str += "#";
        str += "(";
        str += this.id;
        str += ")";
        return (str);
    }
}