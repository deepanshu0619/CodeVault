class Solution {
    static Boolean[][] dp;

    static boolean solve(int target, int[] nums, int index) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;

        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean include = solve(target - nums[index], nums, index + 1);
        boolean exclude = solve(target, nums, index + 1);

        return dp[index][target] = include || exclude;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        dp = new Boolean[nums.length][target + 1];

        return solve(target, nums, 0);
    }
}