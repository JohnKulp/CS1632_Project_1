import java.util.ArrayList;

/**
 * Created by otter on 10/8/15.
 */
public class Intersection {
    private String locationName;
    private ArrayList<Street> streets;
    private ArrayList<Avenue> avenues;


    public Intersection(String locationName){
        this.avenues = new ArrayList<>();
        this.locationName = locationName;
        streets = new ArrayList<>();
    }




    public void addStreet(Street newStreet){
        streets.add(newStreet);
    }

    public ArrayList<Street> getStreets(){
        return streets;
    }

    public ArrayList<Avenue> getAvenues(){
        return avenues;
    }
    public void addAvenue(Avenue avenue){
        this.avenues.add(avenue);
    }

    public String getLocationName(){
        return locationName;
    }
    public void setLocationName(String locationName){
        this.locationName = locationName;
    }
}
