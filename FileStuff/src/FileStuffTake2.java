import java.util.ArrayList;


public class FileStuffTake2 
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
		
		int count = 0;
		
		for (int k = 0; k < message.size(); k++)
		{
			String a = cleanUpWord(message.get(k));
			System.out.print(a+":");
			
			for (int l = 0; l < message.size(); l++)
			{
				String b = cleanUpWord(message.get(l));
				if(a.compareToIgnoreCase(b)==0)
				{
					count++;
				}
			}
			System.out.println(count);
			count =0;
		}
	}
	
	public static String cleanUpWord(String word)
	 {
	 if(word==null)
	  return null;
	 String cleaned = new String();
	  for(int i=0; i<word.length(); i++)
	 {
	 if(isLetterOrNumber(word.charAt(i))==true)
	 cleaned += word.charAt(i);
	 if(word.charAt(i)==47)
	 cleaned+=word.charAt(i);
	 }
	 return cleaned;
	 }

	 public static boolean isLetterOrNumber(char ch)
	 {
	 int n = (int)ch;
	 if(n < 48)
	 return false;
	 else if(n>57 && n<65)
	 return false;
	 else if(n>90 && n<97)
	 return false;
	 else if(n>122)
	 return false;
	 else
	 return true;
	 }
}
