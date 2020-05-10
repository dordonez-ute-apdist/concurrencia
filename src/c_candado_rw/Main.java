
package c_candado_rw;

/**
 * https://github.com/dordonez-ute-apdist/concurrencia
 * 
 * @author dordonez@ute.edu.ec
 */
public class Main {

    private static Cuenta c = new Cuenta();
    
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            new Escribe().start();
        }  
        for(int i = 0; i < 1000; i++) {
            new Lee().start();
        }
        for(int i = 0; i < 5; i++) {
            new Escribe().start();
        }  
    }
    
    private static class Escribe extends Thread {
        @Override
        public void run() {
            c.operacion(1);
            System.out.println("Depósito: 1");
        }    	
    }
  
    private static class Lee extends Thread {
        @Override
        public void run() {
            System.out.println("Saldo: " + c.getSaldo());
        }    	
    }    
    
}
