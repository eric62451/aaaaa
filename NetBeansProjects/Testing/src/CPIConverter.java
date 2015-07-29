
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class CPIConverter {

    private static final int FIRST_YEAR = 1913;
    private static final int LAST_YEAR = 2003;
    private String line;
    double yes = 0;
    String loc;

    public void read(String location) throws MalformedURLException, IOException {
        try {
            loc = location;
            URL url = new URL(location);
            URLConnection urlConnection = url.openConnection();

            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.setConnectTimeout(5000);

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                URL cpiURL = new URL(location);
                InputStream cpiIn = cpiURL.openStream();
                Scanner in = new Scanner(cpiIn);
                in.nextLine();
                line = in.nextLine();
                if (line.contains("Testing")) {
                    yes = 1;
                }
            }
        } catch (java.net.SocketTimeoutException e) {
            read(loc);
        } catch (java.io.IOException e) {
            read(loc);
        }
    }

    public double equivalentAmount() {
        return yes;
    }
}
