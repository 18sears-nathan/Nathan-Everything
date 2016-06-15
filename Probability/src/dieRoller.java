public class dieRoller 
{

/**

 * Rolls a 'numSides' sided die

 * @param numSides # of sides for the die

 * @return the result of the roll

 */

	public static int dieRoll(int numSides)
	{
		return (int)(Math.random()*numSides+1);
	}

	public static void main(String[] args)
	{
		int numRolls = 1000;
		int numSides = 6;
		int [] rolls = new int[numRolls];
		int [] counts = new int[numSides+1];
		int dice = 2;

 // Make and record the rolls

		for(int i=0; i<numRolls; i++)
		{
			rolls[i] = dieRoll(numSides);
		}

 // Initialize counts to all zeros

		for(int i=0; i<counts.length; i++)
		{
			counts[i]=0;
		}

 // Count the rolls of each value

		for(int i=0; i<numRolls; i++)
		{
			counts[rolls[i]] += 1;
		}
		

 // Display the counts

		for(int i=1; i<counts.length; i++)
		{
			System.out.print(i + ": " + counts[i]);
			double percent = 100*(double)(counts[i])/numRolls;
			System.out.println(" = " + percent + "%");
		}


	}
}
