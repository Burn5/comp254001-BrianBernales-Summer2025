package exercise2;
import java.util.LinkedList;
import java.util.Queue;

public class Ex2 {

    private static Queue<Integer> mergeTwoQueues(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                result.add(q1.remove());
            } else {
                result.add(q2.remove());
            }
        }

        while (!q1.isEmpty()) {
            result.add(q1.remove());
        }

        while (!q2.isEmpty()) {
            result.add(q2.remove());
        }

        return result;
    }

    public static Queue<Integer> bottomUpMergeSort(int[] data) {
        Queue<Queue<Integer>> mainQueue = new LinkedList<>();

        for (int x : data) {
            Queue<Integer> single = new LinkedList<>();
            single.add(x);
            mainQueue.add(single);
        }

        while (mainQueue.size() > 1) {
            Queue<Integer> q1 = mainQueue.remove();
            Queue<Integer> q2 = mainQueue.remove();
            Queue<Integer> merged = mergeTwoQueues(q1, q2);
            mainQueue.add(merged);
        }

        return mainQueue.remove();
    }

    public static void main(String[] args) {
        int[] data = {7, 3, 9, 1, 5, 8, 2, 4, 6};

        System.out.print("Original: ");
        for (int x : data) {
            System.out.print(x + " ");
        }
        System.out.println();

        Queue<Integer> sortedQueue = bottomUpMergeSort(data);

        System.out.print("Sorted:   ");
        while (!sortedQueue.isEmpty()) {
            System.out.print(sortedQueue.remove() + " ");
        }
        System.out.println();
    }
}
