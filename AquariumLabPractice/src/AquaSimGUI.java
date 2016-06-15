/*
 *  Aquarium Lab Series
 *
 *  Class: AquaSimGUI
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

import edu.neu.ccs.gui.ActionsPanel;
import edu.neu.ccs.gui.BufferedPanel;
import edu.neu.ccs.gui.Display;
import edu.neu.ccs.gui.DisplayCollection;
import edu.neu.ccs.gui.DisplayPanel;
import edu.neu.ccs.gui.DisplayWrapper;
import edu.neu.ccs.gui.JPTFrame;
import edu.neu.ccs.gui.SimpleAction;
import edu.neu.ccs.gui.TextFieldView;
import edu.neu.ccs.util.JPTUtilities;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.Action;

/**
 *  Aquarium Lab Series:
 *  The AquaSimGUI class provides a graphical user interface
 *  to the Aquarium Lab Series.  This class uses the Java
 *  Power Tools (JPT) classes from Northeastern University to
 *  build the graphical interface.  In particular, it inherits
 *  the <code>repaint</code> method (which does not appear in
 *  the specification for this class) from the JPT DisplayPanel
 *  class.  The <code>repaint</code> method draws the
 *  components in the graphical user interface.
 *
 *  @author Alyce Brady
 *  @version 10 July 2002
 **/
public class AquaSimGUI extends DisplayPanel
{

    /////////////////////////////////////////////////////////
    // Static Data: Constants not tied to any one instance //
    /////////////////////////////////////////////////////////

    private static final int DEFAULT_FISH = 10;  // default # of fish
    private static final int DEFAULT_STEPS = 15; // # steps to run simulation
    private static final int VIEW_TIME = 1000;  // allow viewer to see display
    private static final int WAIT_TIME = 100;   // between Start button checks


    ////////////////////////
    // Instance Variables //
    ////////////////////////

    private Aquarium aqua = null;             // aquarium in which fish swim
    private AquaView drawingObject = null;    // to draw fish in aquarium
    private int numFish = DEFAULT_FISH;       // number of fish in aquarium
    private int numSteps = DEFAULT_STEPS;     // number of sim. steps to run
    private Simulation simulation = null;     // controls timesteps
    private boolean started = false;          // has simulation started yet?


    /////////////////////////////////////////////
    // GUI Instance Variables:                 //
    //    Graphical User Interface components  //
    //    for controlling simulation execution //
    /////////////////////////////////////////////

    // Text field to prompt for number of fish.
    private TextFieldView numFishTF =
        new TextFieldView(
            "" + DEFAULT_FISH,           // initial value displayed in the TFV
            "Number must be positive:",  // prompt for correcting input
            "Incorrect input");          // title for the error dialog box

    // Text field to prompt for number of simulation steps.
    private TextFieldView numStepsTF =
        new TextFieldView(
            "" + DEFAULT_STEPS,          // initial value displayed in the TFV
            "Number must be positive:",  // prompt for correcting input
            "Incorrect input");          // title for the error dialog box

    // Action button to start the simulation and action panel to put it in.
    private SimpleAction start =
        new SimpleAction("Start") {
           public void perform(){ start(); }
        };
    private Action[] startButtonList = {start};
    private ActionsPanel startPanel = new ActionsPanel(startButtonList);

    // Action buttons to execute one step of the simulation and to
    // run the simulation continuously, and action panel to put them in.
    private SimpleAction step =
        new SimpleAction("Single Step") {
           public void perform(){ step(); }
        };
    private SimpleAction run =
        new SimpleAction("Run") {
           public void perform(){ run(); }
        };
    private Action[] runButtonsList = {step, run};
    private ActionsPanel runButtonsPanel = new ActionsPanel(runButtonsList);


    //////////////////
    // Constructors //
    //////////////////

    /** Construct a simple graphical user interface for the Aquarium
     *  Simulation program.
     *      @param  aquarium    the aquarium in which the fish swim
     **/
    public AquaSimGUI(Aquarium aquarium)
    {
        this(aquarium, false, false, false);
    }

    /** Construct a simple graphical user interface for the Aquarium
     *  Simulation program, with or without prompts for the number of
     *  simulation steps.
     *      @param  aquarium    the aquarium in which the fish swim
     *      @param  promptForSimSteps   <code>true</code> if GUI should
     *                                  prompt for number of simulation steps
     **/
    public AquaSimGUI(Aquarium aquarium, boolean promptForSimSteps)
    {
        this(aquarium, promptForSimSteps, false, false);
    }

    /** Construct a graphical user interface for the Aquarium
     *  Simulation program, with or without prompts for the number of
     *  simulation steps and the number of fish.
     *      @param  aquarium    the aquarium in which the fish swim
     *      @param  promptForSimSteps   <code>true</code> if GUI should
     *                                  prompt for number of simulation steps
     *      @param  promptForNumFish    <code>true</code> if GUI should
     *                                  prompt for number of fish
     **/
    public AquaSimGUI(Aquarium aquarium,
                      boolean promptForSimSteps,
                      boolean promptForNumFish)
    {
        this(aquarium, promptForSimSteps, promptForNumFish, false);
    }

    /** Construct a graphical user interface for the Aquarium
     *  Simulation program, with or without prompts for the number of
     *  simulation steps and the number of fish.
     *      @param  aquarium    the aquarium in which the fish swim
     *      @param  promptForSimSteps   <code>true</code> if GUI should
     *                                  prompt for number of simulation steps
     *      @param  promptForNumFish    <code>true</code> if GUI should
     *                                  prompt for number of fish
     *      @param  useSimulationObj    <code>true</code> if GUI should
     *                                  construct and use a Simulation object
     **/
    public AquaSimGUI(Aquarium aquarium,
                      boolean promptForSimSteps,
                      boolean promptForNumFish,
                      boolean useSimulationObj)
    {
        // Save aquarium info. in an instance variable.
        aqua = aquarium;

        // Set layout for entire panel.
        setLayout(new BorderLayout());

        // Create two displays: one in which to view the aquarium
        // and one to contain the control panel.  Add them to the
        // main panel of the GUI.
        add(getViewWindow(), BorderLayout.EAST);
        add(getControlPanel(promptForSimSteps, promptForNumFish,
                            useSimulationObj), 
            BorderLayout.WEST);

        // Clear window.
        reset();
        
        // Put the GUI in a window, giving the window a title.
        JPTFrame.createQuickJPTFrame("Aquarium Lab Series", this);

        // Create the Simulation object (if appropriate) and tell the
        // control panel about it.
        if ( useSimulationObj )
        {
            int numFish = getNumberOfFish();
            simulation = new Simulation (aqua, numFish, this);

            // View the initial configuration.
            // Draw the aquarium and fish, redisplay the user interface in the
            // window so that users can see what was drawn.
            show(simulation.getAllFish());
            repaint();
            pauseToView();
        }
    }


    //////////////////////////////////////////////////////////
    // User Interaction Methods (Dealing with controlPanel) //
    //////////////////////////////////////////////////////////

    /**
     *  Wait for start button to be pushed.
     **/
    public void waitForStart()
    {
        while ( ! started )
            JPTUtilities.pauseThread(WAIT_TIME);
    }

    /**
     *  Get the number of fish to put in the aquarium from user input.
     **/
    public int getNumberOfFish()
    {
        waitForStart();
        return numFish;
    }

    /**
     *  Get the number of steps to run from user input.
     **/
    public int getNumberOfSteps()
    {
        waitForStart();
        return numSteps;
    }


    //////////////////////////////////////////////////
    // Drawing Methods (Delegated to drawingObject) //
    //////////////////////////////////////////////////

    /**
     *  Display all the AquaFish in the <code>fishList</code> array.
     *  Paints the aquarium blue to cover up old fish and displays
     *  the fish in the array.
     *  @param    fishList   the array of AquaFish to be displayed
     **/
    public void show(AquaFish[] fishList)
    {
        drawingObject.show(fishList);
    }

    /**
     *  Display all the AquaFish in the <code>fishList</code> list.
     *  Paints the aquarium blue to cover up old fish and displays
     *  the fish in the list.
     *  @param    fishList   the list of AquaFish to be displayed
     **/
    public void show(ArrayList fishList)
    {
        drawingObject.show(fishList);
    }

    /**
     *  Display only the Aquarium: paint the aquarium blue to cover
     *  up old fish.  Not necessary when displaying an entire vector
     *  of fish.  
     **/
    public void showAquarium()
    {
        drawingObject.showAquarium();
    }

    /**
     *  Display a single AquaFish.
     *  @param    fish the fish to be displayed
     **/
    public void showFish(AquaFish fish)
    {
        drawingObject.showFish(fish);
    } 

    /**
     *  Pause so user can view the display.
     **/
    public void pauseToView()
    {
        JPTUtilities.pauseThread(VIEW_TIME);
    } 


    ////////////////////////
    // Actions            //
    ////////////////////////

    /** Start the simulation.  (Activated by the start button.)
     **/
    public void start()
    {
        // Get the number of fish and the number of steps.
        numFish = numFishTF.demandInt();
        numSteps = numStepsTF.demandInt();

        // Record that simulation has started and modify what control
        // components are active.
        started = true;
        setEnabled(false);
        runButtonsPanel.setEnabled(true);
    }

    /** Execute one step of the simulation.  (Activated by the step button.)
     */
    public void step()
    {
        if ( simulation == null )
            return;

        // Execute a step of the simulation.
        simulation.step();
        
        // View the new configuration.
        show(simulation.getAllFish());
        repaint();
    }

    /** Start running the simulation.  (Activated by the run button.)
     **/
    public void run()
    {
        if ( simulation == null )
            return;

        Thread myThread = new Thread()
        {
            public void run ()
            {
                runButtonsPanel.setEnabled(false);

                // Move the fish numSteps times.
                for ( int step = 0; step < numSteps; step++ )
                {
                    step();
                    pauseToView();
                }

                runButtonsPanel.setEnabled(true);
            }
        };

        myThread.start();
    }


    //////////////////////////////
    // Private Helper Methods   //
    //////////////////////////////

    /**
     *  Construct and initialize display in which to view aquarium.
     **/
    private Display getViewWindow()
    {
        // Create the panel in which to view the aquarium
        // and disable it (view panel is not interactive).
        // then put it in a display with a title.
        BufferedPanel aquaViewPanel =
            new BufferedPanel(aqua.width(), aqua.height());
        aquaViewPanel.setEnabled(false);

        // Construct an object that knows how to draw the
        // aquarium in the viewing panel (used by other parts
        // of the Aquarium Simulation program as well).
        drawingObject = new AquaView(aquaViewPanel, aqua);

        // Put the view panel in a titled display and return.
        return new Display(aquaViewPanel, null, "Aquarium");
    }

    /**
     *  Construct and initialize display that contains control panel.
     *      @param  promptForSimSteps   <code>true</code> if GUI should
     *                                  prompt for number of simulation steps
     *      @param  promptForNumFish    <code>true</code> if GUI should
     *                                  prompt for number of fish
     *      @param  useSimulationObj    <code>true</code> if GUI should
     *                                  construct and use a Simulation object
     **/
    private Display getControlPanel(boolean promptForSimSteps,
                       boolean promptForNumFish, boolean useSimulationObj)
    {
        DisplayCollection controlPanel = new DisplayCollection();

        // Disable the control panel to start off.
        controlPanel.setEnabled(false);

        // Set up text field views in which to prompt for number
        // of fish and number of simulation steps.
        numFishTF.setPreferredWidth(50);
        numFishTF.getInputProperties().setSuggestion("" + DEFAULT_FISH);
        numStepsTF.setPreferredWidth(50);
        numStepsTF.getInputProperties().setSuggestion("" + DEFAULT_STEPS);

        // Add text field views if appropriate.
        if ( promptForNumFish )
        {
            numFishTF.setEnabled(true);
            controlPanel.add(new DisplayWrapper(
                    new Display(numFishTF, "Number of Fish:", null) ) );
        }
        if ( promptForSimSteps )
        {
            numStepsTF.setEnabled(true);
            controlPanel.add(new DisplayWrapper(
                    new Display(numStepsTF, "Number of Simulation Steps:", 
                                null) ) );
        }

        // Always include start button.
        startPanel.setEnabled(true);
        controlPanel.add(getStartPanel());

        // Add step and run buttons if appropriate.
        if ( useSimulationObj )
        {
            runButtonsPanel.setEnabled(false);
            controlPanel.add(new Display(runButtonsPanel, null, "Run Simulation"));
        }

        // Put the control panel in an untitled display and return.
        return new Display(controlPanel, null, null);
    }

    /** Construct action panel for start button (in a separate thread).
     **/
    private Display getStartPanel()
    {
        // Create the Start action panel in a separate thread.
        Thread myThread = new Thread()
        {
            public void run ()
            {
                startPanel = new ActionsPanel(startButtonList);
            }
        };

        // Start parallel thread for start button.
        myThread.start();
        waitForStartPanel();
        return new Display(startPanel, null, null);
    }

    /**
     *  Wait for Start button action panel to be created.
     **/
    private void waitForStartPanel()
    {
        while ( startPanel == null )
            JPTUtilities.pauseThread(WAIT_TIME);
    }

}
