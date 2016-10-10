
package d_candados.transferencias;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Transferencia extends Thread {
    private final int monto;
    private final Cuenta orig;
    private final Cuenta dest;
    private final CountDownLatch cdl;
    
    public Transferencia(int monto, Cuenta orig, Cuenta dest, CountDownLatch cdl) {
        this.monto = monto;
        this.orig = orig;
        this.dest = dest;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        orig.retiro(monto);
        dest.deposito(monto);
        cdl.countDown();
    }
   
}
