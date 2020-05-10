
package x_deadlock.nok;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class B {
    
    public synchronized void uno(Deadlock d) {
        System.out.println("Y dentro de B.uno()");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("B interrumpida");
        }
        System.out.println("Y tratando de llamar a A.dos()");
        d.a.dos();
    }

    public synchronized void dos() {
        System.out.println("X dentro de B.dos()");
    }
}
