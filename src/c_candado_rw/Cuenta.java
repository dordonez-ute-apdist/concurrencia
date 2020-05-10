
package c_candado_rw;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Cuenta {
    private double saldo;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    
    public void operacion(double valor) {  
        try {
        	lock.writeLock().lock();
            Thread.sleep(500);
            saldo += valor;
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    public double getSaldo() {
        try {
        	lock.readLock().lock();
            Thread.sleep(500);
            return saldo;
        } catch(Exception ex) {
            ex.printStackTrace();
            return saldo;
        } finally {
            lock.readLock().unlock();
        }
    }
}
