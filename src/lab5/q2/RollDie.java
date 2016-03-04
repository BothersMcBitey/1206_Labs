package lab5.q2;

import java.util.Random;

public class RollDie implements Runnable {
	
	public static void main(String[] args){
		new Thread(new RollDie()).start();
	}

	@Override
	public void run() {
		Random r = new Random();
		int rolls = r.nextInt(20) + 1;
		for(int i = 0; i < rolls; i++){
			System.out.println(r.nextInt(6)+1);
			float frac = ((float) i) / ((float) rolls);
			try{Thread.sleep((long)(frac*1000));}catch(InterruptedException e){}
		}
		System.out.println("final value: " + (r.nextInt(6)+1));
	}

}
