
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequent {

    class Node {

        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.value - b.value;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int kN = entry.getKey();
            int vN = entry.getValue();

            if (minHeap.size() < k) {
                minHeap.offer(new Node(kN, vN));
            } else {
                int top = minHeap.peek().value;
                if (vN > top) {
                    minHeap.poll();
                    minHeap.offer(new Node(kN, vN));
                }
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll().key;
        }

        return res;
    }
}
