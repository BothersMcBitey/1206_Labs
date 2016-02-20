package lab4.q3;

public class GrayCode {

	public static void main(String[] args){
		GrayCode g = new GrayCode();
		String[] c = g.getGrayCode(4);
		for(String s : c){
			System.out.println(s);
		}
	}
	
	public GrayCode() {
		
	}
	
	public String[] getGrayCode(int n){
		int[] c = CalclateGrayCode(n);
		String[] s = new String[c.length];
		for(int i =0; i < c.length; i++){
			s[i] = String.format("%0"+n+"d", c[i]);
		}
		return s;
	}
	
	private int[] CalclateGrayCode(int n){
		if(n == 1){
			return new int[] {0,1};
		} else {
			int[] lcode = CalclateGrayCode(n-1);
			int[] ncode = new int[(int) Math.pow(2, n)];
			for(int i = 0; i < ncode.length/2; i++){
				ncode[i] =lcode[i];
				ncode[ncode.length - (i+1)] = (int)Math.pow(10, n-1) + lcode[i];
			}
			return ncode;
		}
	}
}
