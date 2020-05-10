
package x_deadlock.nok;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class A {
    
    public synchronized void uno(Deadlock d) {
        System.out.println("X dentro de A.uno()");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("A interrumpido");
        }
        System.out.println("X tratando de llamar a B.dos()");
        d.b.dos();
    }

    public synchronized void dos() {
        System.out.println("Y dentro de A.dos()");
    }
}
