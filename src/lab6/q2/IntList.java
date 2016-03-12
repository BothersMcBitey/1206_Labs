package lab6.q2;

import java.util.ArrayList;

public class IntList {
	
	private ArrayList<Integer> list;
	
	public IntList(){
		list = new ArrayList<>();
	}
	
	public synchronized void add(Integer i){
		list.add(i);
	}
	
	public synchronized Integer get(){
		Integer i = list.get(0);
		list.remove(0);
		return i;
	}
	
	public synchronized boolean isEmpty(){
		return list.isEmpty();
	}
}
