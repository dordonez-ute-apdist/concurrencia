
package x_comunicacion.nok;

import f_comunicacion.nok.Cola;
import f_comunicacion.nok.Consumidor;
import f_comunicacion.nok.Productor;

/**
 *
 * @author dordonez@ute.edu.ec
 * Implementación INCORRECTA del productor-consumidor
 */
public class Main {

    public static void main(String args[]) {
        Cola q = new Cola();
        Productor p = new Productor(q);
        Consumidor c = new Consumidor(q);
        
        p.start();
        c.start();
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
        p.stopthread();
        c.stopthread();
        
    }
    
}
