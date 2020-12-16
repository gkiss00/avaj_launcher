public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    //@Override
    public void updateConditions(){
        Weather actual = Weather.SUN;
        if(actual ==  Weather.SUN){
            this.upadteCoordinates(10, 0, 2);
        }else if(actual ==  Weather.RAIN){
            this.upadteCoordinates(5, 0, 0);
        }else if(actual ==  Weather.FOG){
            this.upadteCoordinates(1, 0, 0);
        }else{
            this.upadteCoordinates(0, 0, -12);
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
        str += "Helicopter";
        str += this.name;
        str += "#";
        str += "(";
        str += this.id;
        str += ")";
        return (str);
    }
}