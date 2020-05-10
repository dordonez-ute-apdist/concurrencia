
package x_candados.transferencias;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Cuenta {
    private final String id;
    private int saldo;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);
    
    public Cuenta(String id, int saldo) {
        this.id = id;
        this.saldo = saldo;
    }
    
    public void retiro(int valor) {
        rwLock.writeLock().lock();
        try {
            saldo -= valor;
        } finally {
            rwLock.writeLock().unlock();
        }
    }
    
    public void deposito(int valor) {
        rwLock.writeLock().lock();
        try {
            saldo += valor;
        } finally {
            rwLock.writeLock().unlock();
        }
    }
   
    public int getSaldo() {
        int respuesta = -1;
        rwLock.readLock().lock();
        try {
            respuesta = saldo;
        } finally {
            rwLock.readLock().unlock();
        }
        return respuesta;
    }
    
    public String getId() {
        return id;
    }
    
}
