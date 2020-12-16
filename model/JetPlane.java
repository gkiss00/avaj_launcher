public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    //@Override
    public void updateConditions(){
        Weather actual = Weather.SUN;
        if(actual ==  Weather.SUN){
            this.upadteCoordinates(2, 0, 4);
        }else if(actual ==  Weather.RAIN){
            this.upadteCoordinates(0, 0, 5);
        }else if(actual ==  Weather.FOG){
            this.upadteCoordinates(0, 0, 3);
        }else{
            this.upadteCoordinates(0, 0, -15);
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