
package x_comunicacion.nok;

/**
 *
 * @author dordonez@ute.edu.ec
 * Implementación INCORRECTA del productor-consumidor
 */
public class Cola {

    private int n;

    public synchronized int get() {
        System.out.println("Got: " + n);
        return n;
    }

    public synchronized void put(int n) {
        this.n = n;
        System.out.println("Put: " + n);
    }
}
