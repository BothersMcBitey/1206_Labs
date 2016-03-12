package lab6.q2;

import java.util.Random;

public class PrimeChecker {

	public static void main(String[] args) {
		if(args.length != 2){
			System.err.println("Requires exactly 2 integer arguments");
			System.exit(1);
		}
		
		int n = Integer.parseInt(args[0]);
		int noThreads = Integer.parseInt(args[1]);
		
		Random r = new Random();
		IntList v = new IntList();	
		for(int i = 0; i < n; i++) v.add(Math.abs(r.nextInt(1000000)));
		new PrimeChecker(v, noThreads);
	}

	public PrimeChecker(IntList v, int noThreads) {
		for(int i = 0; i < noThreads; i++){
			new PrimeThread(v).start();
		}
	}
}
