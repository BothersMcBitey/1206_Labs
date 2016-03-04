package lab5.q3;

import java.util.Random;
import java.util.Vector;

public class PrimeChecker {
	
	private static final int NO_THREADS = 10;

	public static void main(String[] args) {
		int n = 100;
		Random r = new Random();
		Vector<Integer> v = new Vector<Integer>(n);	
		for(int i = 0; i < n; i++) v.add(Math.abs(r.nextInt(1000000)));
		new PrimeChecker(v);
	}

	public PrimeChecker(Vector<Integer> v) {
		int chunkSize = v.size()/NO_THREADS;
		int remainder = v.size() % NO_THREADS;	
		int index = 0;
		for(int i = 0; i < NO_THREADS; i++){
			if(remainder != 0){
				new PrimeThread(v.subList(index, index + chunkSize + 1)).start();
				index += chunkSize + 1;
				remainder--;
			} else {
				new PrimeThread(v.subList(index, index + chunkSize)).start();
				index += chunkSize;
			}
		}
	}
}
