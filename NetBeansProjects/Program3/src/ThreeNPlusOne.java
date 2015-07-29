

/**
 * CS146 3n + 1 problem
 * Programming Assignment 6
 * Section 2
 * @author Chun For Tam
 *
 */
public class ThreeNPlusOne
{
	int max;
	int [] values1;
	/**
	 * the constructer of the class
	 */
	public ThreeNPlusOne()
	{
		max = 1000000;
		values1 = new int[max];
		values1[0] = 1;

	}

        public int[] retu(){
            return values1;
        }
	/**
	 * the method that find the cycleLength
	 * @param n the values of n
	 * @return the length of the cycle
	 */
	public int cycleLength(int n)
	{
		int size = 1;
		long backup;

		if ( n!= 1)
		{
			int max1 = 715827882;
			//when the number maybe too big for the system to handle
			if(n >= max1 && n % 2 == 1)//this will gives a number bigger than int
		{
				backup = n;
				while (backup >= max1)
				{
					if (backup % 2 == 0)
					{
						backup = backup / 2;
						size++;
					}
					else if (backup % 2 == 1)
					{
						backup = (3 * backup + 1);
						size++;
					}
				}
				n = (int)backup;
		}
			//normally
				if (n < max && values1[n - 1] != 0)
				{
						size = values1[n - 1];
						return size;
				}
				if (n % 2 == 0)
				{
					size = size + cycleLength(n / 2);
				}
				else if (n % 2 == 1)
				{
					size = size + cycleLength((3 * n + 1));
				}
			}
			if (n < max &&  values1[n - 1] == 0)
			{
				values1[n - 1] = size;
			}
		return size;
	}



	/**
	 * the method that find the maximumcycle length between 2 values
	 * @param i the first value
	 * @param j the second value
	 * @return the maximum lenght
	 */
	public int maximumCycle(int i, int j)
	{
		int max = 0;

		if (i < j)
		{
			for (int start = i; start <= j; start++)
			{
				int count = values1[start - 1];
				if (count != 0)
				{
					if (count > max)
					{
						max = count;
					}
				}
				else
				{
					//System.out.println(start);
					int result = cycleLength(start);
					if (result > max)
					{
						max = result;
					}
				}
			}

		}
		else
		{

			for (int start = j; start <= i; start++)
			{
				int count = values1[start - 1];
				if(count != 0)
				{
					if (count > max)
					{
						max = count;
					}
				}
				else
				{
					//System.out.println(start);
					int result = cycleLength(start);
					if (result > max)
					{
						max = result;
					}
				}
			}
		}

		return max;
	}


}