/**
 * @author Spencer Fajardo
 * September 17, 2018
 * This method finds an approximation to f(x) = 0,
 * given three initial approximations
 *
 * This algorithm can find complex roots!
 * Also, it converges very quickly.
 */

public class MuellersMethod
{
    /**
     *
     * @param x
     * @return    returns the evaluated function f(x)
     *
     *            currently set to evaluate x ^ 3 + 2x ^ 2 + 10x - 20
     */
    public static double evalFx(double x)
    {
        return Math.pow(x,3) + 2 * Math.pow(x,2) + (10 * x) - 20;

    }

    /**
     * This uses Muellers Method to determine an approximate value to f(x) = 0,
     * within a given tolerance, using three initial approximations.
     * If a value under the tolerance is not found in maxItr iterations, returns a failure.
     *
     * @param p0          the first initial approximation
     * @param p1          the second initial approximation
     * @param p2          the third initial approximation
     * @param TOL         allowed tolerance
     * @param maxItr      the max number of iterations to try
     * @return            returns the approximation to f(x) = 0
     */
    public static double muellersMethod(double p0, double p1, double p2, double TOL, int maxItr)
    {

        double h1 = p1 - p0;
        double h2 = p2 - p1;
        double e1 = (evalFx(p1) - evalFx(p0))/ h1;
        double e2 = (evalFx(p2) - evalFx(p1))/ h2;
        double d = (e2 - e1)/ (h1 + h1);
        int i = 3;

        while(i <= maxItr)
        {
            double b = e2 + h2 * d;
            double D = Math.pow((b*b - 4 * evalFx(p2) * d), .5);

            double E;
            if(Math.abs(b - D) < Math.abs(b + D))
            {
                E = b + D;

            }

            else
                {
                    E = b - D;
                }

                double h = -2 * evalFx(p2)/ E;
            double p = p2 + h;

            if(Math.abs(h) < TOL)
            {
                return p;
            }

            p0 = p1;
            p1 = p2;
            p2 = p;
            h1 = p1 - p0;
            h2 = p2 - p1;
            e1 = (evalFx(p1) - evalFx(p0))/ h1;
            e2 = (evalFx(p2) - evalFx(p1))/ h2;
            d = (e2 - e1)/ (h2 + h1);
            i++;

        }

        throw new IllegalArgumentException("Root cannot be found using " + maxItr + " iterations");
    }

    public static void main(String[] args)
    {
        double a = 0, b = 1, c = 2;
        double TOL = .00000000000001;
        int testItr = 7;
        System.out.println("The approximated root is: " + muellersMethod(a,b,c,TOL, testItr));
    }
}
