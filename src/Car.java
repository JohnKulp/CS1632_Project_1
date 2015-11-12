import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by otter on 10/6/15.
 */
public class Car {
    private int carNumber;
    private Intersection currentLocation;

    public Car(int carNumber){
        this.carNumber = carNumber;
        currentLocation = null;
    }

    public int getCarNumber(){
        return carNumber;
    }

    public Intersection getCurrentLocation(){
        return currentLocation;
    }
    public void setCurrentLocation(Intersection intersection){
        currentLocation = intersection;
    }
    public Intersection chooseDirection(Random rand){
        if(currentLocation == null){
            return null;
        }

        ArrayList<Avenue> avenues = currentLocation.getAvenues();
        ArrayList<Street> streets = currentLocation.getStreets();

        int totalSize = avenues.size() + streets.size();

        int numChosen = rand.nextInt(totalSize);
        //the chosen value is a street
        if(numChosen >= avenues.size()){
            Street result = streets.get(numChosen - avenues.size());
            if(result.getLocA().getLocationName().equals(currentLocation.getLocationName())){
                return result.getLocB();
            }
            else return result.getLocA();
        }
        //the chosen value is an avenue
        else{
            LinkedList<Intersection> result = avenues.get(numChosen).getIntersections();
            //this can never be the last intersection because the main loop stops as soon as the last intersection is hit
            return result.get(result.indexOf(currentLocation) + 1);
        }
    }
}
