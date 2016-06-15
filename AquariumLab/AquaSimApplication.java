/*
 *  Aquarium Lab Series
 *
 *  Class: AquaSimApplication
 *
 *  Author: Your Name Here,
 *      based on a template provided by my instructor
 *
 *  Created: 
 *
 *  Modified:
 *      Your Name      Date    Reason
 *
 *  License:
 *      This program is free software; you can redistribute it
 *      and/or modify it under the terms of the GNU General Public
 *      License as published by the Free Software Foundation.
 *
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 */

import java.awt.Color;
import java.util.Random;

/** Aquarium Lab Series:     
 *
 *  @author  Nathan Sears
 *  @version 9/28/2015
 *  @see Aquarium
 *  @see AquaFish
 *  @see AquaSimGUI
 *  
 *  The AquaSimApp Class draws the Gui and paints the aquarium. The simulation class contains two methods that directly relate to the fish
 *  movement. The Step method will move all of the fish in any random direction and go by one frame at a time. The Run method will perform 
 *  the step method for the indicated amount of steps.
 **/
public class AquaSimApplication
{
    /**
     *  This is the main function.  It controls the execution of the program.
     *  @param    String args[] is never used
     **/

    public static void main(String args[])
    {
        System.out.println("This will be an aquarium simulation.");
        System.out.println("Press the Start button to start the simulation.");

        // CONSTRUCT OBJECTS NEEDED FOR THE AQUARIUM SIMULATION.        
       
        Aquarium aqua; 
        aqua = new Aquarium(600, 480);
        
        // Construct a graphical user interface (GUI) to display and control
        // the simulation.  The user interface needs to know about the
        // aquarium, so we pass aqua to the user interface constructor.
        AquaSimGUI userInterface;              // create reference to GUI ...
        
        userInterface = new AquaSimGUI(aqua,true,true,true);  // ... and then GUI itself
      
        
        //AquaFish[] fishList = new AquaFish[numFish];
      
        //Simulation aquaSim = new Simulation (aqua, userInterface);
      
     // for (int i = 0; i < numFish; i ++){
  //  	  fishList[i] = new AquaFish(aqua);   	  
    //  }
      
        
       
        //for (int i = 0; i < steps; i++)
         
  
        
        // RUN THE AQUARIUM SIMULATION.
        // WRAP UP.

        // Remind user how to quit application.
        System.out.println ("Close GUI display window to quit.");

    }//end main

}//end class
