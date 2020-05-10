
package f_deadlock;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main {

    public static void main(String[] args) {
        Cuenta a = new Cuenta(1000.0);
        Cuenta b = new Cuenta(1000.0);
        
        for(int i = 0; i < 10; i++) {
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
