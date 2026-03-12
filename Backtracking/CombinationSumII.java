class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSum = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, result, currentSum, target);
        return result;
    }
 
    public void backtrack(int start, int[] candidates, List<List<Integer>> result, List<Integer> currentSum, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(currentSum));
            return;
        }
        if (target < 0 ) {
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currentSum.add(candidates[i]);
            backtrack(i + 1, candidates, result, currentSum, target - candidates[i]);
            currentSum.remove(currentSum.size() - 1);
        } 
    }
}
