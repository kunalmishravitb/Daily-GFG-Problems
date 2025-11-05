class Solution {
    public int minSquares(int n) {
        int[] dp = new int[n + 1]; // dp[x] = minimum number of perfect squares required to make sum = x
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0; // base initialization when n = 0 => min perfect sq = 0
        for (int i = 1; i * i <= n; i++) { // upto i*i <= n
            for (int j = i * i; j <= n; j++) { // update all dp values >= square
                int steps = 1 + dp[j - i * i]; // count this step and go for remaining
                dp[j] = Math.min(steps, dp[j]); // update min
            }
        }
        return dp[n]; // min perfect squares to represent n
    }
}