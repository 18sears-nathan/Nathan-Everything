
public class SumSquare 
{
	public static void main(String args[])
	{
		int n=0;
		for(int i=0; i<=100; i++)
		{
			n=i*i+n;
		}
		System.out.println(n);
		
		int n1=0;
		for(int i=0; i<=100; i++)
		{
			n1=i+n1;
		}
		int n3 = n1*n1;
		System.out.println(n3);
		
		int n2 =n3-n;
		System.out.print(n2);
	}
}
