
package d_candados;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class CuentaMultiThreadTest {
    
    enum Comando {
        GET, GET_DEC, GET_INC, DEC_GET, INC_GET
    }
    
    Cuenta instance;
    int DEF_VALUE;
    int numThreads;
    int numIterations;
    TestThread[] threads;
    
    /**
     * Clase para crear los nuevos hilos
     */
    class TestThread extends Thread {
        Comando c;
        
        public TestThread(Comando c) {
            this.c = c;
        }
        
        @Override
        public void run() {
            for(int i = 0; i < numIterations; i++) {
                switch(c) {
                    case GET:
                        instance.get();
                        break;
                    case GET_DEC:
                        instance.getAndDecrement();
                        break;
                    case GET_INC:
                        instance.getAndIncrement();
                        break;
                    case DEC_GET:
                        instance.decrementAndGet();
                        break; 
                    case INC_GET:
                        instance.incrementAndGet();
                        break;                         
                }
            }
        }        
    }
    
    public CuentaMultiThreadTest() {
    }
    
    @Before
    public void setUp() {
        DEF_VALUE = 10000;
        numThreads = 100;
        numIterations = 100;
        instance = new Cuenta(DEF_VALUE);
        threads = new TestThread[numThreads];
    }

    /**
     * Test of get method, of class Cuenta.
     */
    @Test
    public void testGet() {
        long expResult = DEF_VALUE;
        for(int i = 0; i < numThreads; i++) {
            threads[i] = new TestThread(Comando.GET);           
        }
        for(int i = 0; i < numThreads; i++) {
            threads[i].start();
        }      
        for(int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CuentaMultiThreadTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long result = instance.get();
        assertEquals(expResult, result);
        System.out.println("GET: " + result);
    }

    /**
     * Test of decrementAndGet method, of class Cuenta.
     */
    @Test
    public void testDecrementAndGet() {
        long expResult = 0;
        for(int i = 0; i < numThreads; i++) {
            threads[i] = new TestThread(Comando.DEC_GET);
        }
        for(int i = 0; i < numThreads; i++) {
            threads[i].start();
        }      
        for(int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CuentaMultiThreadTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long result = instance.get();
        assertEquals(expResult, result);
        System.out.println("DECREMENT AND GET: " + result);
    }

    /**
     * Test of getAndIncrement method, of class Cuenta.
     */
    @Test
    public void testGetAndIncrement() {
        long expResult = DEF_VALUE * 2;
        for(int i = 0; i < numThreads; i++) {
            threads[i] = new TestThread(Comando.GET_INC);
        }
        for(int i = 0; i < numThreads; i++) {
            threads[i].start();
        }      
        for(int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CuentaMultiThreadTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long result = instance.get();
        assertEquals(expResult, result);
        System.out.println("GET AND INCREMENT: " + result);
    }

    /**
     * Test of getAndDecrement method, of class Cuenta.
     */
    @Test
    public void testGetAndDecrement() {
        long expResult = 0;
        for(int i = 0; i < numThreads; i++) {
            threads[i] = new TestThread(Comando.GET_DEC);
        }
        for(int i = 0; i < numThreads; i++) {
            threads[i].start();
        }      
        for(int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CuentaMultiThreadTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long result = instance.get();
        assertEquals(expResult, result);
        System.out.println("GET and DECREMENT: " + result);
    }

    /**
     * Test of incrementAndGet method, of class Cuenta.
     */
    @Test
    public void testIncrementAndGet() {
        long expResult = DEF_VALUE * 2;
        for(int i = 0; i < numThreads; i++) {
            threads[i] = new TestThread(Comando.INC_GET);
        }
        for(int i = 0; i < numThreads; i++) {
            threads[i].start();
        }      
        for(int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CuentaMultiThreadTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long result = instance.get();
        assertEquals(expResult, result);
        System.out.println("INCREMENT AND GET: " + result);
    }

    /**
     * Test of all methods, of class Cuenta.
     */
    @Test
    public void testMixed() {
        long expResult = DEF_VALUE;
        for(int i = 0; i < numThreads; i++) {
            switch(i % 5) {
                case 0:
                    threads[i] = new TestThread(Comando.GET);
                    break;
                case 1:
                    threads[i] = new TestThread(Comando.GET_DEC);
                    break;
                case 2:
                    threads[i] = new TestThread(Comando.GET_INC);
                    break;
                case 3:
                    threads[i] = new TestThread(Comando.DEC_GET);
                    break; 
                case 4:
                    threads[i] = new TestThread(Comando.INC_GET);
                    break;                         
            }             
        }
        for(int i = 0; i < numThreads; i++) {
            threads[i].start();
        }      
        for(int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CuentaMultiThreadTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        long result = instance.get();
        assertEquals(expResult, result);
        System.out.println("MIXED: " + result);
    }
    
}
