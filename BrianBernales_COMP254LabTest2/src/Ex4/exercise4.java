package Ex4;

public class exercise4 {
    static class ArrayStack<E> {
        Object[] a = new Object[16];
        int t = 0;
        boolean isEmpty() { return t == 0; }
        void push(E e) { if (t == a.length) grow(); a[t++] = e; }
        @SuppressWarnings("unchecked") E pop() { return isEmpty() ? null : (E)a[--t]; }
        @SuppressWarnings("unchecked") E peek() { return isEmpty() ? null : (E)a[t - 1]; }
        void grow() { Object[] b = new Object[a.length * 2]; System.arraycopy(a, 0, b, 0, a.length); a = b; }
    }

    static boolean isBalanced(String s) {
        ArrayStack<Character> st = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('||c=='['||c=='{') st.push(c);
            else if (c==')'||c==']'||c=='}') {
                if (st.isEmpty()) return false;
                char o = st.pop();
                if (!((o=='('&&c==')')||(o=='['&&c==']')||(o=='{'&&c=='}'))) return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String[] tests = {
            "((a+b)*[c-{d/e}])",
            "(a+b]",
            "((a+b)",
            "{[()]}",
            "([)]",
            "([]{})"
        };
        for (String x : tests) System.out.println(x + " -> " + isBalanced(x));
    }
}
