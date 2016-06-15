/*
 *  Aquarium Lab Series
 *
 *  Class: AquaFish
 *
 *  Author: Alyce Brady
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
 *      The AquaFish class defines a fish in an aquarium. 
 *
 *  @author  Alyce Brady
 *  @version 10 July 2002
 *  @see Aquarium
 *  @see AquaPoint
 **/
public class AquaFish
{
    // Named constants that specify how far a fish may move in one timestep
    private static final int MIN_DISTANCE = 10;
    private static final int MAX_DISTANCE = 70;
    
    // Class Variables: Shared among ALL fish
    private static int nextAvailableID = 1;   // next avail unique identifier
    private static Random generator = new Random(); // random number generator

    // Instance Variables: Encapsulated data for EACH fish
    private Aquarium theAquarium;    // aquarium in which this fish is swimming
    private int myID;                // unique identifier for this fish
    private Color myColor;           // fish's color
    private AquaPoint myPos;         // fish's position in the Aquarium
    private Direction myDir;         // fish's direction
    private int myLength, myHeight;  // define size of fish
    private int halfLength, halfHeight;  // useful for knowing perimeter of
                                         //   fish (myPos is center position)


    /**
     *  The AquaFish constructor sets properties of the AquaFish.
     *  Precondition: the aquarium must be big enough to accommodate
     *  the biggest fish (currently 75 pixels long and 30 pixels high)
     *  plus 10 pixels of padding in all four directions.
     *  @param    aqua   the Aquarium in which to place the fish
     **/
    public AquaFish(Aquarium aqua)
    {
        // Place fish in aquarium and initialize ID and color.
        this (aqua, Color.white);
        
        /* NOTE: for randomly colored fish, use the statement below
           instead of the statement above.
        this (aqua, new Color (generator.nextInt(256),        // amount of red
                               generator.nextInt(256),        // amount of green
                               generator.nextInt(256)));      // amount of blue
         */
    }

    /**
     *  The AquaFish constructor sets properties of the AquaFish.
     *  This version of the constructor allows the user to select the
     *  Color to be associated with the fish.
     *  Precondition: the aquarium must be big enough to accomodate
     *  the biggest fish (currently 75 pixels long and 30 pixels high)
     *  plus 10 pixels of padding in all four directions.
     *  @param    aqua   the Aquarium in which to place the fish
     *  @param    color  the Color to associate with the fish
     **/
    public AquaFish(Aquarium aqua, Color color)
    {
        // Place fish in aquarium and initialize ID and color.
        theAquarium = aqua;
        myID = nextAvailableID++;
        myColor = color;

        // Initialize size, position, and direction).
        initSize();
        initPos();
    }

    /**
     *  Get the unique identifier for this fish.
     *  @returns    the ID of the fish
     **/
    public int id()
    {
        return myID;
    }

    /** Get fish's color.
     *  @return        the color of this fish
     **/
    public Color color()
    {
        return myColor;
    }

    /**
     *  Get the fish's position in the aquarium.
     *  @returns    the position (point in the aquarium) of the fish
     **/
    public AquaPoint position()
    {
        return myPos;
    }

    /** Get the length of the fish.
     *  @returns    fish length
     **/
    public int length()
    {
        return myLength;
    }

    /** Get the height of the fish.
     *  @returns    fish height
     **/
    public int height()
    {
        return myHeight;
    }

    /**
     *  Determine whether the fish is facing right.
     *  @returns    <code>true</code> if fish is facing right;
     *              <code>false</code> otherwise
     **/
    public boolean facingRight()
    {
        return myDir.equals(Direction.EAST);
    }

    /**
     *  Determine whether the fish is facing left.
     *  @returns    <code>true</code> if fish is facing left;
     *              <code>false</code> otherwise
     **/
    public boolean facingLeft()
    {
        return ! facingRight();
    }

    /**
     *  Compute how far the fish is from the wall in front of it.
     *  @returns    distance from front of fish to facing wall
     **/
    public int distanceToWall()
    {
        int leftEdgeOfFish = myPos.xCoord() - (halfLength + 1);
        int rightEdgeOfFish = myPos.xCoord() + (halfLength + 1);
        if ( facingRight() )
            return (theAquarium.width() - rightEdgeOfFish);
        else
            return leftEdgeOfFish;    // since left edge of aquarium is 0
    }

    /**
     *  Determine whether the fish is at a wall.
     *  A fish is considered at a wall if it cannot move forward; in other
     *  words, if the distance from the fish to the wall it faces is less
     *  than the minimum distance that a fish can move forward.
     *  @returns    <code>true</code> if fish is at a wall;
     *              <code>false</code> otherwise
     **/
    public boolean atWall()
    {
        return (distanceToWall() <= MIN_DISTANCE);
    }

    /**
     *  Determine whether the fish is at the surface.
     *  A fish is considered at the surface if it cannot ascend; in other
     *  words, if the distance from the fish to the surface is less
     *  than the fish's height.
     *  @returns    <code>true</code> if fish is at the surface;
     *              <code>false</code> otherwise
     **/
    public boolean atSurface()
    {
        int topOfFish = myPos.yCoord() - (halfHeight + 1);
        return (topOfFish <= myHeight);
    }

    /**
     *  Determine whether the fish is at the bottom.
     *  A fish is considered at the bottom if it cannot descend; in other
     *  words, if the distance from the fish to the bottom is less
     *  than the fish's height.
     *  @returns    <code>true</code> if fish is at the bottom;
     *              <code>false</code> otherwise
     **/
    public boolean atBottom()
    {
        int bottomOfFish = myPos.yCoord() + (halfHeight + 1);
        return (bottomOfFish >= (theAquarium.height() - myHeight));
    }

    /**
     *  This function is provided primarily for debugging purposes.
     *  @returns    a string representation of a fish
     **/
    public String toString()
    {
        String s = new String();
        String dir = "R";
        if ( facingLeft() )
            dir = "L";
        s = s + myID + myPos + dir + " ";
        return s;
    }

    /**
     *  Move forward horizontally by random increments, staying
     *  within the aquarium.
     **/
    public void moveForward()
    {
        // First get random number in range [0, MAX_DISTANCE-MIN_DISTANCE],
        // then shift to [MIN_DISTANCE, MAX_DISTANCE].  If moving that
        // far would mean swimming out of the aquarium, only move to edge
        // of aquarium.  Ajust fish's x coordinate by a positive or 
        // negative amount, depending on whether fish is facing right or left.
        int moveAmt = generator.nextInt(MAX_DISTANCE - MIN_DISTANCE + 1);
        moveAmt += MIN_DISTANCE;
        if ( moveAmt >= distanceToWall() )
            moveAmt = distanceToWall();
        if ( facingRight() )
            myPos.moveRight(moveAmt);
        else
            myPos.moveLeft(moveAmt);
    }

    /**
     *  Reverse direction.
     **/
    public void changeDir()
    {
        myDir = myDir.reverse();
    }

    /**
     *  Initialize fish size:
     *  This helper function determines the height and length of the fish.
     *  Fish are evenly distributed among 4 different sizes based on their 
     *  ID numbers.
     **/
    private void initSize()
    {
        myLength = 30 + (myID % 4) * 15;
        myHeight = (int)Math.round(0.4*myLength);
        halfLength = (int)Math.round(myLength/2.0);
        halfHeight = (int)Math.round(myHeight/2.0);
    }

    /**
     *  Initialize fish position and direction.
     *  This helper function assigns coordinates to a fish such that the
     *  fish is placed within the bounds of the Aquarium.
     *  Precondition: the aquarium must be big enough to accomodate
     *  the biggest fish (currently 75 pixels long and 30 pixels high)
     *  plus 10 pixels of padding in all four directions.
     **/
    private void initPos()
    {
        // Find random position within the bounds of the aquarium.
        int padding = 20;
        int myX = generator.nextInt(theAquarium.width() - myLength
                   - padding) + padding/2;
        int myY = generator.nextInt(theAquarium.height() - myHeight
                   - padding) + padding/2;

        // Since myX and myY indicate CENTER of fish, shift over half 
        // the length and half the width.
        myX += halfLength;
        myY += halfHeight;

        // Initialize my position and direction.
        myPos = new AquaPoint(myX, myY);
        myDir = Direction.EAST;
    }
}

