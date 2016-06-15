
public class ArrayInverse {
	
	public static void main (String Args[])
	{
		String N = "Nathan";
		System.out.println(reverseTheString(N));
	}
	
	public static String reverseTheString(String N)
	{
		char[] reverse = N.toCharArray();
		
		
		int fir = 0;
		int las = reverse.length-1;
		while(las>fir)
		{
			char temp = reverse[fir];
			reverse[fir] = reverse[las];
			reverse[las] = temp;
			las--;
			fir++;
			
		}
		return new String(reverse);
	}
}
