
package a_intro;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class NuevaRunnable implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for(int i = 0; i < 5; i++) {
            System.out.println(name + " paso: " + i);
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
