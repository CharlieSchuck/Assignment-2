package src;

/*
    This is the Main Class that runs the program.
    
    - It first reads in two values, n and k.
    - Then, it iterates over all x, y pairs in the range [10, k].
    - For each pair, it calculates up to 2 z values, and creates a FermatMiss object with arguments (x, y, z, n).
    - All the while, it keeps track of the Minimum FermatMiss, and for each new one it finds, it outputs it to the console.
    - At the end, it awaits user-input before terminating.
*/
public class Main
{
    public static void main(String[] args)
    {
        //Starts the program execution
        programFlow();
    }

    public static void programFlow()
    {
        //Makes the Input object to hold the program inputs
        Input theValues = new Input();
        
        //Starts the program, and collects input.
        theValues.start();

        findMiss(theValues);

        // Terminates the program.
        theValues.shouldTerminate();
    }

    public static void findMiss(Input theValues){
        // keep track of the minimum FermatMiss
        FermatMiss minimum = null;

        long n = theValues.passN();

        // iterate over all x,y pairs [10, k]
        for (long x = 10; x <= theValues.passK(); ++x)
        {
            for (long y = 10; y <= theValues.passK(); ++y)
            {
                double root = PowMath.nthRoot(n, PowMath.longPow(x, n) + PowMath.longPow(y, n));
                long zCeil = (long)Math.ceil(root);
                long zFloor = (long)Math.floor(root);
                
                FermatMiss missCeil = new FermatMiss(x, y, zCeil, n);
                FermatMiss missFloor = new FermatMiss(x, y, zFloor, n);

                // The next miss to be compared against the minimum miss.
                FermatMiss newMiss;
                
                // If zCeil won't cause overflow / rounding errors, choose the min of missFloor & missCeil.
                if (zCeil <= PowMath.nthRoot(n, PowMath.MAX_DOUBLEINT))
                {
                    newMiss = (missFloor.compareTo(missCeil) <= 0) ? missFloor : missCeil;
                }
                // If zCeil would cause overflow / rounding errors, choose missFloor.
                else
                {
                    newMiss = missFloor;
                }

                // If there is no Minimum yet, or if the newMiss is smaller, the newMiss becomes the new Minimum.
                if ((minimum == null) || (newMiss.compareTo(minimum) < 0))
                {
                    minimum = newMiss;                        
                    System.out.println("\nNew minimum miss:\n" + minimum);
                }
            }
        }
    }
}

