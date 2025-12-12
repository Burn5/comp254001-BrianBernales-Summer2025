package Ex3;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

public class exercise3 {
    static class Account {
        int accountNumber;
        String customerName;
        double accountBalance;
        Account(int n, String name, double bal) { accountNumber = n; customerName = name; accountBalance = bal; }
        public String toString() { return accountNumber + " " + customerName + " " + accountBalance; }
    }

    static <E> void quickSort(Queue<E> q, Comparator<E> c) {
        if (q.size() < 2) return;
        E p = q.remove();
        Queue<E> l = new ArrayDeque<>(), e = new ArrayDeque<>(), g = new ArrayDeque<>();
        e.add(p);
        while (!q.isEmpty()) {
            E x = q.remove();
            int r = c.compare(x, p);
            if (r < 0) l.add(x); else if (r == 0) e.add(x); else g.add(x);
        }
        quickSort(l, c);
        quickSort(g, c);
        while (!l.isEmpty()) q.add(l.remove());
        while (!e.isEmpty()) q.add(e.remove());
        while (!g.isEmpty()) q.add(g.remove());
    }

    public static void main(String[] args) {
        Queue<Account> q = new ArrayDeque<>();
        q.add(new Account(1003, "Cathy", 1200.50));
        q.add(new Account(1001, "Alex", 5000.00));
        q.add(new Account(1005, "Brian", 1200.50));
        q.add(new Account(1002, "Dylan", 300.00));
        q.add(new Account(1004, "Emma", 2500.75));

        quickSort(q, (a, b) -> Double.compare(a.accountBalance, b.accountBalance));

        while (!q.isEmpty()) System.out.println(q.remove());
    }
}
