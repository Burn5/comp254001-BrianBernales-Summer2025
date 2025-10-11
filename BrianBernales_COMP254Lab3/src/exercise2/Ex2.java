package exercise2;
import java.util.Scanner;

public class Ex2 {
	  static boolean isPalindrome(String s) {
		    if (s.length() <= 1) return true;                        
		    if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
		    return isPalindrome(s.substring(1, s.length() - 1));     
		  }

		  public static void main(String[] args) {
		    Scanner in = new Scanner(System.in);
		    while (true) {
		      System.out.print("Enter a word (or 'quit'): ");
		      String s = in.nextLine();
		      if (s.equalsIgnoreCase("quit")) break;
		      System.out.println(isPalindrome(s) ? "Palindrome" : "Not a palindrome");
		    }
		  }
		}
