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
        }else if(actualWheater.compareTo("RAIN") == 0){
            this.updateCoordinates(0, 5, 0);
        }else if(actualWheater.compareTo("FOG") == 0){
            this.updateCoordinates(0, 1, 0);
        }else{
            this.updateCoordinates(0, 0, -7);
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