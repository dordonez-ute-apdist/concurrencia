package b_candado;

/**
 * Trabajo de impresión concurrente
 * 
 * @author dordonez@ute.edu.ec
 */
public class Hilo extends Thread {
	private Impresora imp;
    private String msg;
    
    public Hilo(Impresora imp, String msg) {
    	this.imp = imp;
        this.msg = msg;
    }

    @Override
    public void run() {
        imp.print(msg);       
    }
     
}
