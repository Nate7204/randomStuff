
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JOptionPane;
 

public class Encrypt 
{  
		static final String key = "NATE";/*JOptionPane.showInputDialog("Enter a Key!");*/

   private static String encryptString(String str)
   {
      StringBuffer sb = new StringBuffer (str);

      int lenStr = str.length();
      int lenKey = key.length();
	   
      // For each character in our string, encrypt it...
      for ( int i = 0, j = 0; i < lenStr; i++, j++ ) 
      {
         if ( j >= lenKey ) j = 0;  // Wrap around to beginning of key string.
         // XOR the chars together. Must cast back to char to avoid compile error. 
         sb.setCharAt(i, (char)(str.charAt(i) ^ key.charAt(j))); 
      }

      return sb.toString();
   }
   
   private static String decryptString(String str)
   {
      // To 'decrypt' the string, simply apply the same technique.
      return encryptString(str);
   }
   
   
   public static void main(String[] args) 
   {
	
	  
	  String s1 = JOptionPane.showInputDialog("Enter a String!");

      String s2 = encryptString(s1);

      String s3 = decryptString(s2);

      System.out.println("Original string:  " + s1);

      System.out.println("Encrypted string: " + s2);
      
      System.out.println("Decrypted string: " + s3);
      
      JOptionPane.showMessageDialog(null,"Encrypted string: " + s2);      
      
      File newFile = new File("C:\\Users\\Nathan Schaper\\Desktop\\Encryption.txt"/*Txt means it will be saved as a notepad file*/);
      if (newFile.exists())//If the file already exists
          JOptionPane.showMessageDialog(null, "The file already exists!");//Then this message will come up!
     else
      {
         try
       {       
          newFile.createNewFile();//This creates a new file
         }
         catch (Exception e)//If something goes wrong.  But nothing will go wrong because it has already checked that the file doesn't exist
        {
             e.printStackTrace();//Tracer from Star Wars
       }
         try
       {
         FileWriter fileW = new FileWriter(newFile);
       BufferedWriter buffW = new BufferedWriter(fileW);//The text writer
        buffW.write(s2);//The message
        buffW.close();
        JOptionPane.showMessageDialog(null, "File Written!");//Success
        }
         catch (Exception e)
       {
             e.printStackTrace();//Another tracer from Star Wars
       }  
      
      
   }
}
}