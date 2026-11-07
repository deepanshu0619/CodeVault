class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int guess = (low + high) / 2;

            if (nums[guess] == target) {
                return guess;
            }

            if (nums[guess] >= nums[low]) {

                if (target >= nums[low] && target < nums[guess]) {
                    high = guess - 1;
                } else {
                    low = guess + 1;
                }

            } else {

                if (target > nums[guess] && target <= nums[high]) {
                    low = guess + 1;
                } else {
                    high = guess - 1;
                }
            }
        }

        return -1;
    }
}