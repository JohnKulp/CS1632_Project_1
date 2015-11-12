import groovy.mock.interceptor.StubFor

import static org.mockito.Mockito.*;

/**
 * Created by otter on 10/8/15.
 */
class CityTest extends groovy.util.GroovyTestCase {

    // tests that The Map class has every location that it should.  The constructor is tested through this class
    // due to the lack of parameters.
    void testMapLocations(){
        def map = new City();

        ArrayList<String> locations = ["Mall", "Bookstore", "Coffee Shop", "University", "Outside City"];
        boolean hasAllLocations = true;
        for (int i = 0; i < locations.size(); i++){
            if(!map.hasLocation(locations[i])){
                hasAllLocations = false;
                break;
            }
        }
        assert hasAllLocations;
    }

    // Tests the hasLocation function.
    void testHasLocation(){
        def city = new City();
        assert !city.hasLocation("nowhere");
        assert city.hasLocation("Coffee Shop");
        assert !city.hasLocation("Meow St.");
        assert !city.hasLocation("Fourth Ave.");
        assert city.hasLocation("Bookstore");
    }

    // Tests the getters for the City class.
    void testGetters(){
        def map = new City();
        assert map.getStreets().size() == 2;
        assert map.getIntersections().size() == 5;
        assert map.getAvenues().size() == 2
        assert map.getStartAndEndNode() != null;
    }
}
