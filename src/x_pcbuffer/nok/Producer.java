/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package x_pcbuffer.nok;

/**
 *
 * @author Diego
 */
class Producer extends Thread {
    private volatile boolean running = true;
    Buffer b;

    Producer(Buffer b) {
        this.b = b;
        setName("Producer");
    }

    public void run() {
        int i = 1;
        while (running) {
            b.put(i);
            System.out.println("PUT: " + (i++));
        }
    }
    
    //Detiene la thread
    public void stopthread() {
        running = false;
    }
}
