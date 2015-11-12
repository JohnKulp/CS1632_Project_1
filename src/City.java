
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by otter on 10/6/15.
 */
public class City {

    private ArrayList<Intersection> intersections; //= ["Mall", "Bookstore", "Coffee Shop", "University", "Outside City"];
    private ArrayList<Street> streets;
    private ArrayList<Avenue> avenues;
    private Intersection startAndEndNode;

    public City(){

        intersections = new ArrayList<>();
        streets = new ArrayList<>();
        avenues = new ArrayList<>();

        Intersection outsideCity = new Intersection("Outside City");
        Intersection mall = new Intersection("Mall");
        Intersection bookstore = new Intersection("Bookstore");
        Intersection coffeeShop = new Intersection("Coffee Shop");
        Intersection university = new Intersection("University");

        Street meow = new Street("Meow St.", mall, coffeeShop);
        mall.addStreet(meow);
        coffeeShop.addStreet(meow);

        Street chirp = new Street("Chirp St.", bookstore, university);
        bookstore.addStreet(chirp);
        university.addStreet(chirp);


        LinkedList<Intersection> fourthIntersections = new LinkedList<Intersection>();
        fourthIntersections.add(outsideCity);
        fourthIntersections.add(mall);
        fourthIntersections.add(bookstore);
        fourthIntersections.add(outsideCity);

        LinkedList<Intersection> fifthIntersections = new LinkedList<Intersection>();
        fifthIntersections.add(outsideCity);
        fifthIntersections.add(university);
        fifthIntersections.add(coffeeShop);
        fifthIntersections.add(outsideCity);

        Avenue fourth = new Avenue("Fourth Ave.", fourthIntersections);
        Avenue fifth = new Avenue("Fifth Ave.", fifthIntersections);

        outsideCity.addAvenue(fourth);
        outsideCity.addAvenue(fifth);

        mall.addAvenue(fourth);
        bookstore.addAvenue(fourth);

        university.addAvenue(fifth);
        coffeeShop.addAvenue(fifth);

        intersections.add(outsideCity);
        intersections.add(mall);
        intersections.add(bookstore);
        intersections.add(coffeeShop);
        intersections.add(university);

        streets.add(meow);
        streets.add(chirp);

        avenues.add(fourth);
        avenues.add(fifth);

        startAndEndNode = outsideCity;
    }

    public ArrayList<Intersection> getIntersections(){
        return intersections;
    }

    public boolean hasLocation(String location){
        for(Intersection intersection : intersections){
            if(intersection.getLocationName().equals(location)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Avenue> getAvenues(){
        return avenues;
    }
    public ArrayList<Street> getStreets(){
        return streets;
    }

    public Intersection getStartAndEndNode(){
        return startAndEndNode;
    }

}
