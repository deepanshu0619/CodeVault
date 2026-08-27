class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int maxcurrsum = nums[0];
        int maxsubarraysum = nums[0];

        int mincurrsum = nums[0];
        int minsubarraysum = nums[0];

        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            totalSum += nums[i];

            // Normal maximum subarray
            maxcurrsum = Math.max(nums[i], maxcurrsum + nums[i]);
            maxsubarraysum = Math.max(maxsubarraysum, maxcurrsum);

            // Minimum subarray
            mincurrsum = Math.min(nums[i], mincurrsum + nums[i]);
            minsubarraysum = Math.min(minsubarraysum, mincurrsum);
        }

        // All elements are negative
        if (maxsubarraysum < 0) {
            return maxsubarraysum;
        }

        // Circular maximum
        int circularSum = totalSum - minsubarraysum;

        return Math.max(maxsubarraysum, circularSum);
    }
}