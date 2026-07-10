import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // Sort the elements
        Arrays.sort(nums);

        int resultSum = nums[0] + nums[1] + nums[2];
        int minDifference = Integer.MAX_VALUE;

        // Now fix the first element and find the other two elements
        for (int i = 0; i < nums.length - 2; i++) {

            // Find other two elements using Two Sum approach
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target)
                    return target;

                if (sum < target)
                    left++;
                else
                    right--;

                int diffToTarget = Math.abs(sum - target);

                if (diffToTarget < minDifference) {
                    // update the result sum
                    resultSum = sum;
                    minDifference = diffToTarget;
                }
            }
        }

        return resultSum;
    }
}