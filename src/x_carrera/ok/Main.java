
package x_carrera.ok;

import c_carrera.ok.Corredor;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main { 

    public static void main(String args[]) throws InterruptedException {
        Corredor[] c = new Corredor[10];
        
        // Partida: todos los corredores arrancan
        for (int i = 0; i < 10; i++) {
            c[i] = new Corredor();
            c[i].start();
        }
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
        
        // Fin: detenga a todos los corredores
        for (int i = 0; i < 10; i++) {
            c[i].detenerse();
        }         
        
        //Presente los resultados de cada corredor
        for (int i = 0; i < 10; i++) {           
            c[i].join();
            System.out.println(i + " : " + c[i].getResult());
        }        
        
    }
}

