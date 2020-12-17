package model;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude(){
        return (longitude);
    }

    public int getLatitude(){
        return (latitude);
    }

    public int getHeight(){
        return (height);
    }

    public void setLongitude(int l){
        longitude = l;
    }

    public void setLatitude(int l){
        latitude = l;
    }

    public void setHeight(int h){
        if (h < 0)
            height = 0;
        else if (h > 100)
            height = 100;
        else
            height = h;
    }
}