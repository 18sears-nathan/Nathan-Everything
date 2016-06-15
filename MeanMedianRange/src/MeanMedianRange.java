/************************************************
 * 
 * Class: MeanMedianRange
 * Author: Greg King
 * Date: September 16, 2013
 * 
 * This program computes and displays the mean,
 * median and range of a randomly generated 
 * set of data.
 *
 * Date			Activity
 * 9/16/13		Main coding
 * 
 ************************************************/


public class MeanMedianRange 
{
	public static void main(String[] args)
	{
		// Create an array and fill it with random values
		int[] data = new int[20];
		for(int n=0; n<data.length; n++)
		{
			data[n] = (int)(Math.random()*100+1);
		}
		
		// Print out the array
		for(int n=0; n<data.length; n++)
		{
			System.out.print(data[n]+"\t");
			if(n%5==4)
				System.out.println();
		}
		
		int sum = 0;
		
		for(int i = data.length; i > 0; i--)
		{
		
		sum = sum + data[i];
		}
		double mean = sum/data.length;
		
		int hi = 0;
		int lo = 101;
		for(int i = data.length; i > 0; i--)
		{
			if(data[i]>hi)
			{
				hi = data[i];
			}
			if(data[i]<lo)
			{
				lo = data[i];
			}
		}
		int range = hi-lo;
		
		for(int a = 0; a < data.length; a++)
		{
			for(int b = a+1; b < data.length; b++)
			{
				if(data[a] > data[b])
				{
					int temp = data[b];
					data[b] = data[a];
					data[a] = temp;
				}
			}
		}
		int median = 0;
		if(data.length % 2 != 0)
		{
			median = data[(data.length/2)];
		}
		else
			median = (data[(data.length)/2]+data[(data.length-1)/2])/2;
		
		System.out.println("  The mean is: "+mean);
		
		for(int n=0; n<data.length; n++)
		{
			System.out.print(data[n]+"\t");
			if(n%5==4)
				System.out.println();
		}
		
		System.out.println("The median is: "+median);
		
		for(int n=0; n<data.length; n++)
		{
			System.out.print(data[n]+"\t");
			if(n%5==4)
				System.out.println();
		}
		
		System.out.println(" The range is: "+range);
	}
}
