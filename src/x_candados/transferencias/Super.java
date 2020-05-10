
package x_candados.transferencias;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Super {

    public static void main(String args[]) {
        try {
            Cuenta a = new Cuenta("A", 100);
            Cuenta b = new Cuenta("B", 200);
            CountDownLatch cdl = new CountDownLatch(2);
            
            Transferencia uno = new Transferencia(5, a, b, cdl);
            Transferencia dos = new Transferencia(2, b, a, cdl);
            
            uno.start();
            dos.start();
            
            cdl.await();
            
            System.out.println(a.getId() + " : " + a.getSaldo());
            System.out.println(b.getId() + " : " + b.getSaldo());
        } catch (InterruptedException ex) {
            Logger.getLogger(Super.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
