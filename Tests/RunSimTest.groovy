//JUnit identifiers used to maintain before and after functionality
import static org.mockito.Mockito.*;

/**
 * Created by otter on 10/8/15.
 */
class RunSimTest extends groovy.util.GroovyTestCase {

    //tests that the Main funciton runs the code correctly and finitely
    void testMain(){
        def args = new String[2];
        args[1] = "otter2342"
        RunSim.main(args);
        //ensure that the test reaches this point
        assert true;
    }

    //tests the initialization of the necessary variables and requirements to run the simulation
    //stubs all external functions
    void testSetUpSim(){
        def sim = spy(new RunSim());
        def args = new String[1];
        args[0] = "1";
        doReturn(true).when(sim).ensureArgs(any(String[]));
        doNothing().when(sim).setRand(any(Random));
        doNothing().when(sim).driverLoop();
        sim.setUpSim(args);
    }

    //tests the function ensuring that there are a correct number of args
    //tests 0, 1, 2, and 3 arguments
    void testEnsureArgs(){
        def sim = new RunSim();
        assert sim.ensureArgs(new String[0]);
        assert sim.ensureArgs((String[])["arg0"]);
        assert !sim.ensureArgs((String[])["arg0", "arg1"]);
    }

    //tests that the setters and getters work correctly
    void testGettersAndSetters(){
        def sim = new RunSim();
        def newRand = new Random(10)
        sim.setRand(newRand)
        assert sim.getRand().equals(newRand);
    }

    // tests that the getPathName function works correctly for a predefined network of
    // avenues, streets, and locations.
    void testGetPathName(){
        def sim = new RunSim();


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



        assert sim.getPathName(mall, bookstore).equals("Fourth Ave.");
        assert sim.getPathName(bookstore, mall).equals(null);
        assert sim.getPathName(mall, coffeeShop).equals("Meow St.");
        assert sim.getPathName(coffeeShop, mall).equals("Meow St.");
        assert sim.getPathName(mall, university).equals(null);

    }

    //tests the creation of a driver.  Stubs the simulateCar function with an empty string and verifies
    //that it was called 5 times, one time for each driver.
    void testCreateDrivers(){

        def mockedSim = spy(new RunSim());
        //stub the simulateCar method
        doReturn("").when(mockedSim).simulateCar(any(Car));
        mockedSim.driverLoop();
        verify(mockedSim, times(5)).simulateCar(any(Car));

    }

    //tests several seeds on the simulateCar function to ensure that it has full functionality.
    //stubs the getPathName function due to its complexity.
    void testDriveTheCar(){
        def mockPathName = spy(new RunSim());
        //stub the getPathName method
        doReturn("some street").when(mockPathName).getPathName(any(Intersection), any(Intersection));
        mockPathName.setRand(new Random(10));
        String result = mockPathName.simulateCar(new Car(1));
        assert !result.equals("Driver 1  went from Outside City to University by means of some street\n" +
                "Driver 1  went from University to Coffee Shop by means of some street\n" +
                "Driver 1  went from Coffee Shop to Outside City by means of some street");
        result = mockPathName.simulateCar(new Car(54234));
        assert result.equals("Driver 54234  went from Outside City to Mall by means of some street\n" +
                "Driver 54234  went from Mall to Bookstore by means of some street\n" +
                "Driver 54234  went from Bookstore to University by means of some street\n" +
                "Driver 54234  went from University to Coffee Shop by means of some street\n" +
                "Driver 54234  went from Coffee Shop to Outside City by means of some street\n");
        mockPathName.setRand(new Random(3443))
        result = mockPathName.simulateCar(new Car(2));
        assert result.equals("Driver 2  went from Outside City to University by means of some street\n" +
                "Driver 2  went from University to Bookstore by means of some street\n" +
                "Driver 2  went from Bookstore to University by means of some street\n" +
                "Driver 2  went from University to Coffee Shop by means of some street\n" +
                "Driver 2  went from Coffee Shop to Mall by means of some street\n" +
                "Driver 2  went from Mall to Coffee Shop by means of some street\n" +
                "Driver 2  went from Coffee Shop to Outside City by means of some street\n");
    }

}
