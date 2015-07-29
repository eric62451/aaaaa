import java.io.IOException;
import java.io.Reader;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * 5.12
 */
public class DecryptingReader extends Reader{
	
	private Reader reader;

	public DecryptingReader(Reader reader)
	{
		this.reader = reader;
	}

	@Override
	public void close() throws IOException {
		reader.close();
		
	}

	public int read(char[] ch, int a, int b) throws IOException {
		CaesarCipher cipher = new CaesarCipher();
		cipher.decrypt(ch,a,b);
		return b-a;
		
	}

}
