package src.debug;

// Tests the Maximum K and Nth Root formulas. (Private use only)
public class kTest
{
    public static void main(String[] args)
    {
        long[] possibleExponents = { 
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            11
        };

        long[] expectedMaxValues = {
            1664510,
            46340,
            5404,
            1290,
            463,
            215,
            118,
            73,
            49
        };

        System.out.println("Exponent : Expected - Calculated");
        for (int i = 0; i < possibleExponents.length; ++i)
        {
            System.out.println(possibleExponents[i] + ": " + expectedMaxValues[i] + " - " + maxK(possibleExponents[i]));
        }
    }

    private static long maxK(long n)
    {
        return (long)(nthRoot(n, Long.MAX_VALUE / 2.0));
    }

    private static double nthRoot(double root, double num)
    {
        return Math.pow(num, 1.0 / root);
    }
}
