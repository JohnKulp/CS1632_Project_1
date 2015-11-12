import static org.mockito.Mockito.*;

/**
 * Created by otter on 10/8/15.
 */
class IntersectionTest extends groovy.util.GroovyTestCase {

    // Tests the creation of an intersection.  Mocks the parameters.
    void testCreateIntersection(){
        def fifth =  mock(Street.class);
        def forbes = mock(Street.class);

        //test the creation of a location
        def bookstore = new Intersection("Bookstore");

    }

    // Tests the getters and setters for an intersection.
    void testGettersAndSetters(){
        def craig = new Street();
        def atwood = new Street();

        //test the creation of a location
        def bookstore = new Intersection("Bookstore");
        bookstore.addStreet(craig);
        assert bookstore.getStreets().contains(craig);
        bookstore.addStreet(atwood);
        assert bookstore.getStreets().contains(craig);
        assert bookstore.getStreets().contains(atwood);

        //test getters and setters for avenues
        def fifth = new Avenue("fifth");
        bookstore.addAvenue(fifth);
        assert bookstore.getAvenues().contains(fifth);

        //test getters and setters for names
        assert bookstore.getLocationName().equals("Bookstore");
        bookstore.setLocationName("Barnes and Noble");
        assert bookstore.getLocationName().equals("Barnes and Noble");
    }



}
