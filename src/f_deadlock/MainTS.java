
package f_deadlock;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class MainTS {

    public static void main(String[] args) {
        CuentaTS a = new CuentaTS(1, 1000.0);
        CuentaTS b = new CuentaTS(2, 1000.0);
        
        for(int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    a.transferencia(1, b);
                }
            }.start();
            new Thread() {
                @Override
                public void run() {
                    b.transferencia(1, a);
                }
            }.start();            
        }        
    }
    
}
