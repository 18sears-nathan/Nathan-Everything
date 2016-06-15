import java.awt.Color;


public class AgingLion extends Lion {
	
	public AgingLion(Cage myCage, Color green)
	{
		super(myCage, green);
	}

	public String toString()
	{
		return (myPos.toString() + " is an Aging Lion.  ");
	}
	
	int myAge = 0;
	
	public boolean act()
	{
		boolean didIact = false;
		myAge++;
		
		if (myAge == 25)
		{
			myColor = Color.red;    
		}
		else if(myAge == 50)
		{
			myColor = Color.green;
		}
		else if(myAge == 75)
		{
			myColor = Color.blue;
		}
		else if(myAge == 100)
		{
			myColor = Color.black;
		}
		super.act();
		
		return didIact;
	}
}
