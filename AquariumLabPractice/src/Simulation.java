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

/** Aquarium Lab Series:     
 *  A Simulation object controls a simulation of fish movement in
 *  an aquarium in the Aquarium Lab Series.
 *
 *  @author  Your name here
 *  @version 10 July 2002
 *  @see Aquarium
 *  @see AquaFish
 *  @see AquaSimGUI
 **/
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
    public Simulation(Aquarium aquarium, int numFish, AquaSimGUI gui)
    {
        // Initialize the instance variables.

        // Construct the fish.

        // View the initial configuration.
        // Draw the aquarium and fish, redisplay the user interface in the
        // window so that users can see what was drawn.
    }

    /** Run the Aquarium Simulation.
     *  @param numSteps    the number of simulation steps to run
     **/
    public void run(int numSteps)
    {
    }

    /** Run through a single step of the simulation. **/
    public void step()
    {
    }

    /** Get all the fish in the aquarium. **/
    public AquaFish[] getAllFish()
    {
		return allFish;
    }

}
