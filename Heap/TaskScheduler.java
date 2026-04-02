class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a );
        Queue<int[]> waitList = new ArrayDeque<>();
        

        for(char task : tasks) {
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }

        for(char key : frequency.keySet()) {
            maxHeap.offer(frequency.get(key));
        }

        int time = 0;

        while(!maxHeap.isEmpty() || !waitList.isEmpty()) {

            while(!waitList.isEmpty() && waitList.peek()[1] <= time) {
                maxHeap.offer(waitList.poll()[0]);
            }

            if(!maxHeap.isEmpty()){
                int remainingCount = maxHeap.poll() - 1;
                
                if(remainingCount > 0) {
                    waitList.offer(new int[] {remainingCount, time + n + 1});
                }
            }
            time++;
        }
        return time;
    }
}
