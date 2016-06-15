
class HelloWorld 
{

	public static void main(String[] args) 
	{
		EasyReader console = new EasyReader();
		int daddy;
		int mommy;
		System.out.println("type a number");
		daddy= console.readInt();
		System.out.println("type a second number");
		mommy= console.readInt();
		System.out.println(checking(daddy));
		System.out.println(checking(mommy));
	}
	public static int checking (int x)
	{
		if (x==21)
		{
			x=x/2;
		}
		else if (x==13)
		{
			x=x/3;
		}
		else 
		{
			x=x/4;
		}
		return x;
	}
}
