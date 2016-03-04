package lab5.q1;

public class NumberedThread extends Thread {

	private final int num;
	
	public NumberedThread(int num) {
		this.num = num;
	}
	
	@Override
	public void run(){
		try{sleep(100*(4-num));}catch(InterruptedException e){}
		System.out.println("Thread " + num + " has finished execution");
	}
}
