package exercise1;

public class Exercises {

	  /* one pass summing all elements */
	  public static int example1(int[] arr) {
	    int total = 0;
	    for (int v : arr) total += v;
	    return total;
	  }

	  /* n/2 iterations (still linear). */
	  public static int example2(int[] arr) {
	    int total = 0;
	    for (int j = 0; j < arr.length; j += 2) total += arr[j];
	    return total;
	  }

	  /* inner sum grows with j, totaling. */
	  public static double[] example3(double[] x) {
	    int n = x.length;
	    double[] a = new double[n];
	    for (int j = 0; j < n; j++) {
	      double total = 0;
	      for (int i = 0; i <= j; i++) total += x[i];
	      a[j] = total / (j + 1);
	    }
	    return a;
	  }

	  /* single pass using running prefix sums. */
	  public static int example4(int[] first) {
	    int total = 0, prefix = 0;
	    for (int v : first) {
	      prefix += v;
	      total += prefix;
	    }
	    return total;
	  }

	  /* three nested loops dominate. */
	  public static int example5(int[] first, int[] second) {
	    int n = first.length, count = 0;
	    for (int i = 0; i < n; i++) {
	      int total = 0;
	      for (int j = 0; j < n; j++)
	        for (int k = 0; k <= j; k++)
	          total += first[k];
	      if (second[i] == total) count++;
	    }
	    return count;
	  }

	  public static void main(String[] args) {
	    int[] a = {1,2,3,4};
	    int[] b = {10,20,30,40};
	    System.out.println(example1(a));
	    System.out.println(example2(a));
	    System.out.println(example4(a));
	    System.out.println(example5(a,b));
	  }
	}