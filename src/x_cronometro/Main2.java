
package x_cronometro;

import java.util.logging.Level;
import java.util.logging.Logger;

import x_cronometro.Cronometro2;
import x_cronometro.Main2;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main2 {

    public static void main(String[] args) {       
        //Crea nueva thread y la ejecuta
        Thread crono = new Cronometro2(2000);
        crono.start();     
        
        try {
            //espera que termine
            crono.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //obtiene resultado
        int resultado = ( (Cronometro2) crono ).getResultado();
        System.out.println("Resultado: " + resultado);
    }
}
