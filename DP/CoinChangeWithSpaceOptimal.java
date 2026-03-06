class CoinChangeWithSpaceOptimal {
  public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int a = 1; a <= amount; a++) {
            dp[a] = (int)1e9;
        }
        for (int coin : coins) {
            for(int a = coin; a <= amount; a++) {
                dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
            }
        }
        if (dp[amount] >= (int)1e9) {
            return -1;
        }
        return dp[amount];
    }
}
