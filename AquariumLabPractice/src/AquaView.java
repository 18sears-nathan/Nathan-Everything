/*
 *  Aquarium Lab Series
 *
 *  Class: AquaView
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

import edu.neu.ccs.gui.BufferedPanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/** Aquarium Lab Series:
 *  An AquaView object provides a graphical view of AquaFish
 *  in an Aquarium.
 *
 *  @author  Alyce Brady
 *  @version 10 July 2002
 *  @see Aquarium
 *  @see AquaFish
 **/
public class AquaView
{
    // Encapsulated data
    private BufferedPanel displayPanel;   // where to display
    private Aquarium theAquarium;         // the aquarium to display

    /** Construct an AquaView object to display a particular
     *  aquarium.  
     *      @param panel  the graphical panel in which to display environment
     *      @param a      the aquarium to display
     **/
    public AquaView(BufferedPanel panel, Aquarium a)
    {
        displayPanel = panel;
        theAquarium = a;

        displayPanel.setBackground(theAquarium.color());

    }


    /**
     *  Show the AquaFish in the Aquarium.
     *  Paints the aquarium blue to cover up old fish and displays
     *  the fish in the array.
     *  @param    fishList   the array of AquaFish to be displayed
     **/
    public void show(AquaFish[] fishList)
    {
        // Redraw the environment to paint over previous positions of fish.
        displayPanel.fillPanel(theAquarium.color());

        // Get graphics context in which everything is displayed.
        Graphics2D drawingSurface = displayPanel.getBufferGraphics();
        drawingSurface.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw all of the fish.
        for (int i = 0; i < fishList.length; i++)
        {
            if ( fishList[i] != null )
                drawFish (drawingSurface, fishList[i]);
        }
    }


    /**
     *  Show the AquaFish in the Aquarium.
     *  Paints the aquarium blue to cover up old fish and displays
     *  the fish in the array.
     *  @param    fishList   the list of AquaFish to be displayed
     **/
    public void show(ArrayList fishList)
    {
        // Redraw the environment to paint over previous positions of fish.
        displayPanel.fillPanel(theAquarium.color());

        // Get graphics context in which everything is displayed.
        Graphics2D drawingSurface = displayPanel.getBufferGraphics();
        drawingSurface.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw all of the fish.
        for (int i = 0; i < fishList.size(); i++)
        {
            AquaFish fish = (AquaFish)fishList.get(i);
            if ( fish != null )
                drawFish (drawingSurface, fish);
        }
    }


    /**
     *  Display only the Aquarium: paint the aquarium blue to cover
     *  up old fish.  Not necessary when displaying an entire vector
     *  of fish.  
     **/
    public void showAquarium()
    {
        // Redraw the environment to paint over previous positions of fish.
        displayPanel.fillPanel(theAquarium.color());
    }


    /**
     *  Display a single AquaFish.
     *  @param    fish the fish to be displayed
     **/
    public void showFish(AquaFish fish)
    {        
        // Get graphics context in which everything is displayed.
        Graphics2D drawingSurface = displayPanel.getBufferGraphics();
        drawingSurface.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the fish.
        drawFish (drawingSurface, fish);
    }        


    /**
     *  Helper function that displays a single AquaFish, given
     *  a graphics context.
     *  @param    drawingSurface   context in which to display fish
     *  @param    fish             the fish to be displayed
     **/
    private void drawFish(Graphics2D drawingSurface, AquaFish fish)
    {        
        // Get color of fish.
        drawingSurface.setPaint(fish.color());

        // Get fish size and location from the fish itself.  Find its
        // outline based on the fish size and location.
        double fishLength = fish.length();
        double fishHeight = fish.height();
        double leftEndOfFish = fish.position().xCoord() - fishLength / 2.0;
        double topOfFish = fish.position().yCoord() - fishHeight / 2.0;
        double rightEndOfFish = leftEndOfFish + fishLength;
        double bottomOfFish = topOfFish + fishHeight;
        double verticalCenter = fish.position().yCoord();
        // Fish body parts are drawn to scale.
        double bodyLength = 0.8 * fishLength;
        double leftEndOfBody;        // value depends on fish's direction

        double eyeSize = 0.1 * fishLength;
        double topOfEye = verticalCenter - (0.1 * fishLength)
                          - eyeSize / 2;
        double leftEndOfEye;        // value depends on fish's direction

        double tailLength = 0.25 * fishLength;
        double tailHeightOffset = 0.12 * fishLength;
        double topOfTail = verticalCenter - tailHeightOffset;
        double bottomOfTail = verticalCenter + tailHeightOffset;
        double endOfTail;        // value depends on fish's direction
        double tailMeetsBody;    // value depends on fish's direction

        if (fish.facingRight())    //draw the fish facing right
        {
            leftEndOfBody = rightEndOfFish - bodyLength;
            leftEndOfEye = rightEndOfFish - 0.26 * fishLength;
            endOfTail = leftEndOfFish;
            tailMeetsBody = endOfTail + tailLength;
        }
        else
        {
            leftEndOfBody = leftEndOfFish;
            leftEndOfEye = leftEndOfFish + (0.26 * fishLength)
                              - eyeSize;
            endOfTail = rightEndOfFish;
            tailMeetsBody = endOfTail - tailLength;
        }

        // Draw the body of the fish as an oval.
        Ellipse2D.Double body
             = new Ellipse2D.Double(leftEndOfBody, topOfFish,
                 bodyLength, fishHeight);
        drawingSurface.fill(body);

        // Draw the tail as a triangle (filled path with three points).
        GeneralPath tailOutline = new GeneralPath();
        tailOutline.moveTo((float) endOfTail, (float) topOfTail);
        tailOutline.lineTo((float) endOfTail, (float) bottomOfTail);
        tailOutline.lineTo((float) tailMeetsBody, (float) verticalCenter);
        tailOutline.closePath();
        drawingSurface.fill(tailOutline);

        // Draw the eye as a small circle.
        drawingSurface.setPaint(Color.black);
        Ellipse2D.Double eye
             = new Ellipse2D.Double(leftEndOfEye, topOfEye,
                 eyeSize, eyeSize);
        drawingSurface.fill(eye);
     }

}
