import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, result, subset);
        return result;
    }

    public void backtrack(int[] nums, int start, List<List<Integer>> result, List<Integer> subset) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1])
                continue;

            subset.add(nums[i]);
            backtrack(nums, i + 1, result, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
