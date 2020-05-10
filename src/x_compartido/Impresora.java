/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package x_compartido;

/**
 *
 * @author ocda88010
 */
public class Impresora {
    
    
    public static synchronized void printSynch(String msg) {
        print(msg);
    }
    
    public static void print(String msg) {
        for(int i = 0; i < msg.length(); i++) {
            System.out.print(msg.charAt(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("");
    }
    
}
