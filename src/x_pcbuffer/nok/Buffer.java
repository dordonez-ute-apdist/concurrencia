/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package x_pcbuffer.nok;

/**
 *
 * @author Diego
 */

class Buffer {
    int buffer[] = new int[5];
    int used = 0;//espacio ocupado en el buffer
    int in = 0;//posición de siguiente escritura
    int out = 0;//posición de siguiente lectura
    
    int get() {      
        int value = buffer[out];
        out = (out + 1) % buffer.length;
        used--;
        return value;
    }

    void put(int n) {      
        buffer[in] = n;
        in = (in + 1) % buffer.length;
        used++;
    }
}
