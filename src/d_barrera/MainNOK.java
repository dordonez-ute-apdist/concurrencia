package d_barrera;

import java.util.Random;

/**
 * https://github.com/dordonez-ute-apdist/concurrencia
 * 
 * Envía a varios hilos a realizar un cálculo complejo,
 * recupera todos los resultados y presenta el total.
 * 
 * Este ejemplo al no contar con sincronización no da
 * el resultado correcto
 * 
 * @author dordonez@ute.edu.ec
 */
public class MainNOK {

	public static void main(String[] args) {
		int NUM_THREADS = 4;
		Operacion[] oper = new Operacion[NUM_THREADS];
		double resultado = 0;
		
		for (int i = 0; i < NUM_THREADS; i++) {
			oper[i] = new Operacion();
		}
		for (int i = 0; i < NUM_THREADS; i++) {
			oper[i].start();
		}		
		for (int i = 0; i < NUM_THREADS; i++) {
			resultado += oper[i].getValue();
		}
		System.out.println("TOTAL: " + resultado);
	}

	//Simplemente una operación de cálculo intensivo
	private static class Operacion extends Thread {
		private double value = 0;
		
		@Override
		public void run() {
			Random rnd = new Random();
			for (int i = 0; i < 10000000; i++) {
				double tmpVal = rnd.nextDouble();
				tmpVal = tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(tmpVal))))))))));
				value += cbrt(tmpVal);
			}
			System.out.println(Thread.currentThread().getName() + ": " + getValue());
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
