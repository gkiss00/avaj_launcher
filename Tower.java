
public class Tower {
    private Flyable[] flyables = new Flyable[0];

    public void register(Flyable flyable){
        Flyable[] tmp = new Flyable[this.flyables.length + 1];
        for (int i = 0; i < this.flyables.length; ++i){
            tmp[i] = this.flyables[i];
        }
        tmp[this.flyables.length] = flyable;
        this.flyables = tmp;
        System.out.println("Tower says : " + this.toString() + " registred to weater tower.");
    }

    public void unRegister(Flyable flyable){
        int pos = 0;
        flyable.unregisterTower();
        Flyable[] tmp = new Flyable[this.flyables.length - 1];
        for (int i = 0; i < this.flyables.length; ++i){
            if(this.flyables[i] != flyable){
                tmp[pos] = this.flyables[i];
                ++pos;
            } 
        }
        System.out.println("Tower says " + flyable.toString() + " unregistered from weather tower.");
        this.flyables = tmp;
    }

    protected void conditionsChanged(){
        
    }
}