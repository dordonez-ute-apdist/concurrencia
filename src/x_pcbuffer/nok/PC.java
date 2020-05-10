/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package x_pcbuffer.nok;

/**
 *
 * @author Diego
 */
public class PC {

    public static void main(String args[]) {
        Buffer b = new Buffer();
        Producer p = new Producer(b);
        Consumer c = new Consumer(b);
        
        p.start();
        c.start();
       
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
        p.stopthread();
        c.stopthread();
        
    }
    
}
