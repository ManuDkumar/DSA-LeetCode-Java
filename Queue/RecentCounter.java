public class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter(){
        queue = new ArrayDeque<>();
    }
    public int ping(int t){

        while (!queue.isEmpty() && t - 3000 > queue.peek()) {
            queue.remove();
            System.out.println(queue +" " + queue.peek());
        }
        queue.add(t);
        System.out.println(queue +" " + queue.peek());
        return queue.size();

    }
}
