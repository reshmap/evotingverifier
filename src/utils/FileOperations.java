package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileOperations {
	public static Object loadCollectorBullettinBoard(String filename) throws ClassNotFoundException, IOException{
		Object result = null;
		FileInputStream fileIn = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		result = in.readObject();
		in.close();
		fileIn.close();
		return result;
	}
}
