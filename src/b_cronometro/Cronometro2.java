
package b_cronometro;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Cronometro2 extends Thread {
    private int resultado = -1;
    private final long ms;
    
    public Cronometro2(long ms) {
        this.ms = ms;
    }
    
    @Override
    public void run() {
        long inicio = System.currentTimeMillis();
        int counter = 0;
        while(System.currentTimeMillis() < (inicio + ms)) {
            counter++;    
        }
        resultado = counter;
    }
    
    public int getResultado() {
        return resultado;
    }
}
