package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.Document;

public class Diary {

	public static void addDiary(String pathname, String title, String txt){
		
		File save_dir = new File(pathname);
		
		save_dir.mkdir();
		
		File diary = new File(save_dir, title + ".ky");
		
		BufferedWriter bufw = null;
		
		
		try{
			
			bufw = new BufferedWriter(new FileWriter(diary, true));
			bufw.write(txt);
			
		}catch(IOException e){
			
			e.printStackTrace();
		}finally{
			
			if(bufw != null){
				
				try {
					bufw.close();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
		}
	}
	
	//read content from a file into the diary
	public static void read(File file, Document doc){
		
		BufferedReader bufr = null;
		
		try{
			bufr = new BufferedReader(new FileReader(file));
			
			String txt = null;
			
			String separator = System.getProperty("line.separator");
			
			while((txt = bufr.readLine()) != null){
				
				//append txt to the end of document
				doc.insertString(doc.getLength(), txt + separator, null);
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	
	
}
