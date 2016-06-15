import java.awt.Color;


public class Dingo extends Animal implements Predator, Prey{

	public Dingo(Cage cage)
	{
		super(cage, Color.orange);
	}
	
	public Dingo(Cage cage, Color col)
	{
		super(cage, col);
	}
	
	public Dingo(Cage cage, Color col, Position pos)
	{
		super(cage, col, pos);

	}
	
	/**
	*	Method causes the Animal to act.  This may include 
	*	any number of behaviors (moving, eating, etc.).
	*/
	public void act()
	{
		int xPrey, yPrey, myX, myY;
		
		Animal closestPrey = findClosestPrey();
		Animal closestPredator = findClosestPredator();
		if(isSomethingICanEat(closestPrey)==true)
		{
			xPrey = closestPrey.getPosition().getX();
			yPrey = closestPrey.getPosition().getY();
			myX = myPos.getX();
			myY = myPos.getY();
			Position newPos, oldPos = new Position(myX, myY);
			
			// Compare x and y coordinates and move toward
			// the Prey (by adding or subtracting one to each)
			if(xPrey>myX)
				myX++;
			else if (xPrey<myX)
				myX--;
			if(yPrey>myY)
				myY++;
			else if (yPrey<myY)
				myY--;
			
			newPos = new Position(myX, myY);
			
			// check to see if Lion just caught Prey
			if(newPos.equals(closestPrey.getPosition()))
			{
				closestPrey.kill();
				myCage.removeAnimal(closestPrey);
				myPos = newPos;
				myCage.moveAnimal(oldPos, this);
			}
			// check to see if newPos is empty
			else if (myCage.isEmptyAt(newPos))
			{
				myPos = newPos;
				myCage.moveAnimal(oldPos, this);
			}		
		}	
		else if(canItEatMe(closestPredator) == true)
		{
			int predatorX = closestPredator.getPosition().getX();
			int predatorY = closestPredator.getPosition().getY();
			myX = myPos.getX();
			myY = myPos.getY();
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
			
			
		else // no Prey was seen, move as generic Animal
		{
			super.act();
		}	
		
		
		
	}
	
	double visualRange = 45;
	
	public Animal findClosestPrey()
	{
		
		Animal closestPrey = new Animal(myCage);
		double distanceToClosest = visualRange+.01;
		// Distance set to just longer than a Lion can see
		
		for(int y=0; y<myCage.getMax_Y(); y++)
		{
			for(int x=0; x<myCage.getMax_X(); x++)
			{
				if(isSomethingICanEat(myCage.animalAt(x,y)) == true)
				{
					if(myPos.distanceTo(new Position(x,y)) < distanceToClosest)
					{
						closestPrey = myCage.animalAt(x,y);
						distanceToClosest = myPos.distanceTo(new Position(x,y));
					}
				}
			}
		}
		
		return closestPrey;
	}
	
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
	
	public boolean isSomethingICanEat(Animal obj)
	{
		if(obj instanceof Prey)
			return true;
		return false;
	}
	
}
