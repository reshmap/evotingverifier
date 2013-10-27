package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Essentials {
	public static String hashOf(String encryptedVote) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		MessageDigest msgDigest=MessageDigest.getInstance("MD5");
		msgDigest.update(encryptedVote.getBytes(), 0, encryptedVote.length());
		BigInteger hash= new BigInteger(1, msgDigest.digest());
		return hash.toString(16);
	}
}
