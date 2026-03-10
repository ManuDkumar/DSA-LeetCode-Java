import java.util.ArrayList;
import java.util.List;
class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(nums, 0, result, subset);
        return result;
    }
    public void backtrack(int[] nums, int n, List<List<Integer>> result, List<Integer> subset) {
        if(n >= nums.length) {
            result.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[n]);
        backtrack(nums, n + 1, result, subset);
        subset.remove(subset.size() - 1);
        backtrack(nums, n + 1, result, subset);
    }
}
