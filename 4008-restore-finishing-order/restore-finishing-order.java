class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length; i++) map.put(order[i], i);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (map.get(x) - map.get(y)));
        for (int friend: friends) pq.offer(friend);
        int[] res = new int[pq.size()];
        int index = 0;
        while (!pq.isEmpty()) res[index++] = pq.poll();
        return res;
    }
}