
package x_comunicacion.ok;

import f_comunicacion.ok.Cola;
import f_comunicacion.ok.Consumidor;
import f_comunicacion.ok.Productor;

/**
 *
 * @author dordonez@ute.edu.ec
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
