import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
class Pair<k,v> {
    private k key;
    private v val;

    public Pair(k key,v val){
        this.key = key;
        this.val = val;
    }
    public k getKey() {
        return key;
    }
    public v getVal() {
        return val;
    } 
}
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        HashSet<String> hash = new HashSet<>(wordList);
        Queue<Pair<String,Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(beginWord, 1));
        hash.remove(beginWord);

        while (! queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String currentWord = pair.getKey();
            int steps = pair.getVal();

            if (currentWord.equals(endWord)) {
                return steps;
            }
            char[] arr = currentWord.toCharArray();
            for(int i = 0; i < arr.length ; i++){
                char original = arr[i];
                for(char j = 'a' ; j <= 'z' ; j++){
                    arr[i] = j;
                    String newWord = new String(arr);
                    if (hash.contains(newWord)) {
                        queue.offer(new Pair<>(newWord, steps + 1));
                        hash.remove(newWord);
                    }
                }
                arr[i] = original;
            }
        }
        return 0 ;
    }
}
