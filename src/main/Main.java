package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import utils.Essentials;
import utils.FileOperations;

public class Main {

	/**
	 * @param args
	 */
	
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Map<String,byte[]> collectorBullettinBoard=(Map<String, byte[]>) FileOperations.loadMap(args[0]);
		@SuppressWarnings("unchecked")
		Map<String,Key> pvidToKeyMap = (Map<String,Key>) FileOperations.loadMap(args[1]);
		while(true){
			System.out.println("Verify option selected");
			System.out.println("Enter PVID");
			String PVID = reader.readLine();
			System.out.println("Enter Your Vote");
			int vote=Integer.parseInt(reader.readLine());
			Key key=pvidToKeyMap.get(PVID);
			if(!collectorBullettinBoard.containsKey(PVID))
				System.out.println("You have not voted");
			else
			if(Arrays.equals(collectorBullettinBoard.get(PVID), Essentials.hashOf(encryptVote(key,vote))))
				System.out.println("Your Vote has been recorded correctly");
			else
				System.out.println("Your Vote is not recorded correctly");
		}
	}
	private static byte[] encryptVote(Key key, int vote) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedVote = cipher.doFinal(new Integer(vote).toString().getBytes());
		return encryptedVote;
	}

}
