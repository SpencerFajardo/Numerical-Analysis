// Spencer Fajardo
// September 12, 2018
// Newton's Method, but modified for faster convergence

// This method is written with f(x) = x^3 - 2x - 5

// Note that the Modified Newton's Method finds a solution within an error of
// .000000000001 using just one iteration

public class ModifiedNewtonsMethod
{
    /**
    * This method evaluates the desired function. Makes changing functions easier.
    * Currently set to evaluate x^3 - 2x - 5
    * @param x     the point at which f needs to be evaluated
    * @return      returns the computed value f(x)
    **/
    public static double evalFx(double x)
    {
        return Math.pow(x,3) - (2 * x) - 5;
    }
    
    /**
    * This method computes the derivative of f(x)
    * currently set to evaluate f'(x) = 3x^2 - 2
    * @param x    the value at which f needs to be evaluated
    * @return     returns f'(x)
    **/
    public static double evalFprime(double x)
    {
        return (3 * Math.pow(x,2)) - 2;
    }
    
    /**
    * This method evaluates the second derivate of f(x)
    * @param x     the value at which f needs to be evaluated
    **/
    public static double evalSecondDerivative(double x)
    {
        return 6 * x;
    }
    
    /**
    * This method computes an approximation to the equation f(x) = 0
    * using newton's method, but modified for faster convergence.
    * @param p0         this is an initial guess to f(p0) = 0
    * @param TOL        this is the desired tolerance of error
    * @param maxItr     this is the max number of iterations to perform, if a solution is not found, throws illegalargumentexception
    * @return           returns the approximated solution to f(x) = 0
    **/
    public static double modifiedNewtonsMethod(double p0, double TOL, int maxItr)
    {
        int itr = 1;
        while(itr < maxItr)
        {
            double numerator = evalFx(p0) * evalFprime(p0);
            double denominator = (evalFprime(p0) * evalFprime(p0)) - ( evalFx(p0) * evalSecondDerivative(p0));
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
        int testItr = 7;

        System.out.println("The solution found for the equation f(x) = 0 is: " + modifiedNewtonsMethod(testP,TOL,testItr));
    }
}
