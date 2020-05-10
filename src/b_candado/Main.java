package b_candado;

/**
 * https://github.com/dordonez-ute-apdist/concurrencia
 * 
 * @author dordonez@ute.edu.ec
 */
public class Main {
    
    public static void main(String[] args) {
    	//Impresora imp = new ImpresoraNOK();
    	Impresora imp = new ImpresoraTS();
    	
        Hilo h1 = new Hilo(imp, "abcdefgh");
        Hilo h2 = new Hilo(imp, "ABCDEFGH");
        Hilo h3 = new Hilo(imp, "12345678"); 
        
        h1.start();
        h2.start();
        h3.start();

    }
    
}
