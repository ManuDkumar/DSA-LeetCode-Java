class DecodeWays {
     public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; 
        dp[1] = 1; 

        for (int i = 2; i <= n; i++) {
            char currentChar = s.charAt(i - 1);
            char previousChar = s.charAt(i - 2);
            if (currentChar != '0') {
                dp[i] += dp[i - 1];
            }
            int twoDigitNumber = (previousChar - '0') * 10 + (currentChar - '0');
            if (twoDigitNumber >= 10 && twoDigitNumber <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
