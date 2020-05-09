
package x_cronometro;

import java.util.logging.Level;
import java.util.logging.Logger;

import x_cronometro.Cronometro;
import x_cronometro.Main;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main {

    public static void main(String[] args) {       
        //Crea nueva thread y la ejecuta
        Cronometro crono = new Cronometro();
        crono.start();     
        
        try {
            //le deja ejecutarse tres segundos
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //lo detiene
        crono.detenerse();
        try {
            crono.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //obtiene resultado
        int resultado = crono.getResultado();
        System.out.println("Resultado: " + resultado);
    }
}
