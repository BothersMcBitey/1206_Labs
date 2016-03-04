package lab5.q3;

import java.util.List;

public class PrimeThread extends Thread {
	
	private static final int primes55[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
			89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191,
			193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257 };

	public PrimeThread(List<Integer> v) {
		for (Integer i : v) {
			boolean solved = false;
			
			for (int j = 0; j < 55; j++) {
				if (i % primes55[j] == 0) {
					if (i == primes55[j]) {
						System.out.println(i + " is prime");
						solved = true;
					} else {
						System.out.println(i + " is not prime");
						solved = true;
					}
				}
			}

			if (!solved) {
				for (int j = 259; j < i; j++) {
					if (i % j == 0){
						System.out.println(i + " is not prime");
						solved = true;
						break;
					}
				}
				if (!solved) System.out.println(i + " is prime");
			}
		}
	}
}
