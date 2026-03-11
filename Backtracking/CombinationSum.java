class CombinationSum {
      public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSum = new ArrayList<>();
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
            currentSum.add(candidates[i]);
            backtrack(i, candidates, result, currentSum, target - candidates[i]);
            currentSum.remove(currentSum.size() - 1);
        } 
    }

}
