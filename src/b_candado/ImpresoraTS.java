package b_candado;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Impresora con sincronización (TS = thread-safe !)
 *
 * @author dordonez@ute.edu.ec
 */
public class ImpresoraTS implements Impresora{
	private Lock lock = new ReentrantLock();
	
	// Simula una impresora lenta que imprime caracter por caracter
    public void print(String msg) {
    	try {		
	    	lock.lock();
	    	
	        for(int i = 0; i < msg.length(); i++) {
	            System.out.print(msg.charAt(i));
	            Thread.sleep(100);
	        }
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	} finally { 	
    		lock.unlock();
    	}
        System.out.println("");
    }
    
}
