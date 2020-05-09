
package x_cronometro;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Cronometro extends Thread {
    private volatile boolean contando = true;
    private int resultado = -1;
    
    public void run() {
        int counter = 0;
        while(contando) {
            counter++;    
        }
        resultado = counter;
    }
    
    public void detenerse() {
        contando = false;
    }
    
    public int getResultado() {
        return resultado;
    }
}
