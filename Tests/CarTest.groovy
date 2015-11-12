import static org.mockito.Mockito.*;

/**
 * Created by otter on 10/8/15.
 */
class CarTest extends groovy.util.GroovyTestCase {


    // Test the creation of a Car.
    void testCreateCar(){
        def driver = new Car(1);
    }

    //Tests the getters and setters for a Car.  Mocks the Intersection parameters.
    void testGettersAndSetters(){
        def driver = new Car(1);
        def outsideCity = mock(Intersection.class);
        driver.setCurrentLocation(outsideCity);
        assert driver.getCurrentLocation().equals(outsideCity);
        assert driver.getCarNumber() == 1;
    }

    // Tests the Car's ability to choose a direction.  Needs the functions and attributes of the parameters, so
    // they are not stubbed or mocked.  Assumes a result based on a specific seed.
    void testChooseDirection(){
        def driver = new Car(1);
        //test current location is null
        assert driver.chooseDirection() == null;

        def outside = new Intersection("outside");

        def bookstore = new Intersection("bookstore");
        def mall = new Intersection("mall");
        def university = new Intersection("university");
        def coffeeShop = new Intersection("coffee shop");

        def fifthLocations = new LinkedList<Intersection>();
        fifthLocations.add(outside);
        fifthLocations.add(bookstore);
        fifthLocations.add(mall);

        def fourthLocations = new LinkedList<Intersection>();
        fourthLocations.add(outside);
        fourthLocations.add(university);
        fourthLocations.add(coffeeShop);

        def fifth = new Avenue("fifth", fifthLocations);
        def fourth = new Avenue("fourth", fourthLocations);

        def meow = new Street("meow st", bookstore, university);
        bookstore.addStreet(meow);
        bookstore.addAvenue(fifth);

        outside.addAvenue(fifth);
        outside.addAvenue(fourth);

        //choose from 1 avenue and 1 street
        driver.setCurrentLocation(bookstore);
        Intersection nextIntersection = driver.chooseDirection(new Random(10));
        assert nextIntersection.equals(university);
        //get the other result
        driver.setCurrentLocation(bookstore);
        nextIntersection = driver.chooseDirection(new Random(13523));
        assert nextIntersection.equals(mall)

        //choose from 2 avenues
        driver.setCurrentLocation(outside);
        nextIntersection = driver.chooseDirection(new Random(1));
        assert nextIntersection.equals(university);
        //get the other result
        driver.setCurrentLocation(outside);
        nextIntersection = driver.chooseDirection(new Random(16162));
        assert nextIntersection.equals(bookstore);

        //choose from 2 avenues and a street
        def testStreet = new Street("testStreet", outside, coffeeShop);
        outside.addStreet(testStreet);
        coffeeShop.addStreet(testStreet);

        //get the first result
        driver.setCurrentLocation(outside);
        nextIntersection = driver.chooseDirection(new Random(1));
        assert nextIntersection.equals(bookstore);
        //get the next result
        driver.setCurrentLocation(outside);
        nextIntersection = driver.chooseDirection(new Random(5));
        assert nextIntersection.equals(coffeeShop);
        //get the last result
        driver.setCurrentLocation(outside);
        nextIntersection = driver.chooseDirection(new Random(16162));
        assert nextIntersection.equals(university);


    }
}
