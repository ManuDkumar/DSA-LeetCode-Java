class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if ((j - i) <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        List<List<String>> list = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(dp, 0, current, list, s);
        return list;
    }

    public void backtrack(boolean[][] dp, int start, List<String> curent, List<List<String>> list, String s) {
        if (start >= s.length()) {
            list.add(new ArrayList<>(curent));
            return;
        }

       for(int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                curent.add(s.substring(start, end + 1));
                backtrack(dp, end + 1, curent, list, s);
                curent.remove(curent.size() - 1);
            }
       }
    }
}
