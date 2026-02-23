public class PartitionEqualSubsetSum {
    public boolean subset(int[] nums, int sum) {
        boolean dp[][] = new boolean[nums.length + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for(int j = 1; j <= sum; j++){
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length][sum];
    }
    public boolean canPartition(int[] nums) {
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return subset(nums, (int)sum/2);
    }
}
