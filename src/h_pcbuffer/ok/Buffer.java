
package h_pcbuffer.ok;

/**
 *
 * @author dordonez@ute.edu.ec
 */

public class Buffer implements I_Buffer {
    int buffer[] = new int[5];
    volatile int used = 0;//espacio ocupado en el buffer
    int in = 0;//posición de siguiente escritura
    int out = 0;//posición de siguiente lectura
    
    @Override
    public synchronized int get() {
        while (used <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException capturada");
            }
        }        
        int value = buffer[out];
        out = (out + 1) % buffer.length;
        used--;
        notify();
        return value;
    }

    @Override
    public synchronized void put(int n) {
        while (used >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException capturada");
            }
        }        
        buffer[in] = n;
        in = (in + 1) % buffer.length;
        used++;
        notify();
    }
}
