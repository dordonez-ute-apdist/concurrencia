/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package x_carrera.ok;

import c_carrera.ok.Corredor2;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Main2 { 

    public static void main(String args[]) throws InterruptedException {
        Corredor2[] c = new Corredor2[10];
        
        // Partida: todos los corredores arrancan
        for (int i = 0; i < 10; i++) {
            c[i] = new Corredor2(200);
            c[i].start();
        }

        //Presente los resultados de cada corredor una vez que hayan terminado
        for (int i = 0; i < 10; i++) {           
            c[i].join();
            System.out.println(i + " : " + c[i].getResult());
        }        
        
    }
}

