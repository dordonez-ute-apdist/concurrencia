package d_barrera;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * https://github.com/dordonez-ute-apdist/concurrencia
 * 
 * Envía a varios hilos a realizar un cálculo complejo,
 * recupera todos los resultados y presenta el total.
 * 
 * Este ejemplo está sincronizado (thread-safe) y da el
 * resultado total correcto
 * 
 * @author dordonez@ute.edu.ec
 */
public class MainTS {

	public static void main(String[] args) {
		int NUM_THREADS = 4;
		Operacion[] oper = new Operacion[NUM_THREADS];
		double resultado = 0;
		
		CountDownLatch barrera = new CountDownLatch(NUM_THREADS);
		
		for (int i = 0; i < NUM_THREADS; i++) {
			oper[i] = new Operacion(barrera);
		}
		for (int i = 0; i < NUM_THREADS; i++) {
			oper[i].start();
		}
		
		try {
			barrera.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < NUM_THREADS; i++) {
			resultado += oper[i].getValue();
		}
		System.out.println("TOTAL: " + resultado);
	}

	//Simplemente una operación de cálculo intensivo
	private static class Operacion extends Thread {
		private double value = 0;
		
		private CountDownLatch barrera;

		Operacion(CountDownLatch barrera) {
			this.barrera = barrera;
		}
		
		@Override
		public void run() {
			Random rnd = new Random();
			for (int i = 0; i < 10000000; i++) {
				double tmpVal = rnd.nextDouble();
				tmpVal = tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(tmpVal))))))))));
				value += cbrt(tmpVal);
			}
			System.out.println(Thread.currentThread().getName() + ": " + getValue());		

			barrera.countDown();
		}
		
		public double getValue() {
			return value;
		}
		
		private double atan(double value) {
			return Math.atan(value);
		}
		private double tan(double value) {
			return Math.tan(value);
		}
		private double cbrt(double value) {
			return Math.cbrt(value);
		}
	}
	
}
