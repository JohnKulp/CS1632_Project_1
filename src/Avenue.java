import java.util.LinkedList;

/**
 * Created by root on 10/12/15.
 */
public class Avenue {
    private LinkedList<Intersection> intersections;
    private String name;

    public Avenue(String name, LinkedList<Intersection> intersections){
        this.name = name;
        this.intersections = intersections;
    }
    public Avenue(String name){
        this.name = name;
        this.intersections = new LinkedList<>();
    }

    public LinkedList<Intersection> getIntersections(){
        return intersections;
    }
    public void setIntersections(LinkedList<Intersection> intersections){
        this.intersections = intersections;
    }
    public String getName(){
        return name;
    }
}
