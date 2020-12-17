public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    //@Override
    public void updateConditions(){
        WeatherProvider wp = new WeatherProvider();
        String actualWheater = wp.getCurrentWeather(this.coordinates);

        if(actualWheater.compareTo("SUN") == 0){
            this.updateCoordinates(2, 0, 4);
        }else if(actualWheater.compareTo("RAIN") == 0){
            this.updateCoordinates(0, 0, 5);
        }else if(actualWheater.compareTo("FOG") == 0){
            this.updateCoordinates(0, 0, 3);
        }else{
            this.updateCoordinates(0, 0, -15);
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
        str += "JetPlane";
        str += this.name;
        str += "#";
        str += "(";
        str += this.id;
        str += ")";
        return (str);
    }
}