import java.util.LinkedList;
import java.util.ArrayList;

public class ListTester 
{
	public static void main(String[] args)
	{
		// Creates an empty LinkedList
		LinkedList<Student> list = new LinkedList<Student>();
		
		// Creates Students, adds them to list
		Student temp = new Student("Jones", "Lucas", 3.50);
		list.add(temp);
		temp = new Student("White", "Kelly", 4.00);
		list.add(temp);
		temp = new Student("Thomas", "Kaneshia", 3.75);
		list.add(temp);
		temp = new Student("Grant", "Diego", 3.67);
		list.add(temp);
		temp = new Student("Rivers", "Jennifer", 3.25);
		list.add(temp);
		temp = new Student("Beltre", "Janine", 3.88);
		list.add(temp);
		temp = new Student("White", "Marissa", 3.91);
		list.add(temp);
		
		
		// Task 1: Put code here that will display each student in the list, 
		// one line at a time.
		
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i)+"\n");
		System.out.print("\n");
		// Task 2: Put code here that will sort the list by last name, 
		// then first name. After the list is sorted display each student 
		// in the list, one line at a time. (Note: You will need to use
		// the compareTo() method in the String class. See the Java API
		// for details.)
		
		for (int j = 0; j < list.size(); j++)
		{
			for (int k = j+1; k < list.size(); k++)
			{
				if (list.get(k).last().compareToIgnoreCase(list.get(j).last()) < 0)
						{
						temp = list.get(k);
						list.set(k, list.get(j));
						list.set(j, temp);
						}
				else if (list.get(j).last().compareToIgnoreCase(list.get(k).last()) == 0 && list.get(j).first().compareToIgnoreCase(list.get(k).first()) < 0)
				{
					temp = list.get(k);
					list.set(k, list.get(j));
					list.set(j, temp);
				}
			}
		}
		/*
		int fir = 0;
		int las = list.size()-1;
		while(las>fir)
		{
			Student temporary = list.get(fir);
			list.set(fir , list.get(las));
			list.set(las , temporary);
			las--;
			fir++;
			
		}
		*/
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i)+"\n");
		System.out.print("\n");
		
		// Task 3: Put code here that will sort the list by grade point, 
		// average. After the list is sorted display each student in the
		// list, one line at a time.
		
		
		for (int j = 0; j < list.size(); j++)
		{
			for (int k = j+1; k < list.size(); k++)
			{
				if (list.get(j).getGPA()>list.get(k).getGPA())
						{
						temp = list.get(k);
						list.set(k, list.get(j));
						list.set(j, temp);
						}
			}
		}
	
			for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i)+"\n");
			
			System.out.print("\n");
			
		// Task 4: Create two new students, and add each of the them to the 
		// list using a loop that inserts them in grade point average 
		// order. Then display each student in the list, one line at a time.
		
		boolean isSorted = false;
		boolean isSorted2 = false;
		
		
		
		temp = new Student("Bons", "Lucas", 4.20);
		Student temp2 = new Student("Alford", "Thomas", 4.69);
		
		do
		{
			int i = 0;
			if (temp.getGPA()>list.get(i).getGPA())
			{
				list.add(i, temp);
				i++;
				isSorted = false;
				break;
			}
			int j = 0;
			if (temp2.getGPA()>list.get(j).getGPA())
			{
				list.add(j, temp);
				j++;
				isSorted = false;
				break;
			}
		}while(isSorted != false && isSorted2 != false);
		
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i)+"\n");
			
			System.out.print("\n");
	}	
}