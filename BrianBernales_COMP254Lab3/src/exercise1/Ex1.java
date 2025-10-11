package exercise1;
import java.util.Scanner;

public class Ex1{
	  // multiply m by n using recursion and only +/- 
	  static int product(int m, int n) {
	    if (n == 0) return 0;        
	    return m + product(m, n - 1);
	  }

	  public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    System.out.print("Enter m and n (positive integers): ");
	    int m = in.nextInt(), n = in.nextInt();
	    System.out.println("product = " + product(m, n));
	  }
	}