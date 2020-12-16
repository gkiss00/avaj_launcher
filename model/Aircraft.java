public abstract class Aircraft{
    protected long id = 1000000;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates){
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId(){
        ++idCounter;
        return (idCounter);
    }

    @Override
    public String toString(){
        String str = "";
        str += this.name;
        str += "#";
        str += "(";
        str += this.id;
        str += ")";
        return (str);
    }
    
    protected int getCoordinates(){
        return (this.coordinates);
    }

    protected void setCoordinates(int lo, int la, int h){
        setLongitude(lo);
        setLatitude(la);
        setHeight(h);
    }

    protected void updateCoordinates(int lo, int la, int h){
        setLongitude(getLongitude() + lo);
        setLatitude(getLatitude() + la);
        setHeight(getHeight() + h);
    }

    public int getLongitude(){
        return this.coordinates.getLongitude();
    }

    public int getLatitude(){
        return this.coordinates.getLatitude();
    }

    public int getHeight(){
        return this.coordinates.getHeight();
    }

    public void setLongitude(int l){
        this.coordinates.setLongitude(l);
    }

    public void setLatitude(int l){
        this.coordinates.setLatitude(l);
    }

    public void setHeight(int h){
        this.coordinates.setHeight(h);
    }
}