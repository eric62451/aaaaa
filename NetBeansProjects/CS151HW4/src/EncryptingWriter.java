import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Eric Tam
 * CS151 - Section 1
 * Homework 4
 * 5.12
 */
public class EncryptingWriter extends Writer{
	
	private Writer writer;

	public EncryptingWriter(Writer write) {

		this.writer = write;
	}

	@Override
	public void close() throws IOException {
		writer.close();
		
	}

	@Override
	public void flush() throws IOException {
		writer.flush();
		
	}

	@Override
	public void write(char[] arg0, int arg1, int arg2) throws IOException {
		
		CaesarCipher cipher = new CaesarCipher();
		cipher.encrypt(arg0, arg1, arg2);
		
	}

}
