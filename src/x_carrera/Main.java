
package x_carrera;

import c_carrera.Corredor;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main { 

    public static void main(String args[]) {
        Corredor c[] = new Corredor[10];
        
        // Partida: todos los corredores arrancan
        for (int i = 0; i < 10; i++) {
            c[i] = new Corredor();

        }
        
        // Espera de 100 ms
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        
        
        // Fin: detenga a todos los corredores
        for (int i = 0; i < 10; i++) {
            
        }         
        
        //Presente los resultados de cada corredor
        for (int i = 0; i < 10; i++) {
            
            
            
            System.out.println(i + " : " + c[i].getResult());
        }        
        
    }
}

