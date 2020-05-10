
package x_comunicacion.nok;

import f_comunicacion.nok.Cola;

/**
 *
 * @author dordonez@ute.edu.ec
 * Implementación INCORRECTA del productor-consumidor
 */
public class Productor extends Thread {
    private volatile boolean running = true;
    private Cola q;

    public Productor(Cola q) {
        this.q = q;
        setName("Producer");
    }

    public void run() {
        int i = 0;
        while (running) {
            q.put(i++);
        }
    }
    
    //Detiene la thread
    public void stopthread() {
        running = false;
    }
}
