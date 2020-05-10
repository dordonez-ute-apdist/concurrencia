
package f_deadlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class CuentaTS {
    
    protected final int id;
    protected double saldo;
    protected final ReadWriteLock lock = new ReentrantReadWriteLock();
    
    public CuentaTS(int id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }   
    
    public boolean transferencia(double valor, CuentaTS hacia) {
        if(valor <= 0) return false;       
        try {
            if(id < hacia.id) {
                lock.writeLock().lock();
                hacia.lock.writeLock().lock();
            } else {
                hacia.lock.writeLock().lock();
                lock.writeLock().lock();           
            }
            if(saldo >= valor) {
                saldo -= valor;
                hacia.saldo += valor;               
                return true;
            } else {
                return false;
            }
        } finally {
            lock.writeLock().unlock();
            hacia.lock.writeLock().unlock();            
        }
    }
}
