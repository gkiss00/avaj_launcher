public class AircraftFactory{

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        if (type.compareTo("Helicopter") == 0)
            return (new Helicopter(name, new Coordinates(longitude, latitude, height)));
        else if (type.compareTo("JetPlane") == 0)
            return (new JetPlane(name, new Coordinates(longitude, latitude, height)));
        else if (type.compareTo("Baloon") == 0)
            return (new Baloon(name, new Coordinates(longitude, latitude, height)));
        else{
            System.out.println("This type of aricraft doesn't exist");
            return (null);
        }
    }
}