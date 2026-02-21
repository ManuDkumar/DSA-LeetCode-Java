public class CoinChange {
  public int coinChange(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int a = 0 ; a<= amount; a++){
            if (a % coins[0] == 0) {
                dp[0][a] = a/coins[0];
            }
            else dp[0][a] = (int)1e9;
        }
        for(int ind = 1; ind < n; ind++){
            for(int a = 0; a <= amount; a++){
                int notpick = dp[ind - 1][a];
                int pick = (int)1e9;
                if (coins[ind] <= a) {
                    pick = 1 + dp[ind][a - coins[ind]];
                }
                dp[ind][a] = Math.min(notpick, pick);
            }
        }
        int ans = dp[n - 1][amount];
        if (ans >= (int)1e9) {
            return -1;
        }
        return ans;
    }
}
