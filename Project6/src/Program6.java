/*************************************************************************** Class:  <Program or class name nere>Author:  <YOUR NAME HERE>  Date:  <date here><Description of program or class here>Date		Modification****************************************************************************/public class Program6 {	public static void main(String args[]) 	{			EasyReader console = new EasyReader();				boolean repeat = true;		while (repeat){				System.out.print("\nTriangle Lable (ex: ABC)   =");		String lable = console.readLine();						System.out.print("\nSide 1                     =");		int s1 = console.readInt();				System.out.print("\nSide 2                     =");		int s2 = console.readInt();				System.out.print("\nSide 3                     =");		int s3 = console.readInt();				if (((s1 + s2) >= (s3)) ||((s1 + s2) >= (s3)) ||((s2 +s3) >= (s1)))		 {		 System.out.println("\nThat is not a valid triangle please re-enter");		 repeat = true;		 }						else if (s1==s2&&s2==s3 ){		System.out.println("\nTriangle "+ lable +" is equilateral");}				else if (s1==s2||s1==s3||s2==s3){		System.out.println("\nTriangle "+ lable +" is isosceles");}				else {		System.out.println("\nTriangle "+ lable +" is scalene");}					 }		 	//	System.out.print("\nWould you like to enter another triangle? (Y or N)");	//				  }		char temp = console.readChar();				repeat = console.equalsIgnoreCase("Y");		}	}	