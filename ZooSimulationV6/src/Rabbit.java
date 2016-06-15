import java.util.Random;
import java.awt.Color;

public class Rabbit extends Animal implements Prey 
{
	private boolean isFemale;
	private static Random generator = new Random();
	private static double fertility = .02;
	
	public Rabbit(Cage cage)
	{
		super(cage, Color.green);
		if(generator.nextInt(2)==0)
			isFemale = true;
		else
			isFemale = false;
	}
	
	public Rabbit(Cage cage, Color col)
	{
		super(cage, col);
		if(generator.nextInt(2)==0)
			isFemale = true;
		else
			isFemale = false;
	}
	
	public Rabbit(Cage cage, Color col, Position pos)
	{
		super(cage, col, pos);
		if(generator.nextInt(2)==0)
			isFemale = true;
		else
			isFemale = false;
	}
	
	/**
	*	Method causes the Animal to act.  This may include 
	*	any number of behaviors (moving, eating, etc.).
	*/
	public void act()
	{
		double check = generator.nextDouble();
		if(isFemale && check < fertility)
			haveChildren();
		super.act();
	}
	
	/**
	*	Method returns true if obj is a type that can eat 
	*	this Animal, returns false otherwise
	*	@param	obj	object to be evaluated
	*	@return true if obj can eat this Animal, false otherwise
	*/
	public boolean canItEatMe(Animal obj)
	{
		if(obj instanceof Predator)
			return true;
		return false;
	}
	
	public void haveChildren()
	{
		//System.out.print("Kids");
		Position[] possible = myCage.emptyNeighbors(myPos);
		if(possible.length > 0)
		{
			int numKids = generator.nextInt(possible.length);
			//System.out.println(" - " + numKids);
			for(int n=0; n<numKids; )
			{
				int index = generator.nextInt(possible.length);
				Position pos = possible[index];
				if(pos != null)
				{
					Rabbit baby = new Rabbit(myCage, Color.ORANGE, pos);
					myCage.addAnimal(baby);
					n++;
					possible[index] = null;
				}	
			}
		}
	}
}
