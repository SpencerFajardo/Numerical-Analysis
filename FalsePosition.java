// Spencer Fajardo
// September 12, 2018
// The method of False Position uses the secant method, but also
// makes sure that the root if always bracketed between
// successive iterations

// This method is not recommended, but is an example of how bracketing can be used

// This method is written with f(x) = x^3 - 2x - 5

public class FalsePosition
{
    public static double falsePosition(double p0, double p1, double TOL, double maxItr)
    {
        int itr = 2;
        double q0 = Math.pow(p0,3) - (2 * p0) - 5;
        double q1 = Math.pow(p1,3) - (2 * p1) - 5;

        while(itr < maxItr) {
            double numerator = p1 - p0;
            double denominator = q1 - q0;
            double p = p1 - (q1 * (numerator / denominator));

            if (Math.abs(p - p1) < TOL) {
                return p;
            }

            itr++;

            double q = Math.pow(p,3) - (2 * p) - 5;

            if( q * q1 < 0)
            {
                p0 = p1;
                q0 = q1;

            }

            p1 = p;
            q1 = q;
        }

        throw new IllegalArgumentException("A solution for f(x) = 0 was not found under TOL using " + maxItr + " iterations");
    }

    public static void main(String[] args)
    {
        double testP0 = 1.5;
        double testP1 = 1;
        double TOL = .0000001;
        int testItr = 30;
        System.out.println("The solution found for the equation f(x) = 0 is: " + falsePosition(testP0,testP1,TOL,testItr));
    }
}
