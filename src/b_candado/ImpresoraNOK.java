package b_candado;

/**
 * Impresora sin sincronización (no es thread-safe !)
 *
 * @author dordonez@ute.edu.ec
 */
public class ImpresoraNOK implements Impresora{

	// Simula una impresora lenta que imprime caracter por caracter
    public void print(String msg) {
        for(int i = 0; i < msg.length(); i++) {
            System.out.print(msg.charAt(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("");
    }
    
}
