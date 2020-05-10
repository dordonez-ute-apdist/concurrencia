/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package x_pcbuffer.ok;

/**
 *
 * @author Diego
 */
public class PC {

    public static void main(String args[]) {
        I_Buffer b = new Buffer();
        //I_Buffer b = new Buffer2();
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
