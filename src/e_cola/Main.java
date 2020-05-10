
package e_cola;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main {
    public static BlockingQueue<Integer> cola = new LinkedBlockingQueue<>(100);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    	int CUANTOS = 1000;
        new Productor(cola, CUANTOS).start();
        new Productor(cola, CUANTOS).start();
        new Productor(cola, CUANTOS).start();
        
        new Consumidor(cola).start();
        new Consumidor(cola).start();
    }
    
}
