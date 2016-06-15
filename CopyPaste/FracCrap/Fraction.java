/**
 * This is a class for printing out fractions as well as dividing and simplifying them.
 * @author Sears Nathan
 * version 1.0
 */
public class Fraction 
{
	//Instance Variables
	/**
	 * sets aside space in memory for the value of numerator and denominator
	 */
	private int numerator;
	private int denominator;
	
	//Constructors
	/**
	 * Assigns values to the numerator and the denominator
	 * @param num
	 * @param den
	 */
	public Fraction(int num, int den){
		numerator= num;
		denominator = den;
	}
	//accessor methods
	public int getNum(){
		return numerator;
	}
	public int getDen(){
		return denominator;
	}
	//Main Method
	/**
	 * Demonstrates every method contained in this class

	public static void main(String[]args){
		Fraction a = new Fraction(3,4);
		System.out.println(a.getNum());
		System.out.println(a.getDen());
		System.out.println(a.toString());
		Fraction b = new Fraction(1,8);
		Fraction c = a.divide(b);
		Fraction d = a.multiply(b);
		Fraction e = a.add(b);
		Fraction f = a.subtract(b);
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println(e.toString());
		System.out.println(f.toString());
		Fraction g = new Fraction(20,32);
		System.out.println(g.simplify());
		System.out.println(g.decimalValue());
	}
	*/
	//Other Methods
	/**
	 * Combines the numerator and denominator into a string
	 */
	public String toString(){
		return (numerator+"/"+denominator);
	}
	/**
	 * This method divides the numerator by the denominator to result in its decimal form.
	 * @return Decimal
	 */
	public double decimalValue()
	{
		double num1 = this.numerator;
		double den1 = this.denominator;
		double temp = num1/den1;
		return(temp);
	}
	/**
	 * This method takes fraction a and divides it by fraction b
	 * resulting in fraction c.
	 * @param this The fraction to return as a decimal
	 * @return Decimal value of the fraction  
	 */
	public Fraction divide(Fraction other)
	{
		int num1 = this.numerator;
		int den1 = this.denominator;
		int num2 = other.numerator;
		int den2 = other.denominator;
		int numQuotient = num1 *den2;
		int denQuotient = den1 *num2;
		return (new Fraction(numQuotient,denQuotient));
	}
	/**
	 * This method adds two fractions by multiplying the first num by second den and the 
	 * second num by the first den and adding the values together and multiplying both 
	 * denominators together
	 * @param other the fraction to divide this fraction by
	 * @return Quotient of this by other
	 */
	public Fraction add(Fraction other)
	{
		int num1 = this.numerator;
		int den1 = this.denominator;
		int num2 = other.numerator;
		int den2 = other.denominator;
	
		Fraction c = new Fraction((num1*den2)+(num2*den1),(den1*den2));
		
		return c;
	}
	/**
	 * This method subtracts two fractions by multiplying the first num by second den and 
	 * multiplying the second num by the first den, subtracting the second value from the first
	 * and multiplying both denominators together
	 * @param other the Fraction to subtract from this Fraction
	 * @return The difference of this and other
	 */
	public Fraction subtract(Fraction other)
	{
		int num1 = this.numerator;
		int den1 = this.denominator;
		int num2 = other.numerator;
		int den2 = other.denominator;
	
		Fraction c = new Fraction((num1*den2)-(num2*den1),(den1*den2));
		
		return c;
	}
	/**
	 * This Method multiplies two fractions together by multiplying both numerators and 
	 * both denominators.
	 * @param other the fraction that multiplies with this
	 * @return Product of this and other
	 */
	public Fraction multiply(Fraction other)
	{
		int num1 = this.numerator;
		int den1 = this.denominator;
		int num2 = other.numerator;
		int den2 = other.denominator;
		int numProd = num1 *num2;
		int denProd = den1 *den2;
		return (new Fraction(numProd,denProd));
	}
	/**
	 * Method that simplifies a fraction by finding the GCF of the numerator and denominator
	 * and then dividing them by that value
	 * @return the simplified fraction
	 */
	public Fraction simplify()
	{
		int n = Utility.gcf(numerator, denominator);
		Fraction simplified = new Fraction((numerator/n),(denominator/n));
		return simplified;
	}
}
