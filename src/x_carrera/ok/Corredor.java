
package x_carrera.ok;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Corredor extends Thread {
    private volatile boolean corriendo = true;
    private long metros = -1;
    
    @Override
    public void run() {
        long counter = 0;
        while(corriendo) {
            counter++;    
        }
        metros = counter;
    }
    
    public void detenerse() {
        corriendo = false;
    }
    
    public long getResult() {
        return metros;
    }
}
