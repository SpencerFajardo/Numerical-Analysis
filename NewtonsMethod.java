// Spencer Fajardo
// September 12, 2018
// This is a method that uses Newton's Method
// for solving the equation f(x) = 0 using an initial point p0

// This class is written using f(x) = x^3 - 2x - 5

public class NewtonsMethod
{
    public static double newtonsMethod(double p0, double TOL, int maxItr)
    {
        int itr = 1;
        while(itr < maxItr)
        {
            double numerator = Math.pow(p0,3) - (2 * p0) - 5;
            double denominator = (3 * Math.pow(p0,2)) - 2;
            double p = p0 - (numerator/denominator);

            if(Math.abs(p - p0) < TOL)
            {
                return p0;
            }

            itr++;
            p0 = p;
        }

        throw new IllegalArgumentException("Solution less than TOL not found using " + maxItr + " iterations");
    }

    public static void main(String[] args)
    {
        double testP = 1.5;
        double TOL = .000000000001;
        int testItr = 100;

        System.out.println("The solution found for the equation f(x) = 0 is: " + newtonsMethod(testP,TOL,testItr));
    }
}
