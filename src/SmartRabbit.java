
import java.util.Random;
import java.awt.Color;

public class SmartRabbit extends Rabbit 
{
	private boolean isFemale;
	private static Random generator = new Random();
	private static double fertility = .02;
	private int maxX;
	private int maxY;
	private static double visualRange = 30.0;
	
	public SmartRabbit(Cage cage)
	{
		super(cage);
		if(generator.nextInt(2)==0)
			isFemale = true;
		else
			isFemale = false;
		maxX = myCage.getMax_X();
		maxY = myCage.getMax_Y();
	}
	
	public SmartRabbit(Cage cage, Color col)
	{
		super(cage, col);
		if(generator.nextInt(2)==0)
			isFemale = true;
		else
			isFemale = false;
		maxX = myCage.getMax_X();
		maxY = myCage.getMax_Y();
	}
	
	public SmartRabbit(Cage cage, Color col, Position pos)
	{
		super(cage, col, pos);
		if(generator.nextInt(2)==0)
			isFemale = true;
		else
			isFemale = false;
		maxX = myCage.getMax_X();
		maxY = myCage.getMax_Y();
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
		Animal closestPredator = findClosestPredator();
	
		// In this case it sees a predator and tries to run away
		if(closestPredator instanceof Predator)
		{
			int predatorX = closestPredator.getPosition().getX();
			int predatorY = closestPredator.getPosition().getY();
			int myX = myPos.getX();
			int myY = myPos.getY();
			Position newPos, oldPos = new Position(myX, myY);
		
			if(predatorX > myX && myX > 0)
				myX--;
			else if (predatorX < myX && myX < maxX-1)
				myX++;
			if(predatorY > myY && myY > 0)
				myY--;
			else if(predatorY < myY && myY < maxY-1)
				myY++;
			newPos = new Position(myX, myY);
			
			// SmartGazelle could not move away, so it moves as a 
			// generic Prey, which means randomly
			if(newPos.equals(oldPos))
				super.act();
			// SmartGazelle moves to new position which is empty
			else if (myCage.isEmptyAt(newPos))
			{
				myPos = newPos;
				myCage.moveAnimal(oldPos, this);
			}
			// SmartGazelle could not move to a new location because
			// it was not empty, so it moves as a generic Prey (randomly)
			else
			{
				super.act();
			}
		}
		else
		{
			super.act();
		}
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
					SmartRabbit baby = new SmartRabbit(myCage, Color.BLUE, pos);
					myCage.addAnimal(baby);
					n++;
					possible[index] = null;
				}	
			}
		}
	}
	
	/**
	*	Method returns the closest Predator to the Gazelle provided that 
	*	Predator is also within the Gazelle's visual range, if no Predators
	*	are seen the method returns a generic Animal.
	*	@return	closest Predator the Gazelle can see
	*/
	public Animal findClosestPredator()
	{
		Animal closestPredator = new Animal(myCage);
		double distanceToClosest = visualRange+.01;
		// Distance set to just longer than a Gazelle can see
		
		for(int y=0; y<myCage.getMax_Y(); y++)
		{
			for(int x=0; x<myCage.getMax_X(); x++)
			{
				if(myCage.animalAt(x,y) instanceof Predator)
				{
					if(myPos.distanceTo(new Position(x,y)) < distanceToClosest)
					{
						closestPredator = myCage.animalAt(x,y);
						distanceToClosest = myPos.distanceTo(new Position(x,y));
					}
				}
			}
		}	
		return closestPredator;
	}
}
