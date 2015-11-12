import static org.mockito.Mockito.*;

/**
 * Created by otter on 10/8/15.
 */

class StreetTest extends groovy.util.GroovyTestCase {

    //test the creation of a new street.  Mocks the parameteres.
    void testCreateStreet(){
        def bookstore = mock(Intersection.class);
        def coffeShop = mock(Intersection.class);
        def fifth = new Street("Fifth", bookstore, coffeShop);
        def forbes = new Street("Forbes", bookstore, coffeShop);
        def atwood = new Street("Atwood", bookstore, coffeShop);
        def craig = new Street("Craig", bookstore, coffeShop);

    }

    // Tests the getters and setters for a Street.  Mocks the parameters.
    void testGettersAndSetters(){
        def testStreet = new Street();
        def bookstore = mock(Intersection.class);
        testStreet.setLocA(bookstore);
        assert testStreet.getLocA().equals(bookstore);
        testStreet.setLocB(bookstore);
        assert testStreet.getLocB().equals(bookstore);
        testStreet.setName("street");
        assert testStreet.getName().equals("street");
    }
}
