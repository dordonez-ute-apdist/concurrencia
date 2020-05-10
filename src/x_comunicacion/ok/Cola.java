
package x_comunicacion.ok;

/**
 *
 * @author dordonez@ute.edu.ec
 * Implementación CORRECTA del productor-consumidor
 */
public class Cola {
    private boolean valueSet = false;
    private int n;

    public synchronized int get() {
        while (valueSet == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException capturada");
            }
        }
      
        System.out.println("Got: " + n);
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (valueSet == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}
