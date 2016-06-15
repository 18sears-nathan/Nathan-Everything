import java.util.ArrayList;
public class NumberOfPrimes 
{
	public static void main(String args[])
	{
		ArrayList<Integer> primeList = new ArrayList<Integer>();

		int i=0;
		int counter=0;
		do
		{
			if(isPrime(i)==true)
			{
				primeList.add(i);
				System.out.println(i);
				counter++;
			}
		i++;
		}while(primeList.size()<10001);
		System.out.print(counter);
		
	}
	public static boolean isPrime(int num)
	{

		if (num<2)
			return false;
		else if (num==2)
			return true;
		else if (num%2==0)
			return false;
		
		for (int i = 3; i <= Math.sqrt(num);i = i+2){
			if (num%i == 0)
				return false;
		}
		return true;
	}
}
