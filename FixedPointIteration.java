// Spencer Fajardo
// September 10, 2018
// Fixed point iteration algorithm
// currently implemented for f(p) = 3^-p

public class FixedPointIteration
{
    public static double fixedPointIteration(double po, double TOL, int maxItr)
    {
        int i = 1;
        while(i < maxItr)
        {

            double p = Math.pow(3,-po);
            if(Math.abs(p-po) < TOL)
            {
                return p;
            }

            i++;
            po = p;
        }

        throw new IllegalArgumentException("Solution under TOL not found with " + maxItr + " iterations");
    }

    public static void main(String[] args)
    {
        double testPo = 1;
        double testTol = .0001;
        int testItr = 100;

        System.out.println("The fixed point for p^-3 is: " + fixedPointIteration(testPo, testTol, testItr));
    }
}
