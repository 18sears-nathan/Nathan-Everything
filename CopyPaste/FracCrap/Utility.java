/*
 * 	Date		Task
 * 10/2/2105	Coding started
 */

/**
 * This class has a number of (mostly mathematical) utility
 * methods to be used in other classes. 
 * @author king_greg
 * @version 1.0
 * @since 10-2-2015
 * 
 */
public class Utility 
{
	/**
	 * Returns true if n is a prime number, false otherwise
	 * @param n number to be evaluated
	 * @return true if n is prime, false otherwise
	 */
	public static boolean isPrime(int n)
	{
		if(n<2)
			return false;
		if(n==2)
			return true;
		if(n%2==0)
			return false;
		for(int i=3; i<=Math.sqrt(n); i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	
	/**
	 * Finds the greatest common factor of two positive
	 * integers. Returns -1 if either of the integers is
	 * not positive
	 * @param a one of the integers
	 * @param b one of the integers
	 * @return the greatest common factor of a and b
	 */
	public static int gcf(int a, int b)
	{
		if(a<1 || b<1)
			return -1;
		// Make sure a is the larger number
		if(a<b)
		{
			int temp = a;
			a = b;
			b = temp;
		}
		// Start at the smaller number and count down 
		// looking for common factors. The first one you
		// find will be the GCF.
		for(int i= b; i>1; i--)
		{
			if(a%i==0)
			{
				if(b%i==0)
				{
					return i;
				}
			}
		}
		return 1;  // if no other common factor exists
	}
	
	public static void primeFactors(int number)
	{
		
	
	if (isPrime(number))
	{
		System.out.println(number+"");
	}
	
	else
	{
		//Loop while number is greater than i
		for (int i=2; i <=number; i++)
		{
			//Display i while number is divisible by i
			
			while (number % i ==0)
			{
				System.out.println(i+", ");
				number=number/i;
			}
		}
	}
	}
	public static int lcm(int a, int b)
	{
		int lcm = a*b / gcf(a, b);
		
		return lcm;
	}
	
	public static void factorial(int number)
	{
		int factorial = 1;
		
		if (number == 0)
			factorial = 1;
		
		int j = 1;
		
		if (j == 1)
		{
			int answer = 1;
			
			for(int i = number; i >= 1; i --)
			{
				answer = i * answer;
			}
			j ++;
			factorial = answer;
		}
		System.out.print(factorial + "\n");
	
	}
}