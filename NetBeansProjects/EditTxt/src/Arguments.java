import java.util.ArrayList;

public class Arguments 
{
	private ArrayList<Argument> validArgs = new ArrayList<Argument>();

	int NumberOfArguments;
	
	String[] ss;
	
	String[][] sss;
	
	int index;
	
	public enum ArgumentErrors
	{
		no_error,
		invalid_format,
		invalid_name,
		invalid_type,
		invalid_value;
	}
	
	public ArgumentErrors checkInput(String input)
	{		
		// 1) Parse the input
		// 2) Return error is not formatted properly
		// 3) Does argument name exist, return error if not
		// 4) Does argument type match, return error if not
		// 5) Does argument value exist, return error if not
		
		if(checkFormat(input) != ArgumentErrors.no_error)
		{
			if(checkName() != ArgumentErrors.no_error)
			{
				if(checkType() != ArgumentErrors.no_error)
				{
					if(checkValid() != ArgumentErrors.no_error)
					{
						return(ArgumentErrors.no_error);
					}
					else
					{
						return(ArgumentErrors.invalid_value);
					}
				}
				else
				{
					return(ArgumentErrors.invalid_type);
				}
			}
			else
			{
				return(ArgumentErrors.invalid_name);
			}
		}
		else
		{
			return(ArgumentErrors.invalid_format);
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	
	private ArgumentErrors checkFormat(String input)
	{
		
		boolean correctFormat = false;
		
		if(input.contains("/") && input.contains(":"))
		{		
			try
			{
				ss = input.split("/");
				
				NumberOfArguments = ss.length - 1;
				
				try
				{
					sss = new String[NumberOfArguments][];
					
					for(int i = 1; i < ss.length; i++)
					{
						this.sss[i-1] = ss[i].split(":", 2);
						
						for(int j = 0; j < ss.length; j++)
						{	
							for(int k = 0; k < sss[j].length; k++)
							{
								if(sss[j][k] != null && !sss[j][k].isEmpty())
								{
									correctFormat = true;
								}
								else
								{
									correctFormat = false;
								}
							}
						}
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					
					correctFormat = false;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				correctFormat = false;
			}
		}
		else
		{
			correctFormat = false;
			
			System.out.println("/ or : missing");
		}
				
		if(correctFormat == true)
		{
			return(ArgumentErrors.no_error);
		}
		else
		{
			return(ArgumentErrors.invalid_format);
		}

	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	private ArgumentErrors checkName()
	{
		boolean CorrectName = false;
		
		for(int i = 0; i < ss.length; i++)
		{
			for(int j = 0; j < validArgs.size(); j++)
			{
				if(sss[i][j].equalsIgnoreCase(validArgs.get(j).name))
				{
					CorrectName = true;
				}
				else
				{
					CorrectName = false;
				}
			}
		}
		
		if(CorrectName == true)
		{
			return(ArgumentErrors.no_error);
		}
		else
		{
			return(ArgumentErrors.invalid_name);
		}
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private ArgumentErrors checkType()
	{	
		boolean CorrectType = false;
		
		try
		{
			for(int i = 0; i < ss.length; i++)
			{
				if(sss[i][1] instanceof String && findArgument(sss[i][0]).type == 2)
				{
					CorrectType = true;
				}
				else if(Integer.parseInt(sss[i][1]) == Integer.valueOf(sss[i][1])&& findArgument(sss[i][0]).type == 1)
				{
					CorrectType = true;
				}
				else
				{
					CorrectType = false;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			CorrectType = false;
		}
		
		if(CorrectType == true)
		{
			return(ArgumentErrors.no_error);
		}
		else
		{
			return(ArgumentErrors.invalid_type);
		}
	}
	
	private ArgumentErrors checkValid()
	{
		boolean CorrectValue = false;
		
		try
		{
			for(int i = 0; i < ss.length; i++)
			{
				CorrectValue = false;
				
				if(findArgument(sss[i][0]).validValues != null)
				{
					for(int j = 0; j < findArgument(sss[i][0]).validValues.size(); j++)
					{
						if(sss[i][1].equalsIgnoreCase((findArgument(sss[i][0]).validValues.get(j))))
						{
							findArgument(sss[i][0]).value = sss[i][1];
							
							CorrectValue = true;
							
							break;
						}
					}
				}
				else
				{
					findArgument(sss[i][0]).value = sss[i][1];
					
					CorrectValue = true;
				}
				
				if(CorrectValue = false)
				{
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			CorrectValue = false;
		}
		
		if(CorrectValue == true)
		{
			return(ArgumentErrors.no_error);
		}
		else
		{
			return(ArgumentErrors.invalid_value);
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void addArguments(String name, int type)
	{

		if(validArgs == null)
		{
			System.out.println("validArgs null;cant add");
			
		}
		else
		{
			validArgs.add(new Argument());
			
			System.out.println("New Argument added");
			
			index = validArgs.size() - 1;
			
			validArgs.get(index).name = name;	
			
			validArgs.get(index).type = type;
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public Argument findArgument(int index)
	{
		if(index + 1 > validArgs.size())
		{
			return null;
		}
		else
		{
			return validArgs.get(index);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Argument findArgument(String index)
	{
		for(int i = 0; i < validArgs.size(); i++)
		{
			if (index.equalsIgnoreCase(validArgs.get(i).name))
			{
				return validArgs.get(i);
			}
		}
		
		return null;
	}	
}

