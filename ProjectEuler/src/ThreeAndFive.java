
public class ThreeAndFive {

	public static void main(String[] args)
	{
		EasyReader console = new EasyReader();
		
		int sum = 0;
		for(int i = 0; i < 1000; i++)
		{
			if (i % 3 == 0 || i % 5 == 0)
			{
				sum = sum+i;
			}
		}
		
		System.out.print(sum);
	}
}
