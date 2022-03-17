package src;

import java.util.Scanner;

/*
    Assignment 2
    Program: Main.java
    Class: Input
    Object file used to control input/out messages from the User to the Program.
    Objects can be made as a generic or with paramemters passed to it.
    Object can modify values, return values, and check the input of said values;
*/
public class Input
{
    private long n;
    private long k;
    private static int objectCounter = 0;

    // scanner left open to continue input from keyboard.
    // please close scanner at program termination or when no more keyboard input is needed.
    private static Scanner sc = new Scanner(System.in);

    // Constructor: Input()
    // Generates an Input object with blank values;
    public Input()
    {
        this.n = 0;
        this.k = 0;
        objectCounter++;
    }

    // Constructor: Input(long n, long k)
    // Generates an Input object with parameters set to values;
    public Input(long n, long k)
    {
        this.n = n;
        this.k = k;
        objectCounter++;
    }

    // Method: passK
    // returns N for the object
    public long passN()
    {
        return this.n;
    }
    
    // Method: passK
    // returns K for the object
    public long passK()
    {
        return this.k;
    }
    
    // Method: setN
    // sets N for the object
    public void setN(long n)
    {
        this.n = n;
    }
    
    // Method: setK
    // sets K for the object
    public void setK(long k)
    {
        this.k = k;
    }
    
    // Method: amountOfObjects
    // returns the Object count
    public int amountOfObjects()
    {
        return objectCounter;
    }
    
    /*
        Method: start()
        calls printIntro method.
        Collects input from the user
        Checks for valid input
        Calls InputCheck
    */
    public void start()
    {
        printIntro();
        
        // Read in N value.
        while (true)
        {
            System.out.println("\nPlease enter the first value N in the range [" + nMin() + ", " + nMax() + "]");

            while (!sc.hasNextLong())
            {
                System.out.println("ERROR: Please enter in ONLY whole numbers");
                System.out.println("Retry entry of your first value N:");
                sc.next();
                continue;
            }
            this.n = sc.nextLong();

            if (!validateN(n))
            {
                System.out.println("ERROR: Value of n should've been in the range [" + nMin() + ", " + nMax() + "]");
                System.out.println("Value of N was input as: " + n);
                System.out.println("Retrying...");
                continue;
            }

            // Input was successful.
            break;
        }

        // Read in K value.
        while (true)
        {
            System.out.println("\nPlease enter the second value K in the range [" + kMin() + ", " + kMax(this.n) + "]");

            while (!sc.hasNextLong())
            {
                System.out.println("ERROR: Please enter in ONLY whole numbers");
                System.out.println("Retry entry of your second value K:");
                sc.next();
                continue;
            }
            this.k = sc.nextLong();

            if(!validateK(n, k))
            {
                System.out.println("ERROR: Value of K should've been in the range [" + kMin() + ", " + kMax(this.n) + "]");
                System.out.println("Value of K was input as: " + k);
                System.out.println("Retrying...");
                continue;
            }

            // Input was successful.
            break;
        }
    }

    // Method: shouldTerminate
    // Method prints message that the user should press the 'Enter' key to end the program
    // When the user does, the scanner closes, and the program exits.
    public void shouldTerminate()
    {
        System.out.println("\nPress Enter to end the program:");
        
        try
        {
            System.in.read();
        }
        catch(Exception e) {}
        
        sc.close();
        System.exit(0);
    }
    
    // Method: nMin
    // returns the minimum n value allowed. (is a function to maintain interface uniformity with kMax)
    private long nMin()
    {
        return 3;
    }

    // Method: nMax
    // returns the maximum n value allowed. (is a function to maintain interface uniformity with kMax)
    private long nMax()
    {
        return 11;
    }

    // Method: kMin
    // returns the minimum k value allowed. (is a function to maintain interface uniformity with kMax)
    private long kMin()
    {
        return 10;
    }

    // Method: kMax
    // returns the maximum k value allowed.
    private long kMax(long n)
    {
        // Takes the nth Root of (MAX_VALUE / 2) and returns it floored as a long. 
        return (long)PowMath.nthRoot(n, PowMath.MAX_DOUBLEINT / 2.0);
    }

    // Method: validateN
    // checks the range of the input to the preset values.
    private boolean validateN(long n)
    {
        return (nMin() <= n) && (n <= nMax());
    }

    // Method: validateK
    // checks the range of the input based on n value.
    private boolean validateK(long n, long k)
    {
        return (kMin() <= k) && (k <= kMax(n));
    }

    // Method: printIntro
    // Prints the into message of the program.
    private void printIntro()
    {
        System.out.println("The 'Last Theorem' Calculator");
        System.out.println("You will be prompted to enter two integers, n and k, one at a time.");
        System.out.println("The Program will iterate over all (x, y) pairs in the range [" + kMin() + ", k]");
        System.out.println("looking for 'Near Misses' to Fermat's Last Theorem of the form (x, y, z, n).");
    }
}