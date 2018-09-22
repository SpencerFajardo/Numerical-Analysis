/**
 * @author Spencer Fajardo
 * September 17, 2018
 * We apply Aitken's delta^2 method to a linearly convergent sequence
 * obtained from fixed point iteration to accelerate its convergence
 * to quadratic.
 *
 *
 * This method is written with f(x) = 3^-p
 */

public class SteffensensMethod
{
    public static double steffensenMethod(double p0, double TOL, int maxItr)
    {
        int itr = 1;
        while(itr <= maxItr)
        {

            double p1 = Math.pow(3,-p0);
            double p2 = Math.pow(3,-p1);
            double p = p0 - (Math.pow((p1-p0),2) / (p2 - 2 * p1 + p0));

            if(Math.abs(p-p0) < TOL)
            {
                return p;
            }

            itr++;
            p0 = p;
        }

        throw new IllegalArgumentException("Value not found under the tolerance using " + maxItr + " iterations.");
    }

    public static void main(String[] args)
    {
        double testp = 2;
        double TOL = .00000000000001;
        int testItr = 5;
        System.out.println("The solution found for f(x) is: " + steffensenMethod(testp, TOL, testItr));
    }
}
