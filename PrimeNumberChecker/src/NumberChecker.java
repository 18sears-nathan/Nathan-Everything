import java.awt.*;
import BreezyGUI.*;

/* Class: 	NumberChecker
 * Author:	Nathan Sears
 * Date 9/24/15
 * Opens a window to prompt the user for a number and then writes in the textarea, after pressing the "is Prime?" button,
 * if the number they have entered is prime or not.
 * 
 * 9/23 Began coding and fished isPrime method
 * 9/24 Inserted the method into the GUI template
 */



public class NumberChecker extends GBFrame 
{
	// Instance Variables (the window components)
	private Label inputFieldLabel;
	private IntegerField inputField;
	private Button isPrimeButton;
	private TextArea outputArea;
	
	public NumberChecker()
	{
		inputFieldLabel = addLabel("Number to Check",1,1,1,1);
		inputField = addIntegerField(0,1,2,1,1);
		isPrimeButton = addButton("Is Prime?",2,1,1,1);
		outputArea = addTextArea("",3,1,3,3);
	}
	
	public void buttonClicked(Button buttonObj)
	{
		if(buttonObj == isPrimeButton)
		{
			int number = inputField.getNumber();
			
			if (isPrime(number)){
				outputArea.append(number+" is prime.\n");
			}
			
			else
				outputArea.append(number+" is not prime.\n");
		}
	}
	
	public boolean isPrime(int num)
	{

		if (num<2)
			return false;
		else if (num==2)
			return true;
		else if (num%2==0)
			return false;
		
		for (int i = 3; i <= Math.sqrt(num);i = i+2){
			if (num%i == 0)
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args)
	{
		NumberChecker frm = new NumberChecker();
		frm.setSize(350,350);
		frm.setVisible(true);
		
	}
}
