
package f_comunicacion.ok;

/**
 *
 * @author dordonez@ute.edu.ec
 * Implementación CORRECTA del productor-consumidor
 */
public class Consumidor extends Thread {
    private volatile boolean running = true;
    private Cola q;

    public Consumidor(Cola q) {
        this.q = q;
        setName("Consumidor");
    }

    public void run() {
        while (running) {
            q.get();
        }
    }
    
    //Detiene la thread
    public void stopthread() {
        running = false;
    }
}
