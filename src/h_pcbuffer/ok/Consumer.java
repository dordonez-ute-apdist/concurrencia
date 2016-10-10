/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package h_pcbuffer.ok;

/**
 *
 * @author Diego
 */
class Consumer extends Thread {
    private volatile boolean running = true;
    I_Buffer b;

    Consumer(I_Buffer b) {
        this.b = b;
        setName("Consumer");
    }

    public void run() {
        while (running) {
            System.out.println("GET: " + b.get());
        }
    }
    
    //Detiene la thread
    public void stopthread() {
        running = false;
    }
}
