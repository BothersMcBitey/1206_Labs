package lab7.q1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class NumberStorage {

	private File bytefile, charfile;
	private int[] ints;
	
	public static void main(String[] args){
		new NumberStorage();
	}
	
	public NumberStorage() {
		createFiles();
		ints = getInts();
		outputBytes();
		outputChars();
	}
	
	public void outputBytes(){
		try(FileOutputStream out = new FileOutputStream(bytefile)){
			for(int i : ints){
				out.write(i);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void outputChars(){
		try(FileWriter out = new FileWriter(charfile)){
			for(int i : ints){
				out.write(Integer.toString(i));
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] getInts(){
		int[] ints = new int[10000];
		Random r = new Random();
		
		for(int i = 0; i < ints.length; i++){
			ints[i] = r.nextInt(10001);
		}
		
		return ints;
	}
	
	public void createFiles(){
		bytefile = new File("intbytes.bin");
		charfile = new File("intchars.txt");
		
		if(!bytefile.exists()){
			try {Files.createFile(bytefile.toPath());}catch(IOException e){e.printStackTrace();}
		}
		if(!charfile.exists()){
			try {Files.createFile(charfile.toPath());}catch(IOException e){e.printStackTrace();}
		}
	}
}
