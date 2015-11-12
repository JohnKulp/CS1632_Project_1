import sun.awt.image.ImageWatched

import static org.mockito.Mockito.*;

/**
 * Created by root on 10/12/15.
 */
class AvenueTest extends GroovyTestCase {

    //tests the creation of an avenue.  Mocks the LinkedList parameter.
    void testCreateAvenue(){
        def fifthLocations = mock(LinkedList.class);
        def fifth = new Avenue("fifth", fifthLocations);
        assert fifth
    }

    //tests the getters and setters for an Avenue.  Mocks the Intersection parameters.
    void testGettersAndSetters(){
        def bookstore = mock(Intersection.class);
        def coffeShop = mock(Intersection.class);
        def fifthLocations = new LinkedList<Intersection>();
        fifthLocations.add(bookstore);
        fifthLocations.add(coffeShop);
        def avenue = new Avenue("fourth");
        avenue.setIntersections(fifthLocations);
        assert avenue.getIntersections().equals(fifthLocations);

        assert avenue.getName().equals("fourth");
    }
}
