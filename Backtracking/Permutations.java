class Permutations {
     public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentResult = new ArrayList<>();
        boolean[] container = new boolean[nums.length];
        backtrack(nums, result, currentResult, container);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> currentResult, boolean[] container) {

        if (currentResult.size() == nums.length) {
            result.add(new ArrayList<>(currentResult));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (container[i]) {
                continue;
            }
            currentResult.add(nums[i]);
            container[i] = true;
            backtrack(nums, result, currentResult, container);
            currentResult.remove(currentResult.size() - 1);
            container[i] = false;
        }
    }
}
