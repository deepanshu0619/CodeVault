class Solution {
    public boolean canJump(int[] nums) {
        int power = 0; // farthest index we can reach

        for (int i = 0; i < nums.length; i++) {
            if (i > power) {
                return false; // if current index is not reachable
            }
            power = Math.max(power, i + nums[i]); // update farthest reach
        }

        return true; // if loop finishes, last index is reachable
    }
}
