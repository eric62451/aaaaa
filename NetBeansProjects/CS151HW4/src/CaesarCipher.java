/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * 5.12
 */
public class CaesarCipher
{
   public void encrypt(char[] str, int off, int len)
   {
      for(int i = off; i < off + len; i++)
      {
         char c = str[i];
         if (Character.isLetter(c))
         {
            c = (char) ((int) c + CAESAR_OFFSET);
            if (!Character.isLetter(c))
               c = (char) ((int) c - ALPHABET_SIZE);
            str[i] = c;
         }
      }  
   }

   public void decrypt(char[] str, int off, int len)
   {
      for(int i = off; i < off + len; i++)
      {
         char c = str[i];
         if (Character.isLetter(c))
         {
            c = (char) ((int) c - CAESAR_OFFSET);
            if (!Character.isLetter(c))
               c = (char) ((int) c + ALPHABET_SIZE);
            str[i] = c;
         }
      }  
   }

   static final int CAESAR_OFFSET = 3;
   static final int ALPHABET_SIZE = 26;
}
