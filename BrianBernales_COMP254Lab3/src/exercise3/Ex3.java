package exercise3;
import java.io.File;
import java.util.Scanner;

public class Ex3 {
	static void find(File f, String name) {
	    if (f == null || !f.exists()) return;
	    if (f.isFile()) { 
	      if (f.getName().equals(name)) System.out.println(f.getAbsolutePath()); 
	      return; 
	    }
	    File[] kids = f.listFiles(); 
	    if (kids == null) return;
	    for (File k : kids) find(k, name);
	  }

	  	public static void main(String[] args) {
		    Scanner in = new Scanner(System.in);
		    System.out.print("Start path: ");
		    File start = new File(in.nextLine());
		    System.out.print("File name: ");
		    String name = in.nextLine();
		    System.out.println("Matches:");
		    find(start, name);
		  }
}