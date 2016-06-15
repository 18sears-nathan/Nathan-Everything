// ------ DRAFT !!!   6/1/2002  ------ //
// AP Computer Science Marine Biology Simulation:  RandNumGenerator Class
//
// Copyright (C) 2002  College Board and Educational Testing Service
//
// This class is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation.
//
// This class is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

import java.util.Random;

/**
 *  Marine Biology Simulation:
 *  The <code>RandNumGenerator</code> class provides a singleton
 *  <code>java.util.Random</code> object for random number generation.  Using
 *  this class, many different objects can share a single source of random
 *  numbers.  This eliminates the potential problem of having multiple random
 *  number generators generating sequences of numbers that are too similar.
 *
 *  <p>
 *  Example of how to use <code>RandNumGenerator</code>:  
 *    <pre><code>
 *       import java.util.Random;
 *
 *       Random randNumGen = RandNumGenerator.getInstance();
 *       int randomNum = randNumGen.nextInt();
 *       double randomDouble = randNumGen.nextDouble();
 *    </code></pre>
 *
 *  @author Alyce Brady
 *  @version 1 June 2002
 *  @see java.util.Random
 **/
public class RandNumGenerator
{
    // Class Variable: Only one generator is created by this class.
    private static Random theRandNumGenerator = new Random();

    /** Returns a random number generator.
     *  Always returns the same <code>Random</code> object to provide
     *  a better sequence of random numbers.
     **/
    public static Random getInstance()
    {
        return theRandNumGenerator;
    }
}
