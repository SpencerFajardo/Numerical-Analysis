// Spencer Fajardo
// September 8, 2018
// Method for determining unique root in
// an interval [a,b] of a polynomial

// Here we used the polynomial x^3 + 4x^2 - 10

public class BisectionMethod
{
    public static double Bisection(double a, double b, double TOL, int maxItr)
    {
        int i = 1;
        double FA = (Math.pow(a, 3)) + (4 * Math.pow(a,2)) - 10;

        while( i < maxItr)
        {
            double p = a + (b-a)/2;
            double FP = (Math.pow(p, 3)) + (4 * Math.pow(p,2)) - 10;

            if((FP == 0) || (((b-a)/2) < TOL))
            {
                return p;
            }

            i++;

            if(FA*FP > 0 )
            {
                a = p;
                FA = FP;
            }

            else
                {
                    b = p;
                }
        }

        throw new IllegalArgumentException("Failed to find the root after " + maxItr + " iterations");

    }

    public static void main(String[] args)
    {
        double a = 1;
        double b = 2;
        int itr = 50;
        double TOL = .00000000000000001;

        System.out.println(Bisection(a,b,TOL,itr));


    }
}
