import java.util.ArrayList;


public class FileStuff 
{	
	public static void main(String[] args)
	{
		EasyReader console = new EasyReader();
		
		EasyReader infile = new EasyReader("sampletext.txt");
		ArrayList<String> message = new ArrayList<String>();
		
		while(!infile.eof())
		{
			message.add(infile.readWord());
		}
		message.remove(message.size()-1);  // removes end of file character
		
		ArrayList<String> unique = new ArrayList<String>();
		
		System.out.println(message);
		
		for(int j=0; j<message.size(); j++)
		{
			boolean isUnique = true;
			String temp = message.get(j);
			
			for(int i=0; i<unique.size(); i++)
			{
				if(unique.get(i).compareToIgnoreCase(temp)==0)
				{
					isUnique = false;
				}
			}
			if(isUnique)
			{
				unique.add(temp);
			}
			
		}
		System.out.println(unique.size());
	}
}
