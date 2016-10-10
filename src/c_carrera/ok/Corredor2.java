/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package c_carrera.ok;

/**
 *
 * @author dordonez@ute.edu.ec
 */
public class Corredor2 extends Thread {
    private long metros = -1;
    private long tiempo;
    
    public Corredor2(long tiempo) {
        this.tiempo = tiempo;
    }
    
    @Override
    public void run() {
        long counter = 0;
        long inicio = System.currentTimeMillis();
        while(System.currentTimeMillis() < (inicio + tiempo)) {
            counter++;    
        }
        metros = counter;
    }
    
    public long getResult() {
        return metros;
    }
}
