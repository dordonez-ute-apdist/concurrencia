
package d_candados;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class CuentaSingleThreadTest {
    
    Cuenta instance;
    int DEF_VALUE;
    
    public CuentaSingleThreadTest() {
    }
    
    @Before
    public void setUp() {
        DEF_VALUE = 10;
        instance = new Cuenta(DEF_VALUE);
    }

    /**
     * Test of get method, of class Cuenta.
     */
    @Test
    public void testGet() {
        long expResult = DEF_VALUE;
        long result = instance.get();
        assertEquals(expResult, result);
    }

    /**
     * Test of decrementAndGet method, of class Cuenta.
     */
    @Test
    public void testDecrementAndGet() {
        long expResult = DEF_VALUE - 1;
        long result = instance.decrementAndGet();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAndIncrement method, of class Cuenta.
     */
    @Test
    public void testGetAndIncrement() {
        long expResult1 = DEF_VALUE;
        long expResult2 = DEF_VALUE + 1;
        long result = instance.getAndIncrement();
        assertEquals(expResult1, result);
        result = instance.get();
        assertEquals(expResult2, result);
    }

    /**
     * Test of getAndDecrement method, of class Cuenta.
     */
    @Test
    public void testGetAndDecrement() {
        long expResult1 = DEF_VALUE;
        long expResult2 = DEF_VALUE - 1;
        long result = instance.getAndDecrement();
        assertEquals(expResult1, result);
        result = instance.get();
        assertEquals(expResult2, result);
    }

    /**
     * Test of incrementAndGet method, of class Cuenta.
     */
    @Test
    public void testIncrementAndGet() {
        long expResult = DEF_VALUE + 1;
        long result = instance.incrementAndGet();
        assertEquals(expResult, result);
    }

    /**
     * Test of all methods, of class Cuenta.
     */
    @Test
    public void testMixed() {
        long expResult = DEF_VALUE;
        long result = instance.get();
        assertEquals(expResult, result);
        
        expResult = expResult + 1;
        result = instance.incrementAndGet();
        assertEquals(expResult, result);

        expResult = expResult - 1;
        result = instance.decrementAndGet();
        assertEquals(expResult, result);
        
        result = instance.getAndIncrement();
        assertEquals(expResult, result);
        expResult = expResult + 1;
        
        result = instance.getAndDecrement();
        assertEquals(expResult, result);
        expResult = expResult - 1;       
        
        result = instance.get();
        assertEquals(expResult, result);
    }
    
}
