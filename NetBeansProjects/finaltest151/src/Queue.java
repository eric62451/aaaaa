import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

///////////////////////////////////////////////////////////////

public class Queue
{
	private ArrayList<StarQueue> Config;

	int index = 0;

	int NumberOfQueue;

	int SpecificHeader;

	String QueueName;

	int portNumber;

	String path;

	///////////////////////////////////////////////////////////////////////////

	private class StarQueue
	{
		String Header;

		String Location;

		int LastItem = 0;
	}

	//////////////////////////////////////////////////////////////////////////

	public Queue(int portNumber, String portName, String argConfigurationFile)
	{
		this.QueueName = portName;

		this.portNumber = portNumber;

		this.path = argConfigurationFile;
	}

	////////////////////////////////////////////////////////////////////////

	public enum ConfigErrors
	{
		no_error,
		cant_open,
		cant_read,
	}

	////////////////////////////////////////////////////////////////////////

	public void LoadConfig(String path)
	{
		if(Config == null)
		{
			Config = new ArrayList<StarQueue>();
		}

		try
		{
			ReadXml(path);

			System.out.println("Finish loading Config");
		}
		catch(Exception e)
		{
			System.out.println("Problem reading the xml file/Problem loading Config");

			e.printStackTrace();

			System.exit(-1);
		}

	}

	/////////////////////////////////////////////////////////////////////////////////

	public void check()
	{
		for(int i = 0; i < Config.size(); i++ )
		{
			System.out.println(" ");
			System.out.println(i + " -------------------------------");
			System.out.println(" ");
			System.out.println("Header: " + Config.get(i).Header);
			System.out.println("Location: " + Config.get(i).Location);
			System.out.println("LastItem: " + Config.get(i).LastItem);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////

	private ConfigErrors ReadXml(String path)
	{
		boolean CanOpen = false;

		boolean CanRead = false;

		try {
			 	//////////////////setting up XML reader //////////////////////////////////////

				if(path.endsWith("xml"))
				{
					CanOpen = true;
				}
				else
				{
					System.out.println("path not correct");

					CanOpen = false;

					return (ConfigErrors.cant_open);
				}

				File XmlFile = new File(path);

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

				Document doc = dBuilder.parse(XmlFile);

				doc.getDocumentElement().normalize();

				NodeList nList = doc.getElementsByTagName("QueueConfig");

				/////////////////////////////////////////////////////////////////////////////////

				for (int temp = 0; temp < nList.getLength(); temp++)
				{
					Node nNode = nList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE)
					{
						Config.add(index, new StarQueue());

						Element eElement = (Element) nNode;

						Config.get(index).Header = eElement.getAttribute("Header");

						Config.get(index).Location = eElement.getAttribute("Location");
					}

					index++;
				}

				 NumberOfQueue = Config.size();

				CanRead = true;
		    }
			catch (Exception e)
			{
				e.printStackTrace();

				CanRead = false;

				return (ConfigErrors.cant_read);
		    }

			if(CanOpen == false)
			{
				return (ConfigErrors.cant_open);
			}
			else if(CanRead == false)
			{
				return (ConfigErrors.cant_read);
			}
			else
			{
				return (ConfigErrors.no_error);
			}
	}

	//////////////////////////////////////////////////////////////////////////////////

	public boolean FindQueue(String Header, Queue LoadConfig)
	{

		boolean found = false;

		for(int i = 0; i < LoadConfig.NumberOfQueue; i++)
		{
			if(Header.equalsIgnoreCase(LoadConfig.Config.get(i).Header))
			{
				found = true;

				SpecificHeader = i;

				break;
			}
		}

		if(found == true)
		{
			System.out.println("Header was found");

			return true;
		}
		else
		{
			System.out.println("Header not found");

			return false;
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////

	public void LoadQueues()
	{
		for(int i = 0; i < Config.size(); i++)
		{
			if(Config.get(i).Location == null)
			{
				System.err.println("Queue_Location_Not_Found for " + Config.get(i).Header);

				System.exit(-1);
			}
			else
			{
				File folder = new File(Config.get(i).Location);

				File[] listOfFiles = folder.listFiles();

				String fileName;

				for (File file : listOfFiles)
				{
					if (file.isFile() && !file.isDirectory() )
					{
						fileName = file.getName();

						/*

						if (fileName.indexOf(".") > 0)
						{
						    fileName = fileName.substring(0, fileName.lastIndexOf("."));

						    System.out.println("Modified File Name(has extention): " + fileName);
						}
						else
						{
							System.out.println("Original File Name(no extention): " + fileName);
						}
						*/

						System.out.println("Original File Name(with extention): " + fileName);

						try
						{
							String[] strQueItem = fileName.split(".");

							String tempInt = strQueItem[4].split("N")[1];

							int numLastItem = Integer.parseInt(tempInt);

							if(numLastItem > Config.get(i).LastItem)
							{
								Config.get(i).LastItem = numLastItem;
							}
						}
						catch(Exception e)
						{
							System.err.println("Problems Loading Queues");

							e.printStackTrace();

							System.exit(-1);
						}
					}
					else
					{
						System.out.println("No valid File exists in the location direction");

						System.exit(-1);
					}
				}
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////

	public void ProcessRequests()
	{
	    try (ServerSocket serverSocket = new ServerSocket(portNumber))
        {
            while (true)
            {
	            new QueueThread(serverSocket.accept()).start();
	        }
	    }
        catch (IOException e)
        {
            System.err.println("Could not listen on port " + portNumber);

            System.exit(-1);
        }
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	public void Write(String QueueItem, String QueueData)
	{
		if(ValidateItem(4, QueueItem) == false)
		{
			System.err.println("Invalid_Message_item");

			return;
		}

		for(int i = 0; i < Config.size(); i++)
		{
			if(QueueItem.equalsIgnoreCase(Config.get(i).Header))
			{
				Config.get(i).LastItem++;

				System.out.println("Enter the path of the text file you want to write");

				try(Scanner scanner = new Scanner(System.in))
				{
					String LastItem_String = Integer.toString(Config.get(i).LastItem);

					int digit = (int)(Math.log10(Config.get(i).LastItem) + 1);

					if(Config.get(i).LastItem == 0)
					{
						LastItem_String = "0000";
					}
					else if(digit < 4)
					{
						for(int j = 0; j < digit; j++)
						{
							LastItem_String = "0" + LastItem_String;
						}
					}

					System.out.println(LastItem_String);

					String path = scanner.nextLine() + "\\" + QueueItem + "." + "N" + LastItem_String + ".txt";

					BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));

					writer.write(QueueData);

					System.out.println("Done writing the file");

					writer.newLine();

					writer.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();

					System.out.println("problem writing the text file");
				}
			}
		}

	}

	/////////////////////////////////////////////////////////////////////////////////////

	private boolean ValidateItem(int RequiredElements, String QueueItem)
	{
		String[] strItems = QueueItem.split(".");

		if(strItems.length < RequiredElements)
		{
			System.err.println("Invalid_Queue_Item_Error");

			return false;
		}

		Boolean bFound = false;

		for(int i = 0; i < Config.size(); i++)
		{
			if(strItems[0].equalsIgnoreCase(Config.get(i).Header))
			{
				bFound = true;

				break;
			}
		}

		System.out.println(bFound.toString());

		if(bFound == false)
		{
			System.err.println("Invalid_Queue_Name_Error");

			return false;
		}
		else
		{
			return true;
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////


}