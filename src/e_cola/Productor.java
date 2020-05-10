
package e_cola;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Productor extends Thread {
	private BlockingQueue<Integer> cola;
	private int cuantos;
	
	Productor(BlockingQueue<Integer> cola, int cuantos) {
		this.cola = cola;
		this.cuantos = cuantos;
	}
    
    @Override
    public void run() {
        for(int i = 0; i < cuantos; i++) {
        	try {
				cola.put(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
    
}
