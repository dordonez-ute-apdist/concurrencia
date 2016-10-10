
package b_cronometro;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Cronometro1 extends Thread {
    private long resultado = -1;
    
    public void run() {
        long counter = 0;
        while(!Thread.currentThread().isInterrupted()) {
            counter++;    
        }
        resultado = counter;
    }

    public long getResultado() {
        return resultado;
    }
}
