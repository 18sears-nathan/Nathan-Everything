import java.util.ArrayList;

public class ArrayLists {
	
	public static void main(String Args[])
	{
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Lucas");
		names.add("Simon");
		names.add("John");
		names.add("Tommy");
		names.add("Sana");
		names.add("Delaney");
		names.add("Ellie");
		names.add("Janelle");
		
		System.out.println(names);
		
		names.add("Megan");
		
		System.out.println(names);
		
		names.remove(3);

		System.out.println(names);
		
		names.add("Leah");

		System.out.println(names);
		
		names.add(3, "Ryan");
		
		System.out.println(names);
		
		names.set(2, "Kathrine");
		
		System.out.println(names);
		
		int fir = 0;
		int las = names.size()-1;
		while(las>fir)
		{
			String temp = names[fir];
			names[fir] = names[las];
			names[las] = temp;
			las--;
			fir++;
			
		}
	}
}
