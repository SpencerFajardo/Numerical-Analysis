/**
 * @author Spencer Fajardo
 * September 30, 2018
 * This method approximates a polynomial's value at a given point by using information from the polynomial
 */


import java.util.Arrays;

public class NevilleMethod
{
    /**
     * Neville's Method computes an approximation of a polynomial at a value. It does this by using information
     * from the polynomial, and makes a best fit.
     * For example, to compute an appromxiation of ln(2.1),
     * input arr1 = {2.0, 2.2, 2.3}
     * input arr2 = {0.6931, 0.7885, 0.8329}
     * input x = 2.1
     * this returns a value of about 0.7419, which agrees with ln(2.1) to 4 decimal places.
     *
     * Note: the lengths of arr1 and arr2 must agree with each other.
     *
     * @param arr1     arr1 is the array of x values used for f(x)
     * @param arr2     arr2 is the array of values computed from f(x), corresponding to the x's in arr1
     * @param x        the point at which you want an approximation
     * @return         returns the double value computed as the approximation
     */
    public static double nevilleMethod(double[] arr1, double[] arr2, double x)
    {

        for(int j = 1; j < arr1.length; j++)
        {
            for(int i = arr1.length - 1; i >= j; i--)
            {

                arr2[i] = ( (x-arr1[i-j])*arr2[i] - (x-arr1[i])*arr2[i-1] ) / ( arr1[i] - arr1[i-j] );
            }
        }

        return arr2[arr1.length-1];

    }

    public static void main(String[] args)
    {

        double[] x = {2,2.2,2.3};
        double[] y = {.6931,.7885,.8329};
        System.out.println(nevilleMethod(x,y,2.1));


    }
}
