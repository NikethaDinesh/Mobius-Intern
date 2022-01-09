import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
//import javax.xml.bind.DatatypeConverter;

public class AESencrypt_decrypt{
	
	public static void main(String ar[])throws Exception{
	//hardcode 5 username and password
		Hashtable<String,String> ht=new Hashtable<String,String>();
		ht.put("sehun","viviishome");
		ht.put("loey","tobenincall");
		ht.put("chen","angelvoice");
		ht.put("kai","dancemachine");
		ht.put("suho","vocalthings");
	
		String key;
	//get user details	
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Username:");
		String uname=sc.nextLine();
		
		System.out.print("Enter Password:");
		String pwd=sc.next();
	//encrypt-username
		SecretKey secretkey = getSecretEncryptionKey();
        byte[] cipherText = encryptInput(uname, secretkey);
        String decryptedUname = decryptInput(cipherText, secretkey);
    //encrypt-password
		SecretKey secretkey1= getSecretEncryptionKey();
        byte[] cipherText1 = encryptInput(pwd, secretkey1);
        String decryptedPwd = decryptInput(cipherText1, secretkey1);
	//checks if decrypted value is same as hardcoded value
		Enumeration code=ht.keys();
		int flag=0;
			while(code.hasMoreElements()){
				key=(String)code.nextElement();
				if(decryptedUname.equals(key) && decryptedPwd.equals(ht.get(key))){
					flag=1;
					break;
				}
				else{
					flag=0;
				}
			}
			if(flag==1){
				System.out.println("User Authentication Pass");
			}
			else{
				System.out.println("Authentication Fail");
			}
	}
	//key-generation
	public static SecretKey getSecretEncryptionKey() throws Exception{
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(128);
        SecretKey secKey = keygen.generateKey();
        return secKey;
    }
	//encryption
	public static byte[] encryptInput(String inputText,SecretKey secretkey) throws Exception{
		Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretkey);
        byte[] byteCipherText = aesCipher.doFinal(inputText.getBytes());
        return byteCipherText;
    }
	//decryption
	public static String decryptInput(byte[] byteCipherText, SecretKey secretkey) throws Exception {
		Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secretkey);
        byte[] byteInputText = aesCipher.doFinal(byteCipherText);
        return new String(byteInputText);
    }
}