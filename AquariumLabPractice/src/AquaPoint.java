// Aquarium Lab Series:  AquaPoint Class
//
// Copyright (C) 2002  Alyce Brady
//
// This class is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation.
//
// This class is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

import java.awt.Point;

/**
 *  Aquarium Lab Series:
 *  An <code>AquaPoint</code> object represents the x and y coordinates
 *  of a location in an aquarium.
 *
 *  @author Alyce Brady
 *  @version 10 July 2002
 **/

public class AquaPoint extends Point
{

  // constructor

    /** Constructs an <code>AquaPoint</code> object.
     *  @param xCoord    point's x coordinate
     *  @param yCoord    point's y coordinate
     **/
    public AquaPoint(int xCoord, int yCoord)
    {
        x = xCoord;
        y = yCoord;
    }

  // accessor methods

    /** Returns the x coordinate of this point.
     *  @return        x coordinate of this point
     **/
    public int xCoord()
    {
        return x;
    }

    /** Returns the y coordinate of this point.
     *  @return        y coordinate of this point
     **/
    public int yCoord()
    {
        return y;
    }

    /** Moves this point <code>distance</code> units to the right.
     *  @param  distance   distance to move right
     **/
    public void moveRight(int distance)
    {
        translate(distance, 0);
    }

    /** Moves this point <code>distance</code> units to the left.
     *  @param  distance   distance to move left
     **/
    public void moveLeft(int distance)
    {
        translate(-distance, 0);
    }

    /** Moves this point <code>distance</code> units up.
     *  @param  distance   distance to move up
     **/
    public void rise(int distance)
    {
        translate(0, -distance);   // y coordinates get smaller going up
    }

    /** Moves this point <code>distance</code> units down.
     *  @param  distance   distance to move down
     **/
    public void sink(int distance)
    {
        translate(0, distance);   // y coordinates get bigger going down
    }

    /** Represents this point as a string.
     *  @return        a string indicating the x and y coordinates of the
     *                 point in (x, y) format
     **/
    public String toString()
    {
        return "(" + xCoord() + ", " + yCoord() + ")";
    }

}
