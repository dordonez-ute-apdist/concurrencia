
package g_deadlock.ok;

/**
 *
 * @author dordonez@ute.edu.ec
 * Implementación CORRECTA de deadlock
 */
public class Deadlock extends Thread {

    public A a;
    public B b;

    public Deadlock(String name, A a, B b) {
        setName(name);
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        if(getName().equals("X")) {
            synchronized(a) {
                synchronized(b) {
                    a.uno((Deadlock) Thread.currentThread()); // X bloquea A.
                    System.out.println("X regresa de A");
                }
            }
        } else if(getName().equals("Y")) {
            synchronized(a) {
                synchronized(b) {
                    b.uno((Deadlock) Thread.currentThread()); // Y bloquea B.
                    System.out.println("Y regresa de B");
                }
            }            
        }
    }

    public static void main(String args[]) {
        A a = new A();
        B b = new B();
    
        Deadlock x = new Deadlock("X", a, b);
        Deadlock y = new Deadlock("Y", a, b);
        
        x.start();
        y.start();
        
    }  
    
}
