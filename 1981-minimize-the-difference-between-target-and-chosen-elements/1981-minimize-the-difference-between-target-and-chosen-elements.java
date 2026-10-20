class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;

        boolean[] dp = new boolean[4901];
        dp[0] = true;

        for (int i = 0; i < m; i++) {
            boolean[] next = new boolean[4901];

            for (int sum = 0; sum <= 4900; sum++) {
                if (dp[sum]) {
                    for (int num : mat[i]) {
                        if (sum + num <= 4900) {
                            next[sum + num] = true;
                        }
                    }
                }
            }

            dp = next;
        }

        int ans = Integer.MAX_VALUE;

        for (int sum = 0; sum <= 4900; sum++) {
            if (dp[sum]) {
                ans = Math.min(ans, Math.abs(target - sum));
            }
        }

        return ans;
    }
}