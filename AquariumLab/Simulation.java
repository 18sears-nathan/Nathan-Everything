/*
 *  Aquarium Lab Series
 *
 *  Class: Simulation
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

public class Simulation
{
    // Encapsulated data: aquarium in which fish swim, list of fish,
    // and user interface that can display the results.
    private Aquarium aqua;
    private AquaFish[] allFish;
    private AquaSimGUI userInterface;

    /** Construct a Simulation object for a particular environment.
     *  @param aquarium    the aquarium in which fish will swim
     *  @param numFish     the number of fish to put in the aquarium
     *  @param gui         graphical interface that displays the aquarium
     **/
    public Simulation(Aquarium aquarium, AquaSimGUI gui)
    {
        // Initialize the instance variables.
    	aqua = aquarium;
    	userInterface = gui;
        // Construct the fish.
    	int numFish = userInterface.getNumberOfFish();
    	allFish = new AquaFish[numFish];
    	
        userInterface.showAquarium();
    	
    	for (int i = 0; i < allFish.length; i++ ){
    		allFish[i] = new AquaFish(aqua);
        	userInterface.showFish(allFish[i]);    	
        }
    	
        // View the initial configuration.
        // Draw the aquarium and fish, redisplay the user interface in the
        // window so that users can see what was drawn.
    	userInterface.showAquarium();
        userInterface.show(allFish);
        userInterface.repaint();
        userInterface.pauseToView();
    }

    /** Run the Aquarium Simulation.
     *  @param numSteps    the number of simulation steps to run
     **/
    public void run(int numSteps)
    
    {
    	 // Now wait for the user to press the start button.
        //userInterface.waitForStart();

        // View the initial configuration.
        // Draw the aquarium; redisplay the user interface in the
        // window so that users can see what was drawn.
        // userInterface.showAquarium();
        

    //	for (int i = 0; i < allFish.length; i++ ){
    //    	userInterface.showFish(allFish[i]);
   // 	}
   //     userInterface.repaint();
   //     userInterface.pauseToView();
    //	 int steps = userInterface.getNumberOfSteps();
    	//int steps = userInterface.getNumberOfSteps(); 
    	 for(int i = 0; i < numSteps; i++){
    		 step();
    	 }
        	
        //userInterface.showAquarium();
        //userInterface.show(allFish);

        }	
       

    /** Run through a single step of the simulation. **/
    public void step()
    {	
    	for (int i = 0; i < allFish.length; i++){
    		allFish[i].move();
    	}
    	
    	userInterface.showAquarium();
        userInterface.show(allFish);
        userInterface.repaint();
        userInterface.pauseToView();
    }

    /** Get all the fish in the aquarium. **/
    public AquaFish[] getAllFish()
    {
		return allFish;
    }

}
