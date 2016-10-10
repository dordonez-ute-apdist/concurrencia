/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package h_pcbuffer.nok;

/**
 *
 * @author Diego
 */
class Consumer extends Thread {
    private volatile boolean running = true;
    Buffer b;

    Consumer(Buffer b) {
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
