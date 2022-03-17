package src;

/*
    Class for handling Exponential Math, including a Pow() method for longs and an nthRoot() method.
*/
class PowMath
{
    // According to the Wikipedia page on Doubles, All Positive integers up to 2^53 can be exactly represented as Doubles.
    public static final double MAX_DOUBLEINT = Math.pow(2, 53);

    // Pow method for longs to eliminate possible rounding errors of using doubles to represent large longs using Math.pow().
    public static long longPow(long a, long b)
    {
        if (b < 0) return 0;
        
        long product = 1;
        for (long i = 0; i < b; ++i)
        {
            product *= a;
        }

        return product;
    }

    // Convenience method for explicitly taking the nth root of numbers.
    public static double nthRoot(double n, double num)
    {
        return Math.pow(num, 1.0 / n);
    }
}