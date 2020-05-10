/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package x_compartido;

import e_compartido.Hilo;

/**
 *
 * @author ocda88010
 */
public class Main {
    
    public static void main(String[] args) {
        Hilo h1 = new Hilo("abcdefgh");
        Hilo h2 = new Hilo("ABCDEFGH");
        Hilo h3 = new Hilo("12345678");
        Hilo1 hh = new Hilo1("xyxyxyxyxyxyxy");
        
        
        h1.start();
        h2.start();
        h3.start();
        //hh.start();
        
        /*
        //Espera a que los hilos finalicen primero
        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        */

        System.out.println("Terminada la impresión");
    }
    
}
