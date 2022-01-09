//import java.io.FileInputStream;
import java.security.MessageDigest;
 
public class checksum{
 
    public static void main(String args[]) throws Exception {
 
        //String filepath = "C:\\Users\\dineshan.p\\Documents\\Mobius\\temp.txt";
 
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
         
       // FileInputStream fin = new FileInputStream(filepath);
        byte[] dataBytes = new byte[1024];
 
        int bytesRead = 0;
 
        while ((bytesRead = fin.read(dataBytes)) != -1) {
            messageDigest.update(dataBytes, 0, bytesRead);
        }
         
 
        byte[] digestBytes = messageDigest.digest();
 
        StringBuffer sb = new StringBuffer("");
         
        for (int i = 0; i < digestBytes.length; i++) {
            sb.append(Integer.toString((digestBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        System.out.println("File's Checksum: " + sb.toString());
         fin.close();
 
    }
}