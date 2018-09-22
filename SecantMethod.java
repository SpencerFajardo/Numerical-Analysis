// Spencer Fajardo
// September 12, 2018
// This is a modification of Newton's Method. Since Newton's Method requires the
// derivative f'(x) to be computed for f(x), we can use the limit definition
// of the derivative to remove the need for the derivative to be computed,
// resulting in the Secant Method

// This method was written using f(x) = x^3 - 2x - 5

public class SecantMethod
{
    public static double secantMethod(double p0, double p1, double TOL, double maxItr)
    {
        int itr = 2;
        double q0 = Math.pow(p0,3) - (2 * p0) - 5;
        double q1 = Math.pow(p1,3) - (2 * p1) - 5;

        while(itr < maxItr)
        {
            double numerator = p1 - p0;
            double denominator = q1 - q0;
            double p = p1 - (q1 * (numerator / denominator));

            if(Math.abs(p - p1) < TOL)
            {
                return p;
            }

            itr++;

            p0 = p1;
            q0 = q1;
            p1 = p;
            q1 = Math.pow(p,3) - (2 * p) - 5;

        }

        throw new IllegalArgumentException("A solution for f(x) = 0 was not found under TOL using " + maxItr + " iterations");
    }

    public static void main(String[] args)
    {
        double testP0 = 1.5;
        double testP1 = 1;
        double TOL = .0000001;
        int testItr = 30;
        System.out.println("The solution found for the equation f(x) = 0 is: " + secantMethod(testP0,testP1,TOL,testItr));
    }
}
