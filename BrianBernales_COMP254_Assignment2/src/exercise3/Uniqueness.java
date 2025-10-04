package exercise3;
import java.util.Arrays;
import java.util.Random;

public class Uniqueness {

  /** O(n^2): check all pairs for duplicates. */
  public static boolean unique1(int[] data) {
    int n = data.length;
    for (int j = 0; j < n - 1; j++)
      for (int k = j + 1; k < n; k++)
        if (data[j] == data[k]) return false;
    return true;
  }

  /** O(n log n): sort then scan neighbors. */
  public static boolean unique2(int[] data) {
    int[] temp = Arrays.copyOf(data, data.length);
    Arrays.sort(temp);
    for (int j = 0; j < temp.length - 1; j++)
      if (temp[j] == temp[j + 1]) return false;
    return true;
  }

  private static long timeOnce(Runnable r) {
    long t1 = System.currentTimeMillis();
    r.run();
    return System.currentTimeMillis() - t1;
    }

  public static int maxNWithinMillis(boolean useUnique1, long limitMillis, boolean quick) {
    Random rnd = new Random(123);
    long cap = quick ? Math.min(limitMillis, 5000) : limitMillis;

    java.util.function.IntFunction<int[]> gen = (n) -> {
      int[] a = new int[n];
      for (int i = 0; i < n; i++) a[i] = rnd.nextInt();
      return a;
    };
    java.util.function.Predicate<int[]> algo = useUnique1 ? Uniqueness::unique1 : Uniqueness::unique2;

    int low = 1000, high = low;
    long t;
    while (true) {
      int[] arr = gen.apply(high);
      t = timeOnce(() -> algo.test(arr));
      if (t > cap) break;
      low = high;
      high *= 2;
      if (high > 100_000_000) break;
    }

    int best = low, lo = low, hi = Math.max(high, low + 1);
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int[] arr = gen.apply(mid);
      t = timeOnce(() -> algo.test(arr));
      if (t <= cap) { best = mid; lo = mid + 1; }
      else { hi = mid - 1; }
    }
    return best;
  }

  public static void main(String[] args) {
    long limit = 60_000;
    boolean quick = true;
    int n1 = maxNWithinMillis(true,  limit, quick);
    int n2 = maxNWithinMillis(false, limit, quick);
    System.out.println("unique1 n≈" + n1);
    System.out.println("unique2 n≈" + n2);
  }
}
