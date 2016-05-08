package lab8.q1;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {
	
	@Test
	public void inputTest(){
		Anagram a = new Anagram("input");
		
		for(Object o : a.generate()){
			String s = (String) o;
			Assert.assertTrue(isAnagram("input", s));
		}
	}
	
	@Test
	public void randomTest(){
		String input = "";
		Random r = new Random();
		for(int i = 0; i<r.nextInt(6) + 4; i++){
			input += (char)(r.nextInt(26) + 65);
		}
		Anagram a = new Anagram(input);
		
		for(Object o : a.generate()){
			String s = (String) o;
			Assert.assertTrue(isAnagram(input, s));
		}
	}
	
	@Test
	public void testOne(){
		Anagram a = new Anagram("i");
		
		Assert.assertArrayEquals(new String[] {}, a.generate().toArray());
	}
	
	@Test
	public void testTwo(){
		Anagram a = new Anagram("in");
		
		Assert.assertArrayEquals(new String[]{"in", "ni"}, a.generate().toArray());
	}
	
	public static boolean isAnagram(String str1, String str2){

	    if(str1.length() != str2.length()) {return false;}

	    char[] a, b;
	    Arrays.sort(a = str1.toCharArray());
	    Arrays.sort(b = str2.toCharArray());
	    return Arrays.equals(a,b);
	  }
	
}
