package x_candados;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import x_candados.Cuenta_TODO;

/**
 * 
 * dordonez@ute.edu.ec
 */ 
public class Cuenta_TODO {
    /**
     * El valor manipulado por los métodos
     */
    private long valor;
    
    /**
     * El candado que permite serializar el acceso a mValue
     */
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);

    /**
     * Inicializa el valor
     */
    public Cuenta_TODO(long initialValue) {
    	valor = initialValue;
    }

    /**
     * Devuelve el valor actual
     */
    public long get() {
        long value = 0;

        rwLock.readLock().lock();
        // TODO
        rwLock.readLock().unlock();
        return value;
    }

    /**
     * Decrementa el valor actual de uno, y devuelve el nuevo valor
     */
    public long decrementAndGet() {
        long value = 0;

        rwLock.writeLock().lock();
        // TODO
        rwLock.writeLock().unlock();
        return value;
    }

    /**
     * Devuelve el valor actual, y luego lo incrementa de uno
     */
    public long getAndIncrement()
    {
        long value = 0;

        rwLock.writeLock().lock();
        // TODO
        rwLock.writeLock().unlock();
        return value;
    }

    /**
     * Devuelve el valor actual, y luego lo decrementa de uno
     */
    public long getAndDecrement()
    {
        long value = 0;

        rwLock.writeLock().lock();
        // TODO
        rwLock.writeLock().unlock();
        return value;
    }

    /**
     * Incrementa el valor actual en uno, y luego devuelve el nuevo valor
     */
    public long incrementAndGet()
    {
        long value = 0;

        rwLock.writeLock().lock();
        // TODO
        rwLock.writeLock().unlock();
        return value;
    }
    
    public static void main(String[] args) {
        Cuenta_TODO c = new Cuenta_TODO(10);
        System.out.println(c.get() == 10);
        System.out.println(c.incrementAndGet()== 11);
        System.out.println(c.incrementAndGet()== 12);
        System.out.println(c.getAndDecrement()== 12);
        System.out.println(c.getAndDecrement()== 11);
        System.out.println(c.getAndDecrement()== 10);
        System.out.println(c.decrementAndGet()== 8);
        System.out.println(c.getAndIncrement()== 8);
        System.out.println(c.decrementAndGet()== 8);
        System.out.println(c.get() == 8);
    }
}

