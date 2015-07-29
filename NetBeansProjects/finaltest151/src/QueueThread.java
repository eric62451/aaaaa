import java.net.*;
import java.io.*;

public class QueueThread extends Thread
{
    private Socket socket = null;

    public QueueThread(Socket socket)
    {
        super("QueueThread");

        this.socket = socket;
    }

    public void run()
    {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));)
        {
            String SocketMessage;

            whileloop: while ((SocketMessage = in.readLine()) != null)
            {
            	if(SocketMessage.contains("|"))
				{
					try
					{
						String[] strMessage = SocketMessage.split("\\|");

						if(strMessage.length == 3)
						{
							switch(strMessage[0].toLowerCase())
							{
								case "write":
									System.out.println("Write something");
									break;
								case "read":
									System.out.println("Read something");
									break;
								case "peek":
									System.out.println("Peek something");
									break;
								case "scan":
									System.out.println("scan something");
									break;
								case "drop":
									System.out.println("drop something");
									break;
								case "stop":
									System.out.println("stop something");
									break whileloop;
								default:
									System.out.println("Invalid message");
									break;
							}
						}
						else
						{
							System.err.print("Invalid_Socket_Message_Error (not length 3)");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();

						System.err.print("Invalid_Socket_Message_Error (Split Error)");
					}
				}
            	else
            	{
            		System.err.print("Invalid_Socket_Message_Error (doesnt contain | )");
            	}
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}