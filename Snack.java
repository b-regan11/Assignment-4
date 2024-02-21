public class Snack {
    private int cost;
    private String name;
    
    public Snack(int cst, String nm){
        if(cst <= 0)
            throw new IllegalArgumentException("Cost must be greater than 0: "+cst);
        cost = cst;
        name = nm;
    }
    public int getCost(){
        return cost;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name + " Cost = $"+cost;
    }
}
