import java.util.ArrayList;

public class Collatz 
{
	public static void main(String args[])
	{
		int largest=0;
		for(int i = 1000000; i>1; i--)
		{
			if(sequence(i)>largest)
			{
				largest = i;
			}
			
		}
		System.out.print(largest);
	}
	public static boolean isEven(int num)
	{
		if(num%2 ==0)
			return true;
		else
			return false;
	}
	public static int sequence(int n1)
	{
		int counter = 0;
		do
		{
			if(isEven(n1))
				n1=n1/2;
			else
				n1=(n1*3)+1;
			counter++;
		}while(n1>1);
		return counter;
	}
}