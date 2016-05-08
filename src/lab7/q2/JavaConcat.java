package lab7.q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaConcat {
	
	private File newFile;
	private String text;
	private DirectoryStream<Path> stream;

	public static void main(String[] args) {
		if(args.length != 2){
			System.out.println("Must have 2 arguments");
			System.exit(1);
		}		
		
		new JavaConcat(args);
	}
	
	public JavaConcat(String[] args) {
		checkDir(args[0]);
		readDir();
		saveToFile(args[1]);
	}
	
	public void checkDir(String path){
		if(Files.exists(Paths.get(path))){
			try {
				stream = Files.newDirectoryStream(Paths.get(path));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("invalid directory");
			System.exit(1);
		}
	}

	public void readDir(){
		text = "";
		for(Path dirEntry : stream){
			if(dirEntry.getFileName().toString().endsWith(".java")){
				System.out.println(dirEntry.getFileName());
				
				try(BufferedReader in = new BufferedReader(new FileReader(dirEntry.toFile()))){
					String line = null;
					while((line = in.readLine()) != null){
						text += line + System.getProperty("line.separator");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				text += System.getProperty("line.separator");
			}
		}
	}
	
	public void saveToFile(String path){
		newFile = new File(path);
		
		if(!newFile.exists()){
			try{Files.createFile(Paths.get(path));}catch(IOException e){e.printStackTrace();}			
		}
		
		try(FileWriter out = new FileWriter(newFile)){
			out.write(text);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
