/**
 * Created by otter on 10/8/15.
 */

public class Street {
    private Intersection locA;
    private Intersection locB;
    private String name;

    public Street(String name, Intersection locA, Intersection locB){
        this.name = name;
        this.locA = locA;
        this.locB = locB;
    }
    public Street(){
        this.name = "";
        this.locA = null;
        this.locB = null;
    }

    public void setLocA(Intersection locA){
        this.locA = locA;
    }
    public Intersection getLocA(){
        return locA;
    }

    public void setLocB(Intersection locB){
        this.locB = locB;
    }
    public Intersection getLocB(){
        return locB;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
