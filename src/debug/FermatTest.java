package src.debug;

// Tests the FermatMiss class. (Private use only)
public class FermatTest
{
    public static void main(String[] args)
    {
        FermatMiss miss1 = new FermatMiss(10, 15, 20, 4);
        FermatMiss miss2 = new FermatMiss(10, 15, 12, 4);
        
        System.out.println("Miss 1:");
        System.out.println(miss1 + "\n");
        
        System.out.println("Miss2 1:");
        System.out.println(miss2 + "\n");

        System.out.println("Miss1 <=> Miss2 = " + miss1.compareTo(miss2));
        System.out.println("Miss2 <=> Miss1 = " + miss2.compareTo(miss1));
        System.out.println("Miss1 <=> Miss1 = " + miss1.compareTo(miss1));
    }
}
