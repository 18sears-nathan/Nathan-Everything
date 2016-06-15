import java.awt.Color;


public class FastGazelle extends SmartGazelle {
	
	public FastGazelle(Cage myCage, Color red)
	{
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		return (myPos.toString() + " is a Smart Gazelle.  ");
	}
	
	public boolean act()
	{
		boolean didIAct = false;
		super.act();
		super.act();
		return didIAct;
	}
}
