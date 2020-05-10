
package f_deadlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Cuenta {
    
    protected double saldo;
    protected final ReadWriteLock lock = new ReentrantReadWriteLock();

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }   
    
    public boolean transferencia(double valor, Cuenta hacia) {
        if(valor <= 0) return false;       
        try {
            lock.writeLock().lock();
            hacia.lock.writeLock().lock();
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
