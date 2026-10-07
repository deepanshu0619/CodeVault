class Solution {

    int steps(int i, int n, int[] dp) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int one = steps(i + 1, n, dp);
        int two = steps(i + 2, n, dp);

        return dp[i] = one + two;
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return steps(0, n, dp);
    }
}