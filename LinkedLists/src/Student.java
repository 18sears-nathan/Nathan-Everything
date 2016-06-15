
public class Student 
{
	private String lastName;
	private String firstName;
	private double gpa;
	
	/**
	 * Constructor creates a Student
	 * @param lname Student's last name
	 * @param fname Student's first name
	 * @param grades Student's gpa
	 */
	public Student(String lname, String fname, double grades)
	{
		lastName = lname;
		firstName = fname;
		gpa = grades;
	}
	
	/**
	 * Returns String form of student
	 * @return last, first <tab> gpa
	 */
	public String toString()
	{
		String str = lastName + ", " + firstName + "\t" + gpa;
		return str; 
	}
	
	/**
	 * Returns Student's last name
	 * @return last name
	 */
	public String last()
	{
		return lastName;
	}

	/**
	 * Returns Student's first name
	 * @return first name
	 */
	public String first()
	{
		return firstName;
	}
	
	/**
	 * Returns Student's grade point average
	 * @return grade point average
	 */
	public double getGPA()
	{
		return gpa;
	}
	
}