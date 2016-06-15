/*
 *  Aquarium Lab Series
 *
 *  Class: Aquarium
 *
 *  Author: Alyce Brady
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

/** Aquarium Lab Series:     
 *  The Aquarium class defines an Aquarium and its properties.
 *
 *  @author  Alyce Brady
 *  @version 10 July 2002
 **/
public class Aquarium
{
    private int myWidth;
    private int myHeight;
    private Color myColor;

    /**
        Construct an Aquarium with user-specified size.
        @param    width    width of the aquarium when displayed (in pixels)
        @param    height   height of the aquarium when displayed (in pixels)
    */
    public Aquarium(int width, int height)
    {
        if (width > 0)
            myWidth = width;
        else
            myWidth = 640;
        if(height > 0)
            myHeight = height;
        else
            myHeight = 480;
        myColor = new Color(0.0f, .6f, 1.0f);
    }

    /**
        Determine the width of the aquarium.
        @returns    the width of the aquarium
    */
    public int width()
    {
        return myWidth;
    }

    /**
        Determine the height of the aquarium.
        @returns    the height of the aquarium
    */
    public int height()
    {
        return myHeight;
    }

    /**
        Determine the color of the aquarium (water color).
        @returns    the Color of the aquarium
    */
    public Color color()
    {
        return myColor;
    }

    /**
        This function determines whether the given coordinates specify
            a valid location (one that exists within the bounds of the
            aquarium).
        @params     an x and y coordinate to be checked
        @returns    true if the specified location is within the bounds
                    of the aquarium
    */
    public boolean validLoc(int xCoord, int yCoord)
    {
        if ((0 <= xCoord && xCoord < myWidth) && 
                (0 <= yCoord && yCoord < myHeight))
            return true;
        return false;
    }
}    //end Aquarium class
