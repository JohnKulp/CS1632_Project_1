
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by otter on 10/6/15.
 */
public class RunSim {
    private Random rand;

    public void setRand(Random rand){
        this.rand = rand;
    }
    public Random getRand(){
        return rand;
    }


    public static void main(String[] args){

        RunSim mainLoop = new RunSim();
        mainLoop.setUpSim(args);
    }

    public void setUpSim(String[] args){
        boolean validArgs = ensureArgs(args);
        if(validArgs){
            //transform a string into a long
            long seed = 0;
            if(args.length == 0){
                seed = new Random().nextInt();
            }
            else{
                for (int i = 0; i < args[0].length(); i++) {
                    char ch = args[0].charAt(i);
                    seed = seed + (long)ch;
                }

            }
            setRand(new Random(seed));
            driverLoop();
        }

    }

    public boolean ensureArgs(String[] args){
        if(args.length < 2){
            return true;
        }
        else return false;
    }

    public void driverLoop(){
        for(int i = 1; i <= 5; i++){
            Car driver = new Car(i);
            System.out.println(simulateCar(driver));
        }
    }
    public String simulateCar(Car driver){
        City city = new City();
        String output = "";
        driver.setCurrentLocation(city.getStartAndEndNode());
        do{
            Intersection oldLocation = driver.getCurrentLocation();
            Intersection newLocation = driver.chooseDirection(rand);
            driver.setCurrentLocation(newLocation);
            output = output.concat("Driver " + driver.getCarNumber() + "  went from " + oldLocation.getLocationName() +
                    " to " + newLocation.getLocationName() + " by means of " + getPathName(oldLocation, newLocation) + "\n");

        } while(!driver.getCurrentLocation().equals(city.getStartAndEndNode()));

        return output;
    }
    public String getPathName(Intersection loc1, Intersection loc2){
        ArrayList<Avenue> avenues = new ArrayList<>();
        ArrayList<Street> streets = new ArrayList<>();

        avenues.addAll(loc1.getAvenues());
        avenues.addAll(loc2.getAvenues());
        streets.addAll(loc1.getStreets());
        streets.addAll(loc2.getStreets());


        String result = null;

        for(Avenue avenue : avenues){
            LinkedList<Intersection> intersections = avenue.getIntersections();
            if(intersections.contains(loc1) && intersections.get(intersections.indexOf(loc1)+1).equals(loc2)){
                result = avenue.getName();
            }
        }

        for(Street street : streets){
            if(street.getLocA().equals(loc1) && street.getLocB().equals(loc2) ||
                    street.getLocB().equals(loc1) && street.getLocA().equals(loc2)){
                result = street.getName();
            }
        }


        return result;
    }
}
