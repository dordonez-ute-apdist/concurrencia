package d_candados;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * dordonez@ute.edu.ec
 */ 
public class Cuenta {
    /**
     * El valor manipulado por los métodos
     */
    private long valor;
    
    /**
     * El candado que permite serializar el acceso a mValue
     */
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);

    /**
     * Inicializa el valor
     */
    public Cuenta(long initialValue) {
    	valor = initialValue;
    }

    /**
     * Devuelve el valor actual
     */
    public long get() {
        long value;

        rwLock.readLock().lock();
        try {
            value = valor;
        } finally {
            rwLock.readLock().unlock();
        }
        return value;
    }

    /**
     * Decrementa el valor actual de uno, y devuelve el nuevo valor
     */
    public long decrementAndGet() {
        long value = 0;

        rwLock.writeLock().lock();
        try {
            value = --valor;
        } finally {
            rwLock.writeLock().unlock();
        }
        return value;
    }

    /**
     * Devuelve el valor actual, y luego lo incrementa de uno
     */
    public long getAndIncrement() {
        long value = 0;

        rwLock.writeLock().lock();
        try {
            value = valor++;
        } finally {
            rwLock.writeLock().unlock();
        }
        return value;
    }

    /**
     * Devuelve el valor actual, y luego lo decrementa de uno
     */
    public long getAndDecrement() {
        long value = 0;

        rwLock.writeLock().lock();
        try {
            value = valor--;
        } finally {
            rwLock.writeLock().unlock();
        }
        return value;
    }

    /**
     * Incrementa el valor actual en uno, y luego devuelve el nuevo valor
     */
    public long incrementAndGet() {
        long value = 0;

        rwLock.writeLock().lock();
        try {
            value = ++valor;
        } finally {
            rwLock.writeLock().unlock();
        }
        return value;
    }

}

