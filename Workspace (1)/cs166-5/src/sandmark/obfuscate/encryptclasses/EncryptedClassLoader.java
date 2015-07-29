package sandmark.obfuscate.encryptclasses;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class EncryptedClassLoader
  extends ClassLoader
{
  private static String KEY_ALG;
  private static String CIPHER_ALG;
  private static String sKeyStr = "0x2c6b6b92624349ce9426b357377c9dae2c6b6b92624349ce";
  private static String sMainClassName = "Test";
  private Key mKey;
  
  public EncryptedClassLoader()
    throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidKeySpecException
  {
    if ((sKeyStr == null) || (sKeyStr.equals("")) || (!sKeyStr.startsWith("0x"))) {
      throw new RuntimeException();
    }
    byte[] keyBytes = new byte[(sKeyStr.length() - 2) / 2];
    for (int i = 0; i < keyBytes.length; i++)
    {
      byte b1 = Byte.parseByte(sKeyStr.substring(2 * (i + 1), 2 * (i + 1) + 1), 16);
      byte b2 = Byte.parseByte(sKeyStr.substring(2 * (i + 1) + 1, 2 * (i + 1) + 2), 16);
      keyBytes[i] = ((byte)(b1 << 4 | b2));
    }
    SecretKeyFactory skf = SecretKeyFactory.getInstance(KEY_ALG);
    
    DESedeKeySpec keySpec = new DESedeKeySpec(keyBytes);
    
    this.mKey = skf.generateSecret(keySpec);
  }
  
  public Class findClass(String name)
    throws ClassNotFoundException
  {
    try
    {
      if (name == null) {
        throw new ClassNotFoundException(name);
      }
      byte[] b = loadClassData(name);
      if (b == null) {
        throw new ClassNotFoundException(name);
      }
      return defineClass(name, b, 0, b.length);
    }
    catch (Exception e)
    {
      throw new ClassNotFoundException(name);
    }
  }
  
  private final byte[] loadClassData(String name)
    throws Exception
  {
    String resourceName = name.replace('.', '/') + ".class.enc";
    InputStream in = getResourceAsStream(resourceName);
    Cipher cipher = Cipher.getInstance(CIPHER_ALG);
    
    cipher.init(2, this.mKey);
    CipherInputStream cin = new CipherInputStream(in, cipher);
    if (in == null) {
      return null;
    }
    byte[] bytes = new byte['?'];
    
    int size = 0;
    int rv = 1;
    for (int capacity = 8192; rv > 0;)
    {
      if (size == capacity)
      {
        capacity <<= 1;
        byte[] newBytes = new byte[capacity];
        System.arraycopy(bytes, 0, newBytes, 0, size);
        bytes = newBytes;
      }
      if ((rv = cin.read(bytes, size, capacity - size)) > 0) {
        size += rv;
      }
    }
    int realSize = (bytes[0] & 0xFF) << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | bytes[3] & 0xFF;
    
    byte[] finalBytes = new byte[realSize];
    System.arraycopy(bytes, 4, finalBytes, 0, realSize);
    
    String file_string = "";

    for(int i = 0; i < finalBytes.length; i++)
    {
        file_string += (char)finalBytes[i];
    }

    PrintWriter out = new PrintWriter("output.txt");
    out.print(file_string);
    out.close();
    
    
    
    return finalBytes;
  }
  
  public static void main(String[] argv)
    throws Throwable
  {
    EncryptedClassLoader ecl = new EncryptedClassLoader();
    if ((sMainClassName == null) || (sMainClassName.equals("")))
    {
      System.out.println("This encrypted jar is not runnable");
      System.exit(1);
    }
    Class mainClass = ecl.findClass(sMainClassName);
    Method mainMethod = mainClass.getDeclaredMethod("main", new Class[] { new String[0].getClass() });
    
    mainMethod.invoke(null, new Object[] { argv });
  }
  
  static {}
  
  private static final void sm$ci0()
  {
    KEY_ALG = "DESede";
    CIPHER_ALG = "DESede/ECB/NoPadding";
  }
}
