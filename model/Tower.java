
public class Tower {
    private Flyable[] flyables = new Flyable[0];

    public void register(Flyable flyable){
        Flyable[] tmp = new Flyable[this.flyables.length + 1];
        for (int i = 0; i < this.flyables.length; ++i){
            tmp[i] = this.flyables[i];
        }
        tmp[this.flyables.length] = flyable;
        this.flyables = tmp;
    }

    public void unRegister(Flyable flyable){
        
    }

    protected void conditionsChanged(){
        
    }
}