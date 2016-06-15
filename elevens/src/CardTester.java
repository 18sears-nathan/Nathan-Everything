/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card one = new Card("two", "sapdes", 10);
		Card two = new Card("four", "hearts", 11);
		
		System.out.print(one.suit());
		System.out.print(two.rank());
		System.out.print(one.matches(two));
	}
}
