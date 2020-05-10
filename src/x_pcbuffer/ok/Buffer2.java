
package x_pcbuffer.ok;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Buffer2 implements I_Buffer {
    public final int CAPACIDAD = 5;
    private final ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(CAPACIDAD, true);
    
    @Override
    public int get() {
        int resultado = -1;
        try {
            resultado = buffer.take();
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @Override
    public void put(int n) {
        try {
            buffer.put(n);
        } catch (InterruptedException ex) {
            Logger.getLogger(Buffer2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
