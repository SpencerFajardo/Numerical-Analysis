// Spencer Fajardo
// September 8, 2018

/**
 * The Nth Taylor polynomial for f (x) = ln x expanded about x0 = 1 is
 PN(x) =
 N
 i=1
 (−1)i+1
 i (x − 1)
 i
 ,
 and the value of ln 1.5 to eight decimal places is 0.40546511. Construct an algorithm to
 determine the minimal value of N required for
 | ln 1.5 − PN(1.5)| < 10−5
 ,
 without using the Taylor polynomial remainder term.
 */

public class LnTaylorPolynomial
{
    public static int nthDegreeNeeded(double x, double TOL, int maxItr)
    {
        int nthDegree = 1;
        double y = x - 1;
        double SUM = 0;
        double POWER = y;
        double TERM = y;
        double SIGN = -1;

        while(nthDegree < maxItr)
        {
            SIGN = - SIGN;
            SUM = SUM + SIGN*TERM;
            POWER = POWER * y;
            TERM = POWER/(nthDegree+1);

            if(TERM < TOL)
            {
                return nthDegree;
            }

            nthDegree++;
        }

        throw new IllegalArgumentException("Value computed not under tolerance using " + maxItr + " terms");

    }
    public static void main(String[] args)
    {

        double testX = 1.5;
        double testTOL = .0001;
        int testItr = 15;
        System.out.println(nthDegreeNeeded(testX,testTOL,testItr));

    }
}
