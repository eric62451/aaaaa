/**
 * Eric Tam
 * 007989423
 * CS166
 * 2/12/2015
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageCipher {

   
    public static void main(String[] args) throws IOException {
        /* Create a cipher using the first 16 bytes of the passphrase */
        TEA cipher = new TEA("And is there honey still for tea?".getBytes());

        byte[] data = Files.readAllBytes(new File("alice.bmp").toPath());
        byte[] encrypt = new byte[data.length-80];
        System.arraycopy(data, 80, encrypt, 0, data.length-80);

        /* Run it through the cipher... and back */
        byte[] crypt = cipher.encrypt(encrypt);
        byte[] fin = new byte[data.length];
        for(int i = 0; i<data.length;i++){
            if(i<80){
                fin[i] = data[i];
            } else fin[i] = crypt[i-80];
        }
        Files.write(Paths.get("EncryptedAlice.bmp"), fin);

    }
}
