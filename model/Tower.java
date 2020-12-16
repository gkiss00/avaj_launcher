import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> flyables = new ArrayList<Flyable>();

    public void register(Flyable flyable){

    }

    public void unRegister(Flyable flyable){
        flyables.remove(flyable);
    }

    protected void conditionsChanged(){
        
    }
}