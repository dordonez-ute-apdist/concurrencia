/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package e_compartido;

/**
 *
 * @author ocda88010
 */
public class Hilo extends Thread {
    private String msg;
    
    public Hilo(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        //imprime sin sincronizar
        //Impresora.print(msg);
        
        //imprime sincronizado
        //Impresora.printSynch(msg);
        
        //imprime sincronizado por bloque
        
        synchronized(String.class) {
            Impresora.print(msg);
            
        }      
        
        
        
    }
     
}
