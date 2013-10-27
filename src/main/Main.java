package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import utils.Essentials;
import utils.FileOperations;

public class Main {

	/**
	 * @param args
	 */
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Map<String,String> collectorBullettinBoard=(Map<String, String>) FileOperations.loadCollectorBullettinBoard(args[0]);
		while(true){
			System.out.println("Verify option selected");
			System.out.println("Enter PVID");
			String PVID = reader.readLine();
			System.out.println("Enter Encrypted Vote");
			String encryptedVoteToVerify = reader.readLine();
			if(collectorBullettinBoard.get(PVID).equals(Essentials.hashOf(encryptedVoteToVerify)))
				System.out.println("Your Vote has been recorded correctly");
			else
				System.out.println("Your Vote is not recorded correctly");
		}
	}

}
