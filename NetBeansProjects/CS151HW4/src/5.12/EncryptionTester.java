
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * 5.12
 */
class EncryptionTester {

    /**
    Creates EncryptingWriter and DecryptingReader objects and uses them
    to write to and read from a file
     */
    public static void main(String[] args) throws IOException {



        char hi[] =
                "hi, how are you?".toCharArray();
        System.out.print("Original: ");
        System.out.println(hi);
        EncryptingWriter a = new EncryptingWriter(new FileWriter("test.out"));
        a.write(hi, 0, hi.length);
        System.out.print("Encrypted: ");
        System.out.println(hi);

        DecryptingReader b = new DecryptingReader(new FileReader("test.out"));
        b.read(hi, 0, hi.length);
        System.out.print("Decrypted: ");
        System.out.println(hi);

        char abc[] =
                "abcdefghIJKLMNOPQRSTUVWXYZ".toCharArray();
        System.out.print("Original: ");
        System.out.println(abc);
        EncryptingWriter c = new EncryptingWriter(new FileWriter("test.out"));
        c.write(abc, 0, abc.length);
        System.out.print("Encrypted: ");
        System.out.println(abc);

        DecryptingReader d = new DecryptingReader(new FileReader("test.out"));
        d.read(abc, 0, abc.length);
        System.out.print("Decrypted: ");
        System.out.println(abc);

    }
}
