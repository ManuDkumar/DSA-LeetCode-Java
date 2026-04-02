class ReorganizeString {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                maxHeap.offer(new int[] {i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        while(maxHeap.size() >= 2) {
            int [] first = maxHeap.poll();
            int [] second = maxHeap.poll();

            result.append((char)(first[0] + 'a'));
            result.append((char)(second[0] + 'a'));

            if(--first[1] > 0) {
                maxHeap.offer(first);
            }
            if(--second[1] > 0) {
                maxHeap.offer(second);
            }
        }

        if(!maxHeap.isEmpty()){
            int[] last = maxHeap.poll();

            if(last[1] > 1) return "";
            result.append((char)(last[0] + 'a'));
        }

        return result.toString();
    }
}
