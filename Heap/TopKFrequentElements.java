class TopKFrequentElements {
  public int[] topKfrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->Integer.compare(map.get(a), map.get(b)));
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] ans = new int[k];
        while (!minHeap.isEmpty()) {
            ans[--k] = minHeap.poll();
        }
        return ans;
    }
}
