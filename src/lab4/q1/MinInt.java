package lab4.q1;

import java.util.Arrays;
import java.util.Random;

public class MinInt {

	int[] arr;// = {24,52,74,9,34,23,64,34};
	final int LENGTH = 20;
	
	public static void main(String[] args){
		MinInt m = new MinInt();
		System.out.println("min is: " + m.findMin());
	}
	
	public MinInt() {
		arr = new int[LENGTH];
		for(int i = 0; i < LENGTH; i++){
			arr[i] = new Random().nextInt(100);
		}
	}
	
	public int findMin(){
		return findMinAux(arr);
	}
	
	private int findMinAux(int[] arr){
		if(arr.length == 1){
			return arr[0];
		} else if(arr.length == 2){
			if(arr[0] < arr[1]) return arr[0]; else return arr[1];
		} else {
			int a = findMinAux(Arrays.copyOfRange(arr, 0, arr.length/2));
			int b = findMinAux(Arrays.copyOfRange(arr, arr.length/2, arr.length));
			if(a < b) return a; else return b;
		}		
	}
}
