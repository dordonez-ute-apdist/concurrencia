
package a_intro;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name;
        //Recupera el nombre de la thread actual (principal)
        name = Thread.currentThread().getName();
        System.out.println("Nombre actual: " + name);
        
        //cambia el nombre
        Thread.currentThread().setName("MAIN");
        name = Thread.currentThread().getName();
        System.out.println("Nombre nuevo: " + name);
        
        //Crea nueva thread y la ejecuta
        NuevaThread nt = new NuevaThread();
        nt.start();
        
        //Crea nueva runnable y la ejecuta
        Thread nr = new Thread(new NuevaRunnable());
        nr.start();        
        
        new Thread(new NuevaRunnable()).start();
        new NuevaThread().start();
        
        //se detiene medio segundo en cada iteración       
        for(int i = 0; i < 5; i++) {
            System.out.println(name + " paso: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
