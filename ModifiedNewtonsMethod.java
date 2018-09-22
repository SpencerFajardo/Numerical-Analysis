// Spencer Fajardo
// September 12, 2018
// Newton's Method, but modified for faster convergence

// This method is written with f(x) = x^3 - 2x - 5

// Note that the Modified Newton's Method finds a solution within an error of
// .000000000001 using just one iteration

public class ModifiedNewtonsMethod
{
    public static double modifiedNewtonsMethod(double p0, double TOL, int maxItr)
    {
        int itr = 1;
        while(itr < maxItr)
        {
            double numerator = (Math.pow(p0,3) - (2 * p0) - 5) * ((3 * Math.pow(p0,2)) - 2);
            double denominator = (Math.pow((3 * Math.pow(p0,2)) - 2,2)) - ( (Math.pow(p0,3) - (2 * p0) - 5) * ((6 * p0)));
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
        int testItr = 1;

        System.out.println("The solution found for the equation f(x) = 0 is: " + modifiedNewtonsMethod(testP,TOL,testItr));
    }
}
