/**
 * @author Spencer Fajardo
 * September 17, 2018
 * This method evaluates a polynomial (given by a coefficient array) at a given point x
 */

import java.util.Scanner;
public class HornersMethod
{
    /**
     *
     * @param coefficients    this is an array of doubles that represents the coefficients
     *                        of the polynomial. The first element of the array needs to be
     *                        the coefficient of the largest degree term, and then in order
     *                        descending.
     * @param x               the initial point used as an approximation
     * @return
     */
    public static double hornersMethod(double[] coefficients, double x)
    {

        double result = coefficients[0];
        for(int i = 1; i < coefficients.length; i++)
        {
            result = result * x + coefficients[i];
        }

        return result;
    }

    public static void main(String[] args)
    {

        double[] poly = {2, -6, 2, -1};
        double x = 3;
        System.out.println("The value of the polynomial is: " + hornersMethod(poly,x));
    }
}
