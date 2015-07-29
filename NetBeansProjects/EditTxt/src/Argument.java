import java.util.ArrayList;

public class Argument 
{
	String name;	// Name of argument
	int type;		// Data type of argument
					// Valid types:
					//	1 = Numeric argument
					//  2 = Alphanumeric argument
	String value;	// Return location for value found in parsed command line argument
	
	ArrayList<String> validValues = new ArrayList<String>();	// Array of valid argument values (if any)
	
	public void AddValidValue(String data)
	{
		validValues.add(data);
	}
}
