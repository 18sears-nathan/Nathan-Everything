import java.awt.Color;

public class Rabbit extends Prey{

	boolean gender;
	public Rabbit(Cage myCage, Color grey)
	{
		super(myCage, grey);
		gender = randomGender();
		if (gender)
		{
			System.out.print("male");
		}
		else
			System.out.print("female");	
	}
	
	
	Animal animal;
	
	public boolean act()
	{
		boolean didIact = false;
		int chanceToSpawn = 0;// (int) (Math.random()*4);
		System.out.println(gender);
		if(gender)
		{
			if(chanceToSpawn == 0)
			{
				animal = new Rabbit(myCage, Color.gray);
				myCage.addAnimal(animal);
			}
		}
		super.act();
		return didIact;
	}
	
	public String toString()
	{
		return (myPos.toString() + " is a Rabbit.  ");
	}
}
