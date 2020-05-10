
package e_cola;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Consumidor extends Thread {
	private BlockingQueue<Integer> cola;
    private int total = 0;
    
    Consumidor(BlockingQueue<Integer> cola) {
    	this.cola = cola;
    }
    
    @Override
    public void run() {
    	Integer value;
    	try {
	        while( (value = cola.poll(1, TimeUnit.SECONDS)) != null) {
	            total += value;
	        }
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
        System.out.println(Thread.currentThread().getName() + " : " + getTotal());
    }
    
    public int getTotal() {
        return total;
    }
    
}
