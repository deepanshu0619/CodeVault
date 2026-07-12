class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;

        int left = -1;
        int right = -1;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Traverse from left to right
        for (int i = 0; i < n; i++) {

            if (nums[i] >= max)
                max = nums[i];
            else
                right = i;
        }

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            if (nums[i] <= min)
                min = nums[i];
            else
                left = i;
        }

        if (right == -1)
            return 0;

        return right - left + 1;
    }
}