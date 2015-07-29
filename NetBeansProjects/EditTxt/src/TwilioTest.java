
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;
import com.twilio.sdk.*;
import com.twilio.sdk.resource.factory.*;
import com.twilio.sdk.resource.instance.*;
import java.io.File;
import java.io.PrintWriter;
import java.net.InetAddress;
import org.apache.http.*;
import org.apache.http.message.*;

public class TwilioTest {
    // Find your Account Sid and Token at twilio.com/user/account

    public static final String ACCOUNT_SID = "AC73fe034322ac8ea9e43597c14ee722fb";
    public static final String AUTH_TOKEN = "159d0f3692b513159c7c8fd36a45fd90";
    static InetAddress inet;
    static boolean ping;

    public static void main(String[] args) throws UnknownHostException, IOException, TwilioRestException, InterruptedException {
        String content;
        PrintWriter out;
        int group = 3;
        boolean pinger = false;
        int[] times = new int[group];
        int[] temp = new int[group];
        boolean stop = false;
        boolean ping = false;
        //boolean[] TF = new boolean[group];
        for (int i = 0; i < group; i++) {
            times[i] = 0;
            temp[i] = -1;
        }
        boolean change = false;
        while (true) {
            if (!stop) {
                content = new Scanner(new File("rooms.ini")).useDelimiter("\\Z").next();
                for (int i = 0; i < group; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (content.contains("Status_" + (i + 1) + "=" + j)) {
                            if (temp[i] == j) {
                                times[i]++;
                            } else {
                                temp[i] = j;
                                times[i] = 0;
                            }
                        }
                    }
                }
                for (int i = 0; i < group; i++) {
                    if (times[i] > 19) {
                        for (int k = 0; k < 10; k++) {
                            send("EndBringer Stuck");
                            Thread.sleep(15000);
                        }
                        stop = true;
                    }
                }
            }
            if(!ping){
                if(!ping()){
                    for(int i = 0;i<10;i++){
                        pinger = (pinger || ping());
                    }
                    if(!pinger){
                        for(int i = 0; i<10;i++){
                            send("ice princess asleep");
                            Thread.sleep(15000);
                        }
                        ping = true;
                    }
                }
            }
            Thread.sleep(30000);
        }
    }

    public static boolean ping() throws UnknownHostException, IOException, TwilioRestException, InterruptedException {
        inet = InetAddress.getByAddress(new byte[]{(byte) 192, (byte) 168, 1, (byte) 132});
        if (!inet.isReachable(1000)) {
            return true;
        }
        return false;
    }

    public static void send(String a) throws TwilioRestException {
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        // Build the parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "14154049964"));
        params.add(new BasicNameValuePair("From", "+14159926919"));
        params.add(new BasicNameValuePair("Body", a));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = messageFactory.create(params);
        System.out.println(message.getSid());

    }
}
