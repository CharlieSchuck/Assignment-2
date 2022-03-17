package src;

/*
    Fermat's Last Theorem:
    There are no natural numbers (x, y, z) such that x^n + y^n = z^n, where n is a natural number greater than 2.

    This class can be instantiated to create objects with parameters (x, y, z, n) that calculate "near misses" to Fermat's Last Theorem.

    It is expected (although not required) that:
    *  X >= 10
    *  Y >= 10
    *  N is in range (2, 12)
*/
public class FermatMiss implements Comparable<FermatMiss>
{
    // Parameters
    public final long x; 
    public final long y;
    public final long z;
    public final long n;

    // Constructor
    public FermatMiss(long x, long y, long z, long n)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.n = n;
    }

    // Returns "x^n + y^n"
    public long getLeft()
    {
        return PowMath.longPow(x, n) + PowMath.longPow(y, n);
    }
    
    // Returns "z^n"
    public long getRight()
    {
        return PowMath.longPow(z, n);
    }

    // Returns "|x^n + y^n - z^n|"
    public long getActualMiss()
    {
        return Math.abs(getLeft() - getRight());
    }

    // Returns "|(x^n + y^n - z^n) / (x^n + y^n)|"
    public double getRelativeMiss()
    {
        return Math.abs((double)getActualMiss() / (double)getLeft());
    }

    // Compares two FermatMiss objects by their Relative Miss values.
    @Override
    public int compareTo(FermatMiss that)
    {
        return (int)(Math.signum(this.getRelativeMiss() - that.getRelativeMiss()));
    }

    // Returns a String representing the FermatMiss object.
    @Override
    public String toString()
    {
        if (x != y)
        {
            // Since addition is Commutative, display two "identical" FermatMisses with X & Y swapped.
            return "(" + "x=" + x + ", " + "y=" + y + ", " + "z=" + z + ", " + "n=" + n + ")"
                + " / " + "(" + "x=" + y + ", " + "y=" + x + ", " + "z=" + z + ", " + "n=" + n + ")"
                + "\n- x^n + y^n = " + getLeft()
                + "\n- z^n = " + getRight()
                + "\n- Actual Miss = " + getActualMiss()
                + "\n- Relative Miss = " + getRelativeMiss()
            ;
        }
        else
        {
            // X & Y are the same, so no need to show both versions.
            return "(" + "x=" + x + ", " + "y=" + y + ", " + "z=" + z + ", " + "n=" + n + ")"
                + "\n- x^n + y^n = " + getLeft()
                + "\n- z^n = " + getRight()
                + "\n- Actual Miss = " + getActualMiss()
                + "\n- Relative Miss = " + getRelativeMiss()
            ;
        }
    }
}
