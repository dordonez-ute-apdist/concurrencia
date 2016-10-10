
package b_cronometro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main1 {

    public static void main(String[] args) {       
        //Crea nueva thread y la ejecuta
        Thread crono = new Cronometro1();
        crono.start();     
        
        try {
            //la deja ejecutarse tres segundos
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main1.class.getName()).log(Level.SEVERE, null, ex);
        }

        //la detiene
        crono.interrupt();
        try {
            crono.join();//espera que haya terminado
        } catch (InterruptedException ex) {
            Logger.getLogger(Main1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //obtiene resultado
        long resultado = ( (Cronometro1) crono ).getResultado();
        System.out.println("Resultado: " + resultado);
    }
}
