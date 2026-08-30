class Solution {
    public int pivotIndex(int[] nums) {

        int left = 0;
        int sum = 0;
        int n = nums.length;

        // Total sum
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // Check every index
        for (int i = 0; i < n; i++) {

            int right = sum - left - nums[i];

            if (left == right) {
                return i;
            }

            left += nums[i];
        }

        return -1;
    }
}