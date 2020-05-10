
package x_comunicacion.nok;

import f_comunicacion.nok.Cola;

/**
 *
 * @author dordonez@ute.edu.ec
 * Implementación INCORRECTA del productor-consumidor
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
