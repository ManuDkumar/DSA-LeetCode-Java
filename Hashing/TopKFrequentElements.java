import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
public class TopKFrequentElements {
    @SuppressWarnings("unchecked")
    public int[] topKFrequent(int[] nums , int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length +1];
        for(int num : nums ){
            map.put(num , map.getOrDefault(num, 0)+1);
        }
        for(int key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency] == null)bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        int[] topFrequency = new int[k];
        int required = 0 ;
        for(int i = bucket.length - 1  ; i > 0 ; i--){
            if( bucket[i] == null)continue;
            for(int val : bucket[i]){
                if(required == k)break;
                topFrequency[required++] = val;
            }
        }
        return topFrequency;
    }
}
