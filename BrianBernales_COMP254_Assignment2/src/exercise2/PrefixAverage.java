package exercise2;
import java.util.Random;

public class PrefixAverage {

  /** O(n^2): re-sum the prefix for each index. */
  public static double[] prefixAverage1(double[] x) {
    int n = x.length;
    double[] a = new double[n];
    for (int j = 0; j < n; j++) {
      double total = 0;
      for (int i = 0; i <= j; i++) total += x[i];
      a[j] = total / (j + 1);
    }
    return a;
  }

  /** O(n): maintain a running prefix sum. */
  public static double[] prefixAverage2(double[] x) {
    int n = x.length;
    double[] a = new double[n];
    double total = 0;
    for (int j = 0; j < n; j++) {
      total += x[j];
      a[j] = total / (j + 1);
    }
    return a;
  }

  public static void main(String[] args) {
    int start = 1000, trials = 7;
    Random rnd = new Random(42);
    System.out.println("n,ms_prefixAverage1,ms_prefixAverage2");
    int n = start;
    for (int t = 0; t < trials; t++) {
      double[] x = new double[n];
      for (int i = 0; i < n; i++) x[i] = rnd.nextDouble();

      long t1 = System.currentTimeMillis();
      prefixAverage1(x);
      long t2 = System.currentTimeMillis();
      prefixAverage2(x);
      long t3 = System.currentTimeMillis();
      System.out.printf("%d,%d,%d%n", n, (t2 - t1), (t3 - t2));
      n *= 2;
    }
  }
}