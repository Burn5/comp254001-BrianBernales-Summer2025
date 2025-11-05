package exercise2;

import java.util.Stack;

public class Ex2 {
    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        while (!S.isEmpty()) T.push(S.pop());
    }

    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        Stack<Integer> T = new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);
        transfer(S, T);
        System.out.println(T);      // [3, 2, 1]
        System.out.println(T.peek()); // 1
        System.out.println(S.isEmpty()); // true
    }
}
