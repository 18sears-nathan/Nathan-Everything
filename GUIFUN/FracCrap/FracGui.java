import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;

import BreezyGUI.DoubleField;
import BreezyGUI.GBFrame;


public class FracGui extends GBFrame 
{
	
	 
	   	private Label firstLabel; 
	   	private Label secondLabel;
	   	private Label answerLabel;
	   	
	  	private DoubleField num1Field; 
	   	private DoubleField den1Field; 
	   	private DoubleField num2Field; 
	   	private DoubleField den2Field;
	   //	private DoubleField answerField; 

	   	private Button additionButton;
	 	private Button subtractButton;
	 	private Button multiplyButton;
	 	private Button divideButton;
	 	private Button clearButton;
	 	private Button toDecimalButton;
	 	
	 	
	 	private TextArea outputArea;
	   
	   	public FracGui( )
	   	{
	   		firstLabel = addLabel("first number",1,1,1,1);
	   		secondLabel = addLabel("second number",2,1,1,1);
	   		answerLabel = addLabel("        answer",8,1,1,1);
	   		
	   		outputArea = addTextArea(" ",9,1,3,3);
	   		
	   		
	   		num1Field = addDoubleField(0,1,2,1,1);
	   		den1Field = addDoubleField(0,2,2,1,1);
	   		num2Field = addDoubleField(0,1,2,1,1);
	   		den2Field = addDoubleField(0,2,2,1,1);
	   		
	   		
	   		additionButton = addButton("+",4,1,1,1);
	   		subtractButton = addButton("-",4,2,1,1);
	   		multiplyButton = addButton("*",4,3,1,1);
	   		divideButton = addButton("/",5,1,1,1);
	   		clearButton = addButton("Clear",5,2,1,1);
	   		toDecimalButton = addButton("toDecimal",5,3,1,1);

	   	}

	   	public void buttonClicked (Button buttonObj)
	   	
	   	{
	      		// get the values in each of the fields
	      		int firstNumber = (int) num1Field.getNumber();
	      		int secondNumber = (int) den1Field.getNumber();
	      		int thirdNumber = (int) num2Field.getNumber();
	      		int fourthNumber = (int) den2Field.getNumber();
	      		double answer;
	      		double answer1;
	      		Fraction a = new Fraction(firstNumber,secondNumber);
	      		Fraction b = new Fraction(thirdNumber,fourthNumber);
	     		// now figure out which button was clicked
	      		if(buttonObj == clearButton)
	      		{
	      			num1Field.setNumber(0);
	      			den1Field.setNumber(0);
	      			num2Field.setNumber(0);
	      			den2Field.setNumber(0);
	      			outputArea.setText(" ");
	      		}
	      		else if (buttonObj == additionButton)
	      		{  
	      			Fraction c = a.add(b);
	      			c.simplify();
	      			outputArea.append(c+"\n");
	      		}
	      		else if (buttonObj == subtractButton)
	      		{
	      			Fraction c = a.subtract(b);
	      			c.simplify();
	      			outputArea.append(c+"\n");
	      		}
	      		else if (buttonObj == multiplyButton)
	      		{
	      			Fraction c = a.multiply(b);
	      			c.simplify();
	      			outputArea.append(c+"\n");
	      		}
	      		else if (buttonObj == divideButton)
	      		{	
	      			Fraction c = a.divide(b);
	      			c.simplify();
	      			outputArea.append(c+"\n");
	      			
	      		}
	      		else if (buttonObj == toDecimalButton)
	      		{
	      			a.decimalValue();
	      			outputArea.append(a+"\n");
	      		}

	    }
	    
	   	public static void main (String[] args)
	    
		{
			Frame frm = new FracGui();    
			
			frm.setSize (300, 300);  
			
			frm.setVisible (true);           
		}
	    
}
